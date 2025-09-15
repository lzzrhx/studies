package tdee.components.physics;

import tdee.Entity;
import tdee.components.Component;
import tdee.Logger;
import tdee.Program;
import tdee.Draw3;

import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Physics implements Component {

    // Objektvariabler
    Entity parent;

    // Fysikkvariabler
    private CollisionShape shape;
    private Vector3 force = new Vector3();
    private Vector3 acc = new Vector3();
    private Vector3 vel = new Vector3();
    private float mass;
    private float invM;
    private Vector3 torque = new Vector3();
    private Vector3 angAcc = new Vector3();
    private Vector3 angVel = new Vector3();
    private float restitution;
    private float friction;
    
    // Statiske fysikkvariabler
    private static final Vector3 g = new Vector3().y(-9.8f);

    // Konstruktør for kube
    public Physics(Entity parent, Vector3 size, float mass, float restitution, float friction) {
        this.parent = parent;
        this.shape = new Cube(this, size);
        this.restitution = restitution;
        this.friction = friction;
        mass(mass);
    }
    
    // Konstruktør for kule
    public Physics(Entity parent, float radius, float mass, float restitution, float friction) {
        this.parent = parent;
        this.shape = new Sphere(this, radius);
        this.restitution = restitution;
        this.friction = friction;
        mass(mass);
    }

    // Getter for parent
    public Entity parent() {
        return parent;
    }

    // Getter for vel
    public Vector3 vel() {
        return vel;
    }
    
    // Getter for ang vel
    public Vector3 angVel() {
        return angVel;
    }

    // Oppdatering av masse
    private void mass(float mass) {
        this.mass = mass;
        this.invM = mass > 0.0001f ? 1f / mass : 0f;
    }
    
    // Legg til kraft på legemet med Vector3 koordinater relativt til legemets rotasjon
    public void addForceRel(Vector3 force) {
        addForce(Vector3Transform(force, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(parent.rot()))));
    }

    // Legg til kraft på legemet
    public void addForce(Vector3 force) {
        this.force = Vector3Add(this.force, force);
    }
    
    // Legg til moment på legemet med Vector3 koordinater relativt til legemets rotasjon
    public void addTorqueRel(Vector3 torque) {
        addTorque(Vector3Transform(torque, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(parent.rot()))));
    }
    
    // Legg til moment på legemet
    public void addTorque(Vector3 torque) {
        this.torque = Vector3Add(this.torque, torque);
    }

    // Legg til lineær impuls
    public void applyImpulseLinear(Vector3 j) {
        vel = Vector3Add(vel, Vector3Scale(j, invM));
    }
    
    // Legg til rotasjonsimpuls
    public void applyImpulseAngular(Vector3 j) {
        angVel = Vector3Add(angVel, Vector3Scale(j, invM));
    }
    
    // Legg til impuls på et gitt punkt, med lineær og rotasjon
    public void applyImpulseAtPoint(Vector3 j, Vector3 r) {
        applyImpulseLinear(j);
        angVel = Vector3Add(angVel, Vector3Scale(Vector3CrossProduct(r, j), invM));
    }

    // Legg til gravitasjonskraft
    private void forceGravity() {
        addForce(Vector3Scale(g, mass));
    }

    // Tegning av 3D grafikk
    public void render3() {
        shape.render3(WHITE);
    }
    
    // Oppdatering
    public void update(float dt) {
        if (invM > 0f) {
            // Legg til eksterne krefter fra omgivelsene
            //forceGravity();
            // Akselerasjon er lik krefter delt på masse (F = ma  ->  a = F / m  ->  a = F * (1 / m))
            acc = Vector3Scale(force, invM);
            // Integrer akselerasjon over tid for å finne endring i fart fart (v = at)
            vel = Vector3Add(vel, Vector3Scale(acc, dt));
            // Integrer fart over tid for å finne endring i posisjon (t = vt)
            parent.pos(Vector3Add(parent.pos(), Vector3Scale(vel, dt)));
            // Nullstill krefter som virker på legemet
            force = Vector3Zero();
            // Rotasjonsakselerasjon er like moment delt på masse
            angAcc = Vector3Scale(torque, invM);
            // Integrer rotasjonsakselerasjon over tid for å finne rotasjonshastighet
            angVel = Vector3Add(angVel, Vector3Scale(angAcc, dt));
            // Integrer rotasjonshastighet over tid for å finne endring i rotasjon
            parent.rot(Vector3Add(parent.rot(), Vector3Scale(angVel, dt)));
            // Nullstill moment
            torque = Vector3Zero();
            // Oppdatering av kollisjons geometri
            shape.update();
        }
    }
    
    // Sjekk kollisjon
    public void checkCollision() {
        Entity a = parent;
        Entity.entities().forEach( b -> {
            if (b != a && b.physics != null) {
                // Sjekk kule / kule kollisjon
                if (a.physics.shape instanceof Sphere && b.physics.shape instanceof Sphere) {
                    checkCollisionSphereSphere(a, b);
                }
                // Sjekk kube / kube kollisjon
                else if (a.physics.shape instanceof Cube && b.physics.shape instanceof Cube) {
                    checkCollisionCubeCube(a, b);
                }
                // Sjekk kube / kule kollisjon
                else if (a.physics.shape instanceof Cube && b.physics.shape instanceof Sphere) {
                    checkCollisionCubeSphere(a, b);
                }
                // Sjekk kule / kube kollisjon
                else if (a.physics.shape instanceof Sphere && b.physics.shape instanceof Cube) {
                    checkCollisionCubeSphere(b, a);
                }
            }
        });
    }    
    
    // Kule / Kule kollisjon
    private static void checkCollisionSphereSphere(Entity a, Entity b) {
        Sphere aSphere = (Sphere)a.physics.shape;
        Sphere bSphere = (Sphere)b.physics.shape;
        float aRadius = aSphere.radius();
        float bRadius = bSphere.radius();
        Vector3 normal = Vector3Subtract(b.pos(), a.pos());
        if (Vector3LengthSqr(normal) <= (aRadius + bRadius) * (aRadius + bRadius)) {
            // Kontakt detaljer
            normal = Vector3Normalize(normal);
            Vector3 start = Vector3Subtract(b.pos(), Vector3Scale(normal, bRadius));
            Vector3 end = Vector3Add(a.pos(), Vector3Scale(normal, aRadius));
            float depth = Vector3Length(Vector3Subtract(end, start));
            // Løs penetrasjon og kollisjon
            resolvePenetration(a, b, normal, depth);
            resolveCollision(a, b, normal);
        }
    }

    // TODO: må gjøres bedre:
    // OBB / OBB kollisjonsjekk ved bruk av Separating Axis Theorem algoritme
    private static void checkCollisionCubeCube(Entity a, Entity b) {
        Cube aCube = (Cube)a.physics.shape;
        Cube bCube = (Cube)b.physics.shape;
        // Definer 15 akser som skal sjekkes
        Vector3[] axes = new Vector3[15];
        axes[0]  = Vector3Normalize(Vector3Subtract(aCube.vertsWorld()[1], aCube.vertsWorld()[0]));
        axes[1]  = Vector3Normalize(Vector3Subtract(aCube.vertsWorld()[3], aCube.vertsWorld()[0]));
        axes[2]  = Vector3Normalize(Vector3Subtract(aCube.vertsWorld()[4], aCube.vertsWorld()[3]));
        axes[3]  = Vector3Normalize(Vector3Subtract(bCube.vertsWorld()[1], bCube.vertsWorld()[0]));
        axes[4]  = Vector3Normalize(Vector3Subtract(bCube.vertsWorld()[3], bCube.vertsWorld()[0]));
        axes[5]  = Vector3Normalize(Vector3Subtract(bCube.vertsWorld()[4], bCube.vertsWorld()[3]));
        axes[6]  = Vector3CrossProduct(axes[0], axes[3]);
        axes[7]  = Vector3CrossProduct(axes[0], axes[4]);
        axes[8]  = Vector3CrossProduct(axes[0], axes[5]);
        axes[9]  = Vector3CrossProduct(axes[1], axes[3]);
        axes[10] = Vector3CrossProduct(axes[1], axes[4]);
        axes[11] = Vector3CrossProduct(axes[1], axes[5]);
        axes[12] = Vector3CrossProduct(axes[2], axes[3]);
        axes[13] = Vector3CrossProduct(axes[2], axes[4]);
        axes[14] = Vector3CrossProduct(axes[2], axes[5]);
        int normalIndex = 0;
        // Let etter separasjon mellom a og b på alle 15 akser, anta kollisjon frem til separasjon er funnet
        boolean collision = true;
        Vector3 normal = Vector3Zero();
        float depth = Float.MAX_VALUE;
        for (int i = 0; i < 15; i++) {
            // Ungå sjekking på {0, 0, 0} aksene (akser med 0 i vektorprodukt mellom a og b normaler)
            if (Vector3Equals(axes[i], Vector3Zero()) == 0) {
                // Finn projeksjon for a og b på aksen
                float aMin = Float.MAX_VALUE;
                float aMax = -Float.MAX_VALUE;
                float bMin = Float.MAX_VALUE;
                float bMax = -Float.MAX_VALUE;
                for (int j = 0; j < 8; j++) {
                    float aProj = Vector3DotProduct(aCube.vertsWorld()[j], axes[i]);
                    if (aProj < aMin) { aMin = aProj; }
                    if (aProj > aMax) { aMax = aProj; }
                    float bProj = Vector3DotProduct(bCube.vertsWorld()[j], axes[i]);
                    if (bProj < bMin) { bMin = bProj; }
                    if (bProj > bMax) { bMax = bProj; }
                }
                // Sammenlign a og b projeksjonen og lagre overlapp
                float abProjLengthMerged = (aMax > bMax ? aMax : bMax) - (aMin < bMin ? aMin : bMin);
                float abProjLength = aMax - aMin + bMax - bMin;
                float abProjOverlap = abProjLength - abProjLengthMerged;                
                float abDepth = (aMax < bMax) ? ( (aMin > bMin) ? (float)Math.min(aMax - bMin, bMax - aMin) : (abProjOverlap) ) : ( (bMin > aMin) ? (float)Math.min(bMax - aMin, aMax - bMin) : (abProjOverlap) );
                // Hvis overlapp er negativt er en akse med separasjon funnet og søket kan avsluttes
                if (abProjOverlap < 0f) { collision = false; break; }
                // Lagre informasjon om aksen med minst overlapp (aksen der kollisjon har funnet sted)
                else if (abDepth < depth) {
                    normalIndex = i; 
                    depth = abDepth;
                }
            }
        }
        // Løs kollisjonen
        if (collision == true) {
                normal = (Vector3DotProduct(b.pos(), axes[normalIndex]) > Vector3DotProduct(a.pos(), axes[normalIndex])) ? axes[normalIndex] : Vector3Negate(axes[normalIndex]);
                if (a.id() == 1) { Logger.log( GetTime() + " Collision! index: " + normalIndex + " depth: " + depth + " axis x: " + Float.toString(normal.x()) + " y:" + Float.toString(normal.y()) + " z:" + Float.toString(normal.z())); }
            if (Program.debugCollision) {
                resolvePenetration(a, b, normal, depth);
                resolveCollision(a, b, normal);
                //contactFriction(a, b);
            }
        }
    }
    
    // TODO: må gjøres bedre: mangler normal!
    // OBB / Kule kollisjonsjekk
    private static void checkCollisionCubeSphere(Entity a, Entity b) {
        Cube aCube = (Cube)a.physics.shape;
        Sphere bSphere = (Sphere)b.physics.shape;
        // Finn punktet på kuben som er nærmest kulen
        Vector3 abAxis = Vector3Normalize(Vector3Subtract(b.pos(), a.pos()));
        /*
        Vector3 aPoint = Vector3Zero();
        float pMax = -Float.MAX_VALUE;
        for (int j = 0; j < 8; j++) {
            float aProj = Vector3DotProduct(aCube.vertsWorld()[j], abAxis);
            if (aProj > pMax) { pMax = aProj; aPoint = aCube.vertsWorld()[j]; }
        }
        // Sjekk etter kollisjon på aksen mellom kulen og nærmeste punkt
        Vector3 pAxis = Vector3Normalize(Vector3Subtract(b.pos(), aPoint));
        */
        float aMin = Float.MAX_VALUE;
        float aMax = -Float.MAX_VALUE;
        for (int j = 0; j < 8; j++) {
            float aProj = Vector3DotProduct(aCube.vertsWorld()[j], abAxis);
            if (aProj < aMin) { aMin = aProj; }
            if (aProj > aMax) { aMax = aProj; }
        }
        float bMid = Vector3DotProduct(b.pos(), abAxis);
        float bMin = bMid - bSphere.radius();
        float bMax = bMid + bSphere.radius();
        // Sammenlign a og b projeksjonen og lagre overlapp
        float abProjLengthMerged = (aMax > bMax ? aMax : bMax) - (aMin < bMin ? aMin : bMin);
        float abProjLength = aMax - aMin + bMax - bMin;
        float abProjOverlap = abProjLength - abProjLengthMerged;                
        float depth = (aMax < bMax) ? ( (aMin > bMin) ? (float)Math.min(aMax - bMin, bMax - aMin) : (abProjOverlap) ) : ( (bMin > aMin) ? (float)Math.min(bMax - aMin, aMax - bMin) : (abProjOverlap) );
        if (abProjOverlap > 0f) {
            Vector3 normal = (Vector3DotProduct(b.pos(), abAxis) > Vector3DotProduct(a.pos(), abAxis)) ? abAxis : Vector3Negate(abAxis);
            if (a.id() == 1) { Logger.log( GetTime() + " Collision! depth: " + depth + " axis x: " + Float.toString(normal.x()) + " y:" + Float.toString(normal.y()) + " z:" + Float.toString(normal.z())); }
            if (Program.debugCollision) {
                resolvePenetration(a, b, normal, depth);
                resolveCollision(a, b, normal);
                //contactFriction(a, b);
            }
        }
    }
    
    // Løs penetrasjon med forflytting
    private static void resolvePenetration(Entity a, Entity b, Vector3 normal, float depth) {
        float da = depth / (a.physics.invM + b.physics.invM) * a.physics.invM;
        float db = depth / (a.physics.invM + b.physics.invM) * b.physics.invM;
        a.pos(Vector3Subtract(a.pos(), Vector3Scale(normal, da)));
        b.pos(Vector3Add(b.pos(), Vector3Scale(normal, db)));
    }
    
    // Løs kollisjon med impuls
    /*
    private static void resolveCollision(Entity a, Entity b, Vector3 normal) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(normal, impulseMag);
        a.physics.applyImpulseLinear(jn);
        b.physics.applyImpulseLinear(Vector3Negate(jn));
    }
    */
    private static void resolveCollision(Entity a, Entity b, Vector3 normal) {
        float e = (float)Math.min(a.physics.restitution, b.physics.restitution);
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(normal, impulseMag);
        a.physics.applyImpulseLinear(jn);
        b.physics.applyImpulseLinear(Vector3Negate(jn));
    }
    
    // Legg til friksjonskraft når to legemer er i kontakt
    private static void contactFriction(Entity a, Entity b) {
        float friction = Math.min(a.physics.friction, b.physics.friction);
        a.physics.addForce(Vector3Scale(Vector3Negate(a.physics.vel), friction));
        b.physics.addForce(Vector3Scale(Vector3Negate(b.physics.vel), friction));
    }

}
