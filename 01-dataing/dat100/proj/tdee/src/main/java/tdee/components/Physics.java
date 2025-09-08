package tdee.components;
import tdee.Entity;
import tdee.Draw3;

import java.util.HashMap;
import java.util.Map;

import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Physics implements Component {

    // Objektvariabler
    Entity parent;

    // Fysikkvariabler
    private Vector3 force = new Vector3();
    private Vector3 acc = new Vector3();
    private Vector3 vel = new Vector3();
    private float mass;
    private float invM;
    private Vector3 torque = new Vector3();
    private Vector3 angAcc = new Vector3();
    private Vector3 angVel = new Vector3();
    private float restitution;
    
    // Statiske fysikkvariabler
    private static final Vector3 g = new Vector3().y(-9.8f);

    // Test variabler
    private Vector3 testCube = new Vector3();

    // Konstruktør
    public Physics(Entity parent, float mass) {
        this(parent, mass, 1f);
    }

    // Konstruktør
    public Physics(Entity parent, float mass, float restitution) {
        this.parent = parent;
        mass(mass);
    }

    // Getter for vel
    public Vector3 vel() {
        return vel;
    }

    public Vector3 velLocal() {
        return Vector3Transform(vel, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(parent.rot())));
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

    // Oppdatering
    public void update(float dt) {
        // Legg til eksterne krefter fra omgivelsene
        forceGravity();
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
        checkCollision();
    }

    // Tegning av 3D grafikk
    public void render3() {
        Draw3.cube(0.2f, MatrixMultiply(MatrixIdentity(), MatrixTranslate(testCube.x(), testCube.y(), testCube.z())), WHITE);
    }
    
    // Løs "penetration constraint" ved bruk av "projection method"
    private void resolvePenetration(Entity a, Entity b, Vector3 normal, float depth) {
        float da = depth / (a.physics.invM + b.physics.invM) * a.physics.invM;
        float db = depth / (a.physics.invM + b.physics.invM) * b.physics.invM;
        a.pos(Vector3Subtract(a.pos(), Vector3Scale(normal, da)));
        b.pos(Vector3Add(b.pos(), Vector3Scale(normal, db)));
    }
    
    // Løs "collision constraint"
    private void resolveCollision(Entity a, Entity b, Vector3 normal) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(normal, impulseMag);
        a.physics.applyImpulseLinear(jn);
        b.physics.applyImpulseLinear(Vector3Negate(jn));
    }
    
    // Løs "collision constraint" enkel variant med rotasjon
    /*
    private void resolveCollisionAtPoint(Entity a, Entity b, Vector3 normal, Vector3 pointA, Vector3 pointB) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        Vector3 impulseDir = normal;
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(impulseDir, impulseMag);
        a.physics.applyImpulseAtPoint(jn, pointA);
        b.physics.applyImpulseAtPoint(Vector3Negate(jn), pointB);
    }
    */

    private void checkCollisionSphereSphere(Entity a, Entity b) {
        float aRadius = a.size() * 0.5f;
        float bRadius = b.size() * 0.5f;
        Vector3 normal = Vector3Subtract(b.pos(), a.pos());
        if (Vector3LengthSqr(normal) <= (aRadius + bRadius) * (aRadius + bRadius)) {
            
            // Kontakt detaljer
            normal = Vector3Normalize(normal);
            Vector3 start = Vector3Subtract(b.pos(), Vector3Scale(normal, bRadius));
            Vector3 end = Vector3Add(a.pos(), Vector3Scale(normal, aRadius));
            float depth = Vector3Length(Vector3Subtract(end, start));
            
            // Løs "constraints"
            resolvePenetration(a, b, normal, depth);
            resolveCollision(a, b, normal);
        }
    }
    
    // AABB box collision
    private void checkCollisionAABB(Entity a, Entity b) {
        float size = a.size() * 0.5f;
        Vector3[] vertsA = new Vector3[2];
        vertsA[0] = new Vector3().x(-size).y(-size).z(-size);
        vertsA[1] = new Vector3().x( size).y( size).z( size);
        size = b.size() * 0.5f;
        Vector3[] vertsB = new Vector3[2];
        vertsB[0] = new Vector3().x(-size).y(-size).z(-size);
        vertsB[1] = new Vector3().x( size).y( size).z( size);
        //vertsB[0] = new Vector3().x(-size).y(-size).z(-size);
        //vertsB[1] = new Vector3().x( size).y( size).z( size);
        
        // float size = a.size() / 2f;
        // Vector3[] vertsA = new Vector3[8];
        // vertsA[0] = new Vector3().x(-size).y( size).z(-size);
        // vertsA[1] = new Vector3().x( size).y( size).z(-size);
        // vertsA[2] = new Vector3().x(-size).y(-size).z(-size);
        // vertsA[3] = new Vector3().x( size).y(-size).z(-size);
        // vertsA[4] = new Vector3().x(-size).y( size).z( size);
        // vertsA[5] = new Vector3().x( size).y( size).z( size);
        // vertsA[6] = new Vector3().x(-size).y(-size).z( size);
        // vertsA[7] = new Vector3().x( size).y(-size).z( size);
        // size = b.size() / 2f;
        // Vector3[] vertsB = new Vector3[8];
        // vertsB[0] = new Vector3().x(-size).y( size).z(-size);
        // vertsB[1] = new Vector3().x( size).y( size).z(-size);
        // vertsB[2] = new Vector3().x(-size).y(-size).z(-size);
        // vertsB[3] = new Vector3().x( size).y(-size).z(-size);
        // vertsB[4] = new Vector3().x(-size).y( size).z( size);
        // vertsB[5] = new Vector3().x( size).y( size).z( size);
        // vertsB[6] = new Vector3().x(-size).y(-size).z( size);
        // vertsB[7] = new Vector3().x( size).y(-size).z( size);

        Vector3 vaMin = a.localToWorld(vertsA[0]);
        Vector3 vaMax = a.localToWorld(vertsA[1]);
        Vector3 vbMin = b.localToWorld(vertsB[0]);
        Vector3 vbMax = b.localToWorld(vertsB[1]);
            testCube = vaMin;

        if (
            vbMin.x() <= vaMax.x() &&
            vbMax.x() >= vaMin.x() &&
            vbMin.y() <= vaMax.y() &&
            vbMax.y() >= vaMin.y() &&
            vbMin.z() <= vaMax.z() &&
            vbMax.z() >= vaMin.z()
        ) {
            Vector3 diff = Vector3Subtract(b.pos(), a.pos());
            float max = diff.x();
            Vector3 normal = new Vector3().x(max < 0f ? -1f : 1f);
            if (Math.abs(diff.y()) > Math.abs(max)) {
                max = diff.y(); 
                normal = new Vector3().y(max < 0f ? -1f : 1f);
            }
            if (Math.abs(diff.z()) > Math.abs(max)) {
                max = diff.z();
                normal = new Vector3().z(max < 0f ? -1f : 1f);
            }
            max = ((float)Math.abs(a.size() * 0.5f + b.size() * 0.5f) - (float)Math.abs(max));
            resolvePenetration(a, b, normal, max);
            resolveCollision(a, b, normal);
            //System.out.println(a.id() + " " + " " + max);
            //a.physics.vel = Vector3Zero();
            //b.physics.vel = Vector3Zero();


                    //a.physics.force = Vector3Zero();
                    //b.physics.force = Vector3Zero();
                    //a.physics.vel = Vector3Zero();
                    //b.physics.vel = Vector3Zero();
                    //testCube = vb;
                    //System.out.println("Collision!");

        }

        /*
        for (int i = 0; i < vertsB.length; i++) {
                Vector3 vb = b.localToWorld(vertsB[i]);
                if (
                    vb.x() >= a.localToWorld(vertsA[0]).x() && vb.x() <= a.localToWorld(vertsA[1]).x() &&
                    vb.y() >= a.localToWorld(vertsA[0]).y() && vb.y() <= a.localToWorld(vertsA[1]).y() &&
                    vb.z() >= a.localToWorld(vertsA[0]).z() && vb.z() <= a.localToWorld(vertsA[1]).z()
                ) {
                    
                    a.physics.force = Vector3Zero();
                    b.physics.force = Vector3Zero();
                    a.physics.vel = Vector3Zero();
                    b.physics.vel = Vector3Zero();

                    //Vector3 edge = Vector3Subtract(vertsA[(i + 1) % vertsA.length], vertsA[i]);
                    //Vector3 normal = Vector3Normalize(Vector3Subtract(b.pos(), a.pos()));
                    //Vector3 start = Vector3Subtract(b.pos(), Vector3Scale(normal, bRadius));
                    //Vector3 end = Vector3Add(a.pos(), Vector3Scale(normal, aRadius));
                    //float depth = Vector3Length(Vector3Subtract(end, start));
                    testCube = vb;
                    System.out.println("Collision!");
                }
        }
        */

        /*
        Vector3 aAxis = new Vector3();
        Vector3 aPoint = new Vector3();
        float abSep = polygonFindMinSeperation(a, b, aAxis, aPoint);
        if (abSep < 0f) {
            Vector3 bAxis = new Vector3();
            Vector3 bPoint = new Vector3();
            float baSep = polygonFindMinSeperation(b, a, bAxis, bPoint);
            if (baSep < 0f) {
                if (abSep > baSep) {
                    float depth = -abSep;
                    Vector3 normal = Vector3Normalize(aAxis);
                    Vector3 start = Vector3Add(aPoint, Vector3Scale(normal, depth));
                    Vector3 end = bPoint;
                    resolvePenetration(a, b, normal, depth);
                    resolveCollision(a, b, normal);
                } else {
                    float depth = -baSep;
                    Vector3 normal = Vector3Normalize(Vector3Negate(bAxis));
                    Vector3 start = Vector3Subtract(bPoint, Vector3Scale(normal, depth));
                    Vector3 end = bPoint;
                    resolvePenetration(a, b, normal, depth);
                    resolveCollision(a, b, normal);
                }

            }
        }
    */
    }

    /*
    private float polygonFindMinSeperation(Entity a, Entity b, Vector3 axis, Vector3 point) {

        float size = a.size() / 2f;
        Vector3[] vertsA = new Vector3[8];
        vertsA[0] = new Vector3().x(-size).y( size).z(-size);
        vertsA[1] = new Vector3().x( size).y( size).z(-size);
        vertsA[2] = new Vector3().x(-size).y(-size).z(-size);
        vertsA[3] = new Vector3().x( size).y(-size).z(-size);
        vertsA[4] = new Vector3().x(-size).y( size).z( size);
        vertsA[5] = new Vector3().x( size).y( size).z( size);
        vertsA[6] = new Vector3().x(-size).y(-size).z( size);
        vertsA[7] = new Vector3().x( size).y(-size).z( size);
        size = b.size() / 2f;
        Vector3[] vertsB = new Vector3[8];
        vertsB[0] = new Vector3().x(-size).y( size).z(-size);
        vertsB[1] = new Vector3().x( size).y( size).z(-size);
        vertsB[2] = new Vector3().x(-size).y(-size).z(-size);
        vertsB[3] = new Vector3().x( size).y(-size).z(-size);
        vertsB[4] = new Vector3().x(-size).y( size).z( size);
        vertsB[5] = new Vector3().x( size).y( size).z( size);
        vertsB[6] = new Vector3().x(-size).y(-size).z( size);
        vertsB[7] = new Vector3().x( size).y(-size).z( size);
        
        testCube = a.localToWorld(vertsA[0]);

        float sep = Float.MIN_VALUE;
        for (int i = 0; i < vertsA.length; i++) {
            Vector3 va = a.localToWorld(vertsA[i]);
            Vector3 edge = Vector3Subtract(vertsA[(i + 1) % vertsA.length], vertsA[i]);
            Vector3 normal = Vector3Normalize(edge);;
            float minSep = Float.MAX_VALUE;
            Vector3 minVert = new Vector3();
            for (int j = 0; j < vertsB.length; j++) {
                Vector3 vb = b.localToWorld(vertsB[j]);
                float proj = Vector3DotProduct(normal, Vector3Subtract(vb, va));
                if (proj < minSep) {
                    minSep = proj;
                    minVert = vb;
                }
            }
            if (minSep > sep) {
                sep = minSep;
                axis = edge;
                point = minVert;
            }
            sep = (float)Math.max(sep, minSep);
        }
        System.out.println(sep);
        return sep;
    }
    */

    // Sjekk kollisjon
    private void checkCollision() {
        Entity a = parent;
        Entity.entities().forEach( b -> {
            if (b != a && b.physics != null) {

                // Sjekk sirkel / sirkel kollisjon
                if (a.shape() == Entity.Shape.SPHERE && b.shape() == Entity.Shape.SPHERE) {
                    checkCollisionSphereSphere(a, b);
                }

                // Sjekk kube / kube kollisjon
                else if (a.shape() == Entity.Shape.CUBE && b.shape() == Entity.Shape.CUBE) {
                    checkCollisionAABB(a, b);
                }
            }
        });
    }
}
