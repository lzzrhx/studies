package tdee.components;

import tdee.Entity;
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
        this.invM = mass > 0.001f ? 1f / mass : 0f;
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

    private void forceGravity() {
        addForce(Vector3Scale(g, mass));
    }

    // Tegning av 3D grafikk
    public void render3() {
        if (shape instanceof Sphere) {
            Sphere sphere = (Sphere)shape;
            Draw3.sphere(sphere.radius() , parent.matrix(), WHITE);
        }
        else if (shape instanceof Cube) {
            Cube cube = (Cube)shape;
            cube.draw(WHITE);
        }
    }
    
    // Oppdatering
    public void update(float dt) {
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
        // Sjekk kollisjon med andre legemer
        checkCollision();
    }
    
    // Sjekk kollisjon
    private void checkCollision() {
        Entity a = parent;
        Entity.entities().forEach( b -> {
            if (b != a && b.physics != null) {
                // Sjekk kule / kule kollisjon
                if (a.physics.shape instanceof Sphere && b.physics.shape instanceof Sphere) {
                    checkCollisionSphereSphere(a, b);
                }
                // Sjekk kube / kube kollisjon
                else if (a.physics.shape instanceof Cube && b.physics.shape instanceof Cube) {
                    checkCollisionAABB(a, b);
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
    
    // AABB / AABB kollisjon - Enkel, virker kun når alle sider er like lange
    private static void checkCollisionAABB(Entity a, Entity b) {
        Cube aCube = (Cube)a.physics.shape;
        Cube bCube = (Cube)b.physics.shape;
        Vector3 vaMin = aCube.vertsWorld()[0];
        Vector3 vaMax = aCube.vertsWorld()[7];
        Vector3 vbMin = bCube.vertsWorld()[0];
        Vector3 vbMax = bCube.vertsWorld()[7];
        // Sjekk om kube B er inni A
        if (
            vbMin.x() <= vaMax.x() &&
            vbMax.x() >= vaMin.x() &&
            vbMin.y() <= vaMax.y() &&
            vbMax.y() >= vaMin.y() &&
            vbMin.z() <= vaMax.z() &&
            vbMax.z() >= vaMin.z()
        ) {
            // Finn normalretning for kollisjonen og penetrasjonsdybde
            Vector3 diff = Vector3Subtract(b.pos(), a.pos());
            float dist = diff.x();
            Vector3 normal = new Vector3().x(dist < 0f ? -1f : 1f);
            
            float depth = (aCube.size().x() * 0.5f + bCube.size().x() * 0.5f) - (float)Math.abs(dist);

            if (Math.abs(diff.y()) > Math.abs(dist)) {
                dist = diff.y(); 
                normal = new Vector3().y(dist < 0f ? -1f : 1f);
                depth = (aCube.size().y() * 0.5f + bCube.size().y() * 0.5f) - (float)Math.abs(dist);
            }
            if (Math.abs(diff.z()) > Math.abs(dist)) {
                dist = diff.z();
                normal = new Vector3().z(dist < 0f ? -1f : 1f);
                depth = (aCube.size().z() * 0.5f + bCube.size().z() * 0.5f) - (float)Math.abs(dist);
            }

            // Løs penetrasjon og kollisjon
            resolvePenetration(a, b, normal, depth);
            resolveCollision(a, b, normal);
            contactFriction(a, b);
        }
    }

    /*
    // AABB / punkt kollisjon
    private static void checkCollisionPointAABB(Entity a, Entity b) {
        float size = a.physics.size * 0.5f;
        Vector3[] vertsA = new Vector3[2];
        vertsA[0] = new Vector3().x(-size).y(-size).z(-size);
        vertsA[1] = new Vector3().x( size).y( size).z( size);
        size = b.physics.size * 0.5f;
        Vector3[] vertsB = new Vector3[8];
        vertsB[0] = new Vector3().x(-size).y(-size).z(-size);
        vertsB[1] = new Vector3().x( size).y(-size).z(-size);
        vertsB[2] = new Vector3().x( size).y( size).z(-size);
        vertsB[3] = new Vector3().x(-size).y( size).z(-size);
        //vertsB[4] = new Vector3().x(-size).y( size).z( size);
        //vertsB[5] = new Vector3().x(-size).y(-size).z( size);
        //vertsB[6] = new Vector3().x( size).y(-size).z( size);
        //vertsB[7] = new Vector3().x( size).y( size).z( size);
        vertsB[4] = new Vector3().x( size).y(-size).z( size);
        vertsB[5] = new Vector3().x(-size).y(-size).z( size);
        vertsB[6] = new Vector3().x(-size).y( size).z( size);
        vertsB[7] = new Vector3().x( size).y( size).z( size);
        Vector3 vaMin = vertsA[0];
        Vector3 vaMax = vertsA[1];

        for (int i = 0; i < vertsB.length; i++) {
            Vector3 vb = a.worldToLocal(b.localToWorld(vertsB[i]));
            if (
                vb.x() >= vaMin.x() &&
                vb.x() <= vaMax.x() &&
                vb.y() >= vaMin.y() &&
                vb.y() <= vaMax.y() &&
                vb.z() >= vaMin.z() &&
                vb.z() <= vaMax.z()
            ) {
            // Finn normalretning for kollisjonen og penetrasjonsdybde
            Vector3 normal = Vector3Normalize(Vector3Subtract(vertsB[7-i], vertsB[i]));
            float depth = 0.1f;
            //Vector3 diff = vb;
            //float depth = diff.x();
            //Vector3 normal = new Vector3().x(depth < 0f ? -1f : 1f);
            //if (Math.abs(diff.y()) > Math.abs(depth)) {
            //    depth = diff.y(); 
            //    normal = new Vector3().y(depth < 0f ? -1f : 1f);
            //}
            //if (Math.abs(diff.z()) > Math.abs(depth)) {
            //    depth = diff.z();
            //    normal = new Vector3().z(depth < 0f ? -1f : 1f);
            //}
            //depth = 0.01f;
            // Løs penetrasjon og kollisjon
            resolvePenetration(a, b, normal, depth);
            resolveCollision(a, b, normal);
            //contactFriction(a, b);
            System.out.println(GetTime() + ": Collision! Depth: " + depth);
            }
        }

    }
    */
    
    // Løs penetrasjon med forflytting
    private static void resolvePenetration(Entity a, Entity b, Vector3 normal, float depth) {
        float da = depth / (a.physics.invM + b.physics.invM) * a.physics.invM;
        float db = depth / (a.physics.invM + b.physics.invM) * b.physics.invM;
        a.pos(Vector3Subtract(a.pos(), Vector3Scale(normal, da)));
        b.pos(Vector3Add(b.pos(), Vector3Scale(normal, db)));
    }
    
    // Løs kollisjon med impuls
    private static void resolveCollision(Entity a, Entity b, Vector3 normal) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
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
