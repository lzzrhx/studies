package sat;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

// Hovedklasse for kjøring av programmet
public class Program {

    // Variabler for programinstillinger
    private static int screenWidth = 1200;
    private static int screenHeight = 900;
   
    // Debug variabler
    public static boolean debugCollision = true;

    // Entity variabler
    private static Entity player;
    private static Entity[] boxes = new Entity[4];
    private static Entity[] balls = new Entity[3];
    // private static Entity ground;

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
        SetTargetFPS(60);
        // Entity set up
        player = new Entity(new Vector3().y(0.5f));
        player.addCubePhysics(new Vector3().x(1f).y(1f).z(1f), 1f);

        boxes[0] = new Entity(new Vector3().x(1f).y(0.5f).z(-2f));
        boxes[0].addCubePhysics(new Vector3().x(1f).y(1f).z(1f), 1f);

        boxes[1] = new Entity(new Vector3().x(1.5f).y(1f).z(-3.5f));
        boxes[1].addCubePhysics(new Vector3().x(2f).y(2f).z(1f), 2f);

        boxes[2] = new Entity(new Vector3().x(2.5f).y(0.25f).z(-2f));
        boxes[2].addCubePhysics(new Vector3().x(1f).y(0.5f).z(1f), 1f);

        boxes[3] = new Entity(new Vector3().x(0f).y(2f).z(6f));
        boxes[3].addCubePhysics(new Vector3().x(4f).y(4).z(4f), 4f);

        balls[0] = new Entity(new Vector3().x(-1f).y(0.5f).z(-2f));
        balls[0].addSpherePhysics(0.5f, 1f);
        balls[1] = new Entity(new Vector3().x(-1f).y(0.5f).z(-3.5f));
        balls[1].addSpherePhysics(0.5f, 1f);
        balls[2] = new Entity(new Vector3().x(-2.5f).y(0.5f).z(-2f));
        balls[2].addSpherePhysics(0.5f, 1f);
        
        // ground = new Entity(new Vector3().y(-10f));
        // ground.addCubePhysics(new Vector3().x(20f).y(20f).z(20f), 0f);

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
        //if (Math.abs(rightStickX) > 0.1f) { player.physics.addForceRel(new Vector3().y(-0.2f * rightStickY)); }
        //if (Math.abs(rightStickY) > 0.1f) { player.physics.addForceRel(new Vector3().y(-12f * rightStickY)); }
        //if (Math.abs(leftStickX) > 0.1f) { player.physics.addTorqueRel(new Vector3().y(-0.20f * leftStickX)); }
        //if (Math.abs(leftStickY) > 0.1f) { player.physics.addTorqueRel(new Vector3().x(-0.15f * leftStickY)); }
        //if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_LEFT_TRIGGER_1)) { player.physics.addTorqueRel(new Vector3().z(0.15f)); }
        //if (IsGamepadButtonDown(0, GAMEPAD_BUTTON_RIGHT_TRIGGER_1)) { player.physics.addTorqueRel(new Vector3().z(-0.15f)); }
        // Tastatur
        if (IsKeyPressed(KEY_C)) { debugCollision = !debugCollision; }
        if (IsKeyDown(KEY_W)) { player.physics.addForceRel(new Vector3().z(-0.75f)); }
        else if (IsKeyDown(KEY_S)) { player.physics.addForceRel(new Vector3().z(0.75f)); }
        if (IsKeyDown(KEY_A)) { player.physics.addForceRel(new Vector3().x(-0.75f)); }
        else if (IsKeyDown(KEY_D)) { player.physics.addForceRel(new Vector3().x(0.75f)); }
        //if (IsKeyDown(KEY_SPACE)) { player.physics.addForceRel(new Vector3().y(12f)); }
        if (IsKeyDown(KEY_Q)) { player.physics.addTorqueRel(new Vector3().y(0.2f)); }
        else if (IsKeyDown(KEY_E)) { player.physics.addTorqueRel(new Vector3().y(-0.2f)); }
    }

    // Hovedløkke for oppdatering
    private static void update() {
        float dt = GetFrameTime();
        Entity.update(dt);
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
        Draw3.grid(100, MatrixMultiply(MatrixIdentity(), MatrixTranslate((float)(int)camera.worldPos().x(), 0f, (float)(int)camera.worldPos().z())), GRAY);
        Entity.render3();
        EndMode3D();
    }
    
    // 2D grafikk
    private static void render2() {
        DrawFPS(2, 2);
        DrawText(("pos x: " + Float.toString(player.pos().x()) + "   y: " + Float.toString(player.pos().y()) + "   z: " + Float.toString(player.pos().z())).toUpperCase(), 2, 20, 10, WHITE);
        DrawText(("collision: " + Boolean.toString(debugCollision)).toUpperCase(), 2, 30, 10, WHITE);
    }

}
