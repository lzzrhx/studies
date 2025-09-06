import java.util.ArrayList;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Entity {

    // Entity typer
    public enum Shape {
        EMPTY,
        SHIP,
        CUBE,
        SPHERE,
        // TODO: PLANE,
        TRIANGLE,
        // TODO: PYRAMID,
        // TODO: CYLINDER,
        CIRCLE;
    }

    // Statiske variabler
    private static ArrayList<Entity> entityList = new ArrayList<Entity>();

    // Objektvariabler
    private Vector3 pos;
    private Vector3 rot = new Vector3();
    private Matrix matrix = MatrixIdentity();
    private Color color;
    private Shape shape;
    private float size;

    // flags
    private boolean flagAxes = true;
    private boolean flagPhysics = true;

    // Fysikkvariabler
    private Vector3 force = new Vector3();
    private Vector3 acc = new Vector3();
    private Vector3 vel = new Vector3();
    private float invM;
    //private float drag = 5f;
    private float torque;

    // Konstruktør uten parametre
    public Entity() {
        this(Shape.EMPTY, 1f, 0f, new Vector3(), WHITE);
    }

    // Konstruktør
    public Entity(Shape shape, float size, float mass, Vector3 pos, Color color) {
        entityList.add(this);
        this.shape = shape;
        this.size = size;
        this.color = color;
        pos(pos);
        mass(mass);
    }

    private void mass(float mass) {
        this.invM = 1f / mass;
    }

    // Getter for posisjon
    public Vector3 pos() {
        return this.pos;
    }

    // Setter for posisjon
    public void pos(Vector3 pos) {
        this.pos = pos;
    }

    // Getter for rotasjon
    public Vector3 rot() {
        return rot;
    }

    // Setter for rotatasjon
    public void rot(Vector3 rot) {
        this.rot = rot;
    }

    // Getter for matrix
    public Matrix matrix() {
        return matrix;
    }

    // Setter for f
    public void addForce(Vector3 force) {
        this.force = Vector3Add(this.force, force);
    }

    // Oppdatering av alle Entity objekter
    public static void updateAll(float dt) {
        entityList.forEach( entity -> {
            entity.update(dt);
        });
    }

    // Oppdatering av enkelt Entity objekt
    private void update(float dt) {
        if (flagPhysics) {
            //if (drag > 0.01f && Vector3Length(vel) > 0.1f) { force = Vector3Add(force, Vector3Scale(Vector3Normalize(vel), -drag)); }
            // Akselerasjon er lik krefter delt på masse (F = ma  ->  a = F / m  ->  a = F * (1 / m))
            acc = Vector3Scale(force, invM);
            // Integrer akselerasjon over tid for å finne endring i fart fart (v = at)
            vel = Vector3Add(vel, Vector3Scale(acc, dt));
            // Integrer fart over tid for å finne endring i posisjon (t = vt)
            pos = Vector3Add(pos, Vector3Scale(vel, dt));
            // Nullstill krefter som virker på legemet
            force = Vector3Zero();
        }
        matrix = MatrixMultiply(MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(rot)), MatrixTranslate(pos.x(), pos.y(), pos.z()));
    }

    // Tegning av alle Entity objekter
    public static void renderAll() {
        entityList.forEach( entity -> {
            entity.render();
        });
    }

    // Tegning av enkelt Entity objekt
    private void render() {
        switch (shape) {
            case CUBE:
                Draw3.cube(size, matrix, color);
                break;
            case SPHERE:
                Draw3.sphere(size, matrix, color);
                break;
            case SHIP:
                Draw3.ship(size, matrix, color);
                break;
            case TRIANGLE:
                Draw3.triangle(size, matrix, color);
                break;
            case CIRCLE:
                Draw3.circle(size, matrix, color);
                break;
        }
        if (flagAxes) { Draw3.axes(1f, matrix); }
    }
}
