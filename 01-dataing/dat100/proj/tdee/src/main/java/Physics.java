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

    private void checkCollision() {
        Entity.entities().forEach( entity -> {
            if (entity != parent && entity.physics != null) {
                if (Vector3LengthSqr(Vector3Subtract(parent.pos(), entity.pos())) <= parent.size() * 0.5f + entity.size() * 0.5f) {
                    Vector3 mid = Vector3Add(parent.pos(), Vector3Scale(Vector3Subtract(entity.pos(), parent.pos()), 0.5f));
                    //Logger.log("Collision! At x:" + mid.x() + " y:" + mid.y() + " z:" + mid.z());
                    //Draw3.cube(1f, MatrixMultiply(MatrixIdentity(), MatrixTranslate(mid.x(), mid.y(), mid.z())), WHITE);
                    parent.physics.addForce(Vector3Scale(Vector3Subtract(parent.pos(), mid), 3f));
                    entity.physics.addForce(Vector3Scale(Vector3Subtract(entity.pos(), mid), 3f));
                }
            }
        });
    }
}
