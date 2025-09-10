package tdee;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

// Hovedklasse for kjøring av programmet
public class Program {

    // Variabler for programinstillinger
    private static int screenWidth = 1200;
    private static int screenHeight = 900;
    
    // Entity variabler
    private static Entity player;
    private static Entity box;
    //private static Entity ball;
    //private static Entity ground;

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
        player = new Entity(new Vector3().y(0.5f));
        player.addCubePhysics(new Vector3().x(1f).y(1f).z(1f), 1f);
        box = new Entity(new Vector3().x(2f).y(0.5f).z(-2f));
        box.addCubePhysics(new Vector3().x(1f).y(1f).z(1f), 1f);
        //ball = new Entity(new Vector3().x(-1f).y(0.5f).z(-2f));
        //ball.addSpherePhysics(0.5f, 1f);
        //ground = new Entity(new Vector3().y(-10f));
        //ground.addCubePhysics(new Vector3().x(20f).y(20f).z(20f), 0f);
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
        //if (rightTrigger > 0.01f) { player.physics.addTorqueRel(new Vector3().y(-0.5f * rightTrigger)); }
        //else if (leftTrigger > 0.01f) { player.physics.addTorqueRel(new Vector3().y(0.5f * leftTrigger)); }
        if (Math.abs(leftStickX) > 0.1f) { player.physics.addForceRel(new Vector3().x(0.75f * leftStickX)); }
        if (Math.abs(leftStickY) > 0.1f) { player.physics.addForceRel(new Vector3().z(0.75f * leftStickY)); }
        //if (Math.abs(rightStickY) > 0.1f) { player.physics.addForceRel(new Vector3().y(-12f * rightStickY)); }
        //if (Math.abs(leftStickX) > 0.1f) { player.physics.addTorqueRel(new Vector3().y(-0.20f * leftStickX)); }
        //if (Math.abs(leftStickY) > 0.1f) { player.physics.addTorqueRel(new Vector3().x(-0.15f * leftStickY)); }
        //if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_LEFT_TRIGGER_1)) { player.physics.addTorqueRel(new Vector3().z(0.15f)); }
        //if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_RIGHT_TRIGGER_1)) { player.physics.addTorqueRel(new Vector3().z(-0.15f)); }
        // Tastatur
        if (IsKeyDown(KEY_W)) { player.physics.addForceRel(new Vector3().z(-0.75f)); }
        else if (IsKeyDown(KEY_S)) { player.physics.addForceRel(new Vector3().z(0.75f)); }
        if (IsKeyDown(KEY_A)) { player.physics.addForceRel(new Vector3().x(-0.75f)); }
        else if (IsKeyDown(KEY_D)) { player.physics.addForceRel(new Vector3().x(0.75f)); }
        if (IsKeyDown(KEY_SPACE)) { player.physics.addForceRel(new Vector3().y(12f)); }
        if (IsKeyDown(KEY_Q)) { player.physics.addTorqueRel(new Vector3().y(0.2f)); }
        else if (IsKeyDown(KEY_E)) { player.physics.addTorqueRel(new Vector3().y(-0.2f)); }
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
        Entity.render3All();
        EndMode3D();
    }
    
    // 2D grafikk
    private static void render2() {
        DrawFPS(2, 2);
        DrawText(("pos x: " + Float.toString(player.pos().x()) + "   y: " + Float.toString(player.pos().y()) + "   z: " + Float.toString(player.pos().z())).toUpperCase(), 2, 20, 10, WHITE);
    }

}
