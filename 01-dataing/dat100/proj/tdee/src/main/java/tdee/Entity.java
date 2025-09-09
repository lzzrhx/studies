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

    // Konstruktør
    public Entity(Vector3 pos) {
        this.num++;
        this.id = this.num;
        entities.add(this);
        pos(pos);
    }

    // Legg til fysikk komponent med kubegeometri
    public void addCubePhysics(Vector3 size, float mass) {
        if (physics == null) {
            physics = new Physics(this, size, mass, 0.5f, 0.5f);
            components.add(physics);
        }
    }
    
    // Legg til fysikk komponent med kulegeometri
    public void addSpherePhysics(float radius, float mass) {
        if (physics == null) {
            physics = new Physics(this, radius, mass, 0.5f, 0.5f);
            components.add(physics);
        }
    }

    // Statisk getter for entities
    public static ArrayList<Entity> entities() {
        return entities;
    }

    // Konverter lokale koordinater til verdenskordinater
    public Vector3 localToWorld(Vector3 pos) {
        return Vector3Transform(pos, matrix);
    }

    // Konverter verdenskordinater til lokale kordinater
    public Vector3 worldToLocal(Vector3 pos) {
        return Vector3Transform(pos, MatrixInvert(matrix));
    }

    // Getter for id
    public int id() {
        return id;
    }

    // Getter for posisjon
    public Vector3 pos() {
        return this.pos;
    }

    // Oppdater matrisen for legemet
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
