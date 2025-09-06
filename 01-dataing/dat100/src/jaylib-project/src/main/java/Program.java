import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

// Hovedklasse for kjøring av programmet
public class Program {

    // Variabler for programinstillinger
    private static int screenWidth = 1200;
    private static int screenHeight = 900;
    
    // Entity variabler
    private static Entity cube;
    private static Entity circle;

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
        InitWindow(screenWidth, screenHeight, "jaylib");
        SetTargetFPS(30);
        // Entity set up
        cube = new Entity(Entity.EntityType.CUBE, 1f, new Vector3().y(0.5f), GREEN);
        circle = new Entity(Entity.EntityType.CIRCLE, 5f, new Vector3(), BLUE);
        // Kamera set up
        camera = new Camera(cube);
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
    }

    // Hovedløkke for oppdatering
    private static void update() {
        float deltaTime = GetFrameTime();
        circle.pos(circle.pos().y(0.5f + (float)Math.sin(GetTime()) * 0.5f));
        camera.update(deltaTime);
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
        //DrawText(Float.toString(cameraRotation.y()), 10, 10, 10, WHITE);
        //GuiLabel(new Rectangle().x(120f).y(120f).width(100f).height(32f), "Hello");
        DrawFPS(20, 20);
    }

}
