import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

// Hovedklasse for kjøring av programmet
public class Program {

    // Variabler for programinstillinger
    private static int screenWidth = 1200;
    private static int screenHeight = 900;
    
    // Entity variabler
    private static Entity player;
    //private static Entity circle;

    // Kamera
    private static Camera camera;
    
    // Entry point for programkjøring
    public static void main(String args[]) {
        init();
        run();
        exit();
    }

    // Initialisering av programmet
    private static void init() {
        Logger.log("Initializing program");
        InitWindow(screenWidth, screenHeight, "tdee");
        SetTargetFPS(30);
        // Entity set up
        
        //player = new Player();
        //player = new Player(Entity.EntityType.CUBE, 1f, new Vector3().y(0.5f), GREEN, true);
        player = new Entity(Entity.Shape.SHIP, 1f, 1f, new Vector3().y(0.5f), GREEN);
        //player.addForce(new Vector3().x(100f));
        //circle = new Entity(Entity.EntityType.CIRCLE, 5f, new Vector3(), BLUE, false);
        // Kamera set up
        camera = new Camera(player);
    }

    // Avslutting av programmet
    private static void exit() {
        CloseWindow();
    }

    // Hovedløkke for programkjøring
    private static void run() {
        while (!WindowShouldClose()) {
            input();
            update();
            render();
        }
    }

    // Motta innputt fra bruker
    private static void input() {
        camera.input();
        if (IsKeyDown(KEY_W)) { player.addForce(Vector3Transform(new Vector3().z(-5f), MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(player.rot())))); }
        else if (IsKeyDown(KEY_S)) { player.addForce(Vector3Transform(new Vector3().z(5f), MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(player.rot())))); }
        if (IsKeyDown(KEY_A)) { player.addForce(Vector3Transform(new Vector3().x(-2f), MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(player.rot())))); }
        else if (IsKeyDown(KEY_D)) { player.addForce(Vector3Transform(new Vector3().x(2f), MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(player.rot())))); }
        if (IsKeyDown(KEY_Q)) { player.rot(Vector3Add(player.rot(), new Vector3().y(0.03f))); }
        else if (IsKeyDown(KEY_E)) { player.rot(Vector3Subtract(player.rot(), new Vector3().y(0.03f))); }
    }

    // Hovedløkke for oppdatering
    private static void update() {
        float dt = GetFrameTime();
        //circle.pos(circle.pos().y(0.5f + (float)Math.sin(GetTime()) * 0.5f));
        //circle.rot(circle.rot().y(circle.rot().y() + 0.01f));
        //cube.rot(cube.rot().x(cube.rot().x() + 0.01f).y(cube.rot().y() + 0.01f));
        Entity.updateAll(dt);
        camera.update(dt);
    }

    // Grafikk
    private static void render() {
        BeginDrawing();
        ClearBackground(DARKGRAY);
        render3();
        render2();
        EndDrawing();
    }

    // 3D grafikk
    private static void render3() {
        BeginMode3D(camera.camera());
        Draw3.grid(100, MatrixIdentity(), GRAY);
        Entity.renderAll();
        EndMode3D();
    }
    
    // 2D grafikk
    private static void render2() {
        // DrawText(Float.toString(player.f()), 10, 10, 10, WHITE);
        //GuiLabel(new Rectangle().x(120f).y(120f).width(100f).height(32f), "Hello");
        DrawFPS(20, 20);
    }

}
