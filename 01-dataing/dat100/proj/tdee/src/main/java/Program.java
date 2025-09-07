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
        player = new Entity(Entity.Shape.SHIP, 1f, 1f, new Vector3().y(0.5f), GREEN);
        Entity box = new Entity(Entity.Shape.CUBE, 1f, 1f, new Vector3().y(0.5f).z(-5f), RED);
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
        // Joystick
        float leftStickX = GetGamepadAxisMovement(0, GAMEPAD_AXIS_LEFT_X);
        float leftStickY = GetGamepadAxisMovement(0, GAMEPAD_AXIS_LEFT_Y);
        float rightStickX = GetGamepadAxisMovement(0, GAMEPAD_AXIS_RIGHT_X);
        float rightStickY = GetGamepadAxisMovement(0, GAMEPAD_AXIS_RIGHT_Y);
        float leftTrigger = GetGamepadAxisMovement(0, GAMEPAD_AXIS_LEFT_TRIGGER);
        float rightTrigger = GetGamepadAxisMovement(0, GAMEPAD_AXIS_RIGHT_TRIGGER);
        if (rightTrigger > -0.9f) { rightTrigger = (rightTrigger + 1f) * 0.5f; }
        else if (leftTrigger > -0.9f) { leftTrigger = (leftTrigger + 1f) * 0.5f; }
        if (rightTrigger > 0.01f) { player.physics.addForce(new Vector3().z(-1.5f * rightTrigger)); }
        else if (leftTrigger > 0.01f) { player.physics.addForce(new Vector3().z(1f * leftTrigger)); }
        if (Math.abs(rightStickX) > 0.1f) { player.physics.addForce(new Vector3().x(0.75f * rightStickX)); }
        if (Math.abs(rightStickY) > 0.1f) { player.physics.addForce(new Vector3().y(-0.75f * rightStickY)); }
        if (Math.abs(leftStickX) > 0.1f) { player.physics.addTorque(new Vector3().y(-0.20f * leftStickX)); }
        if (Math.abs(leftStickY) > 0.1f) { player.physics.addTorque(new Vector3().x(-0.15f * leftStickY)); }
        if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_LEFT_TRIGGER_1)) { player.physics.addTorque(new Vector3().z(0.15f)); }
        if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_RIGHT_TRIGGER_1)) { player.physics.addTorque(new Vector3().z(-0.15f)); }
        // Tastatur
        if (IsKeyDown(KEY_W)) { player.physics.addForce(new Vector3().z(-1.5f)); }
        else if (IsKeyDown(KEY_S)) { player.physics.addForce(new Vector3().z(1f)); }
        if (IsKeyDown(KEY_A)) { player.physics.addForce(new Vector3().x(-0.75f)); }
        else if (IsKeyDown(KEY_D)) { player.physics.addForce(new Vector3().x(0.75f)); }
        if (IsKeyDown(KEY_Q)) { player.physics.addTorque(new Vector3().y(0.2f)); }
        else if (IsKeyDown(KEY_E)) { player.physics.addTorque(new Vector3().y(-0.2f)); }
    }

    // Hovedløkke for oppdatering
    private static void update() {
        float dt = GetFrameTime();
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
