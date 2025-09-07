package tdee.components;

import tdee.Entity;
import tdee.Logger;
import static com.raylib.Raylib.*;

public class Physics implements Component {

    Entity parent;

    // Fysikkvariabler
    private Vector3 force = new Vector3();
    private Vector3 acc = new Vector3();
    private Vector3 vel = new Vector3();
    private float invM;
    //private float drag = 5f;
    private Vector3 torque = new Vector3();
    private Vector3 angAcc = new Vector3();
    private Vector3 angVel = new Vector3();
    private float restitution = 1f;
    private float friction = 0.5f;

    // Konstruktør
    public Physics(Entity parent, float mass) {
        this.parent = parent;
        mass(mass);
    }

    // Oppdatering av masse
    private void mass(float mass) {
        this.invM = 1f / mass;
    }

    // Legg til kraft på legemet
    public void addForce(Vector3 force) {
        this.force = Vector3Add(this.force, (Vector3Transform(force, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(parent.rot())))));
    }
    
    // Legg til moment på legemet
    public void addTorque(Vector3 torque) {
        this.torque = Vector3Add(this.torque, (Vector3Transform(torque, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(parent.rot())))));
    }

    public void applyImpulseLinear(Vector3 j) {
        vel = Vector3Add(vel, Vector3Scale(j, invM));
    }
    
    public void applyImpulseAngular(Vector3 j) {
        angVel = Vector3Add(angVel, Vector3Scale(j, invM));
    }
    
    public void applyImpulseAtPoint(Vector3 j, Vector3 r) {
        applyImpulseLinear(j);
        angVel = Vector3Add(angVel, Vector3Scale(Vector3CrossProduct(r, j), invM));
    }

    // Oppdatering
    public void update(float dt) {
        //if (drag > 0.01f && Vector3Length(vel) > 0.1f) { force = Vector3Add(force, Vector3Scale(Vector3Normalize(vel), -drag)); }
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

    // Løs "penetration constraint" ved bruk av "projection method"
    private void resolvePenetration(Entity a, Entity b, Vector3 normal, float depth) {
        float da = depth / (a.physics.invM + b.physics.invM) * a.physics.invM;
        float db = depth / (a.physics.invM + b.physics.invM) * b.physics.invM;
        a.pos(Vector3Subtract(a.pos(), Vector3Scale(normal, da)));
        b.pos(Vector3Add(b.pos(), Vector3Scale(normal, db)));
    }
    
    // Løs "collision constraint"
    private void resolveCollisionSimple(Entity a, Entity b, Vector3 normal) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        Vector3 impulseDir = normal;
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(impulseDir, impulseMag);
        a.physics.applyImpulseLinear(jn);
        b.physics.applyImpulseLinear(Vector3Negate(jn));
    }

    // Løs "collision constraint" med rotasjon
    /*
    private void resolveCollision(Entity a, Entity b, Vector3 normal, Vector3 aPoint, Vector3 bPoint) {
        float e = Math.min(a.physics.restitution, b.physics.restitution);
        float f = Math.min(a.physics.friction, b.physics.friction);
        Vector3 ra = Vector3Subtract(bPoint, a.pos());
        Vector3 rb = Vector3Subtract(aPoint, b.pos());
        Vector3 va = Vector3Add(a.physics.vel, new Vector3().x(a.physics.angVel.z() * ra.z()).y(a.physics.angVel.y() * ra.y()).z(a.physics.angVel.x() * ra.x()));
        Vector3 vb = Vector3Add(b.physics.vel, new Vector3().x(b.physics.angVel.z() * rb.z()).y(b.physics.angVel.y() * rb.y()).z(b.physics.angVel.x() * rb.x()));
        Vector3 vRel = Vector3Subtract(a.physics.vel, b.physics.vel);
        float vRelDotNormal = Vector3DotProduct(vRel, normal);
        float impulseMag = -(1f + e) * vRelDotNormal / ((a.physics.invM + b.physics.invM) + Vector3CrossProduct(ra, normal) * Vector3CrossProduct(ra, normal) * a.invM + Vector3CrossProduct(rb, normal) * Vector3CrossProduct(rb, normal) * b.invM);
        Vector3 jn = Vector3Scale(normal, impulseMag);
        a.physics.applyImpulseLinear(jn);
        b.physics.applyImpulseLinear(Vector3Negate(jn));
    }
    */

    // Sjekk kollisjon
    private void checkCollision() {
        Entity a = parent;
        Entity.entities().forEach( b -> {
            if (b != a && b.physics != null) {

                // Sjekk sirkel / sirkel kollisjon
                float aRadius = a.size() * 0.5f;
                float bRadius = b.size() * 0.5f;
                Vector3 normal = Vector3Subtract(b.pos(), a.pos());
                if (Vector3LengthSqr(normal) <= (aRadius + bRadius) * (aRadius + bRadius)) {
                    
                    // Kontakt detaljer
                    normal = Vector3Normalize(normal);
                    Vector3 aPoint = Vector3Subtract(b.pos(), Vector3Scale(normal, bRadius));
                    Vector3 bPoint = Vector3Add(a.pos(), Vector3Scale(normal, aRadius));
                    float depth = Vector3Length(Vector3Subtract(bPoint, aPoint));
                    
                    // Løs "constraints"
                    resolvePenetration(a, b, normal, depth);
                    resolveCollisionSimple(a, b, normal);
                }
            }
        });
    }
}
