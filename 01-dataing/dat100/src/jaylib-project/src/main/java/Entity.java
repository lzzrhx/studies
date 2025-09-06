import java.util.ArrayList;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Entity {

    // Entity typer
    public enum EntityType {
        EMPTY,
        CUBE,
        CIRCLE;
    }

    // Statiske variabler
    private static ArrayList<Entity> entityList = new ArrayList<Entity>();

    // Objektvariabler
    private Vector3 pos;
    private Matrix matrix = MatrixIdentity();
    private Color color;
    private EntityType type;
    private float size;

    // Konstruktør uten parametre
    public Entity() {
        this(EntityType.EMPTY, 1f, new Vector3(), WHITE);
    }

    // Konstruktør
    public Entity(EntityType type, float size, Vector3 pos, Color color) {
        entityList.add(this);
        this.type = type;
        this.size = size;
        this.color = color;
        pos(pos);
    }

    // Getter for posisjon
    public Vector3 pos() {
        return this.pos;
    }

    // Setter for posisjon
    public void pos(Vector3 pos) {
        this.pos = pos;
        matrix = MatrixTranslate(pos.x(), pos.y(), pos.z());
    }

    // Tegning av alle Entity objekter
    public static void renderAll() {
        entityList.forEach( entity -> {
            entity.render();
        });
    }

    // Tegning av enkelt Entity objekt
    private void render() {
        switch (type) {
            case CUBE:
                Draw3.cube(size, matrix, color);
                break;
            case CIRCLE:
                Draw3.circle(size, matrix, color);
                break;
        }
        Draw3.axes(1f, matrix);
    }
}
