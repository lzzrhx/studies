package tdee;
import tdee.components.*;

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
        PLANE,
        TRIANGLE,
        CIRCLE;
    }

    // Statiske variabler
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    private static int num = 0;

    // Objektvariabler
    private int id;
    private Vector3 pos;
    private Vector3 rot = new Vector3();
    private Matrix matrix = MatrixIdentity();
    private Color color;
    private Shape shape;
    private float size;

    // Flagg
    private boolean renderAxes = true;

    // Komponenter
    private ArrayList<Component> components = new ArrayList<Component>();
    public Physics physics;

    // Konstruktør uten parametre
    public Entity() {
        this(Shape.EMPTY, 1f, 0f, new Vector3(), WHITE);
    }

    // Konstruktør med fysikk
    public Entity(Shape shape, float size, float mass, Vector3 pos, Color color) {
        this.num++;
        this.id = this.num;
        entities.add(this);
        this.shape = shape;
        this.size = size;
        this.color = color;
        pos(pos);
        physics = new Physics(this, mass);
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

    // Getter for shape
    public Shape shape() {
        return shape;
    }

    // Getter for størrelse
    public float size() {
        return size;
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
            case PLANE:
                Draw3.plane(size, matrix, color);
                break;
            case TRIANGLE:
                Draw3.triangle(size, matrix, color);
                break;
            case CIRCLE:
                Draw3.circle(size, matrix, color);
                break;
        }
        if (renderAxes) { Draw3.axes(1f, matrix); }
    }
    
}
