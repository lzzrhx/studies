package tdee;
import tdee.components.*;

import java.util.ArrayList;
import static com.raylib.Raylib.*;

public class Entity {

    // Statiske variabler
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    private static int num = 0;

    // Objektvariabler
    private int id;
    private Vector3 pos;
    private Vector3 rot = new Vector3();
    private Matrix matrix = MatrixIdentity();

    // Flagg
    private boolean renderAxes = true;

    // Komponenter
    private ArrayList<Component> components = new ArrayList<Component>();
    public Physics physics;

    // Konstruktør med fysikk
    public Entity(Vector3 pos) {
        this.num++;
        this.id = this.num;
        entities.add(this);
        pos(pos);
    }

    public Entity(Vector3 pos, Physics.Shape shape, float size, float mass) {
        this(pos);
        addPhysics(shape, size, mass);
    }

    public void addPhysics(Physics.Shape shape, float size, float mass) {
        physics = new Physics(this, shape, size, mass);
        components.add(physics);
    }

    // Statisk getter for entities
    public static ArrayList<Entity> entities() {
        return entities;
    }

    public Vector3 localToWorld(Vector3 pos) {
        return Vector3Transform(pos, matrix);
    }

    // Getter for id
    public int id() {
        return id;
    }

    // Getter for posisjon
    public Vector3 pos() {
        return this.pos;
    }

    private void updateMatrix() {
        matrix = MatrixMultiply(MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(rot)), MatrixTranslate(pos.x(), pos.y(), pos.z()));
    }

    // Setter for posisjon
    public void pos(Vector3 pos) {
        this.pos = pos;
        updateMatrix();
    }

    // Getter for rotasjon
    public Vector3 rot() {
        return rot;
    }
    
    // Setter for rotasjon
    public void rot(Vector3 rot) {
        this.rot = rot;
        updateMatrix();
    }

    // Getter for matrix
    public Matrix matrix() {
        return matrix;
    }

    // Oppdatering av alle Entity objekter
    public static void updateAll(float dt) {
        entities.forEach( entity -> {
            entity.update(dt);
        });
    }

    // Oppdatering av enkelt Entity objekt
    private void update(float dt) {
        components.forEach( component -> {
            component.update(dt);
        });
    }

    // Tegning av alle Entity objekter
    public static void render3All() {
        entities.forEach( entity -> {
            entity.render3();
        });
    }

    // Tegning av enkelt Entity objekt
    private void render3() {
        components.forEach( component -> {
            component.render3();
        });
        if (renderAxes) { Draw3.axes(1f, matrix); }
    }
    
}
