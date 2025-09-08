package tdee.components;
import tdee.Entity;

import java.util.HashMap;
import java.util.Map;

import static com.raylib.Raylib.*;

public class Physics implements Component {

    Entity parent;

    // Fysikkvariabler
    private Vector3 force = new Vector3();
    private Vector3 acc = new Vector3();
    private Vector3 vel = new Vector3();
    private float invM;
    private Vector3 torque = new Vector3();
    private Vector3 angAcc = new Vector3();
    private Vector3 angVel = new Vector3();
    private float restitution;

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
        Vector3 impulseDir = normal;
        float impulseMag = -(1f + e) * vRelDotNormal / (a.physics.invM + b.physics.invM);
        Vector3 jn = Vector3Scale(impulseDir, impulseMag);
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
                    resolveCollision(a, b, normal);
                }
            }
        });
    }
}
