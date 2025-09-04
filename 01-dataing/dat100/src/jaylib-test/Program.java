
// Dette programmet krever "jaylib-5.5.0-2.jar" fra https://github.com/electronstudio/jaylib/releases/tag/v5.5.0-2

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import static com.raylib.Helpers.newRectangle;

public class Program {
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    private static Camera3D camera;
    private static Matrix cameraMatrix = MatrixIdentity();
    private static Vector2 cameraRotation = new Vector2();
    private static Vector3 cameraPosition = new Vector3();

    //private static float cameraDistanceMultiplier { get { return Smoothstep.QuarticPolynomial(cameraDistance / 100f); } }
    //private static float cameraSpeedMultiplier { get { return 0.2f + cameraDistanceMultiplier * 0.8f; } }
    private static float cameraDistanceMultiplier = 1f;
    private static float cameraSpeedMultiplier = 1f;

    private static Vector3 circPos = new Vector3();
    private static Vector3 boxPos = new Vector3().y(1f);

    // Entry point
    public static void main(String args[]) {
        init();
        run();
        exit();
    }

    // Initialization
    private static void init() {
        Logger.log("Initializing program");
        InitWindow(screenWidth, screenHeight, "jaylib");
        SetTargetFPS(30);
        camera = new Camera3D();
        camera._position(new Vector3().x(0f).y(5f).z(-10f));
        camera.target(new Vector3().x(0f).y(0f).z(0f));
        camera.up(new Vector3().x(0f).y(1f).z(0f));
        camera.fovy(45);
        camera.projection(CAMERA_PERSPECTIVE);
    }

    // Exit the program
    private static void exit() {
        CloseWindow();
    }

    // Main loop
    private static void run() {
        while (!WindowShouldClose()) {
            input();
            update();
            render();
        }
    }

    // Get input
    private static void input() {
        inputCamera();
    }

    // ...
    private static void update() {
        float deltaTime = GetFrameTime();
        updateCamera(deltaTime);
        circPos.y((float)Math.sin(GetTime()));
        //cameraRotation.x(cameraRotation.x() + 0.01f);
    }

    private static void inputCamera() {
        if (IsMouseButtonDown(MOUSE_BUTTON_LEFT))
        {
            //cameraSpeedInactive = 0f;
            Vector2 mouseDelta = Vector2Scale(GetMouseDelta(), 0.005f * cameraSpeedMultiplier * cameraSpeedMultiplier);
            cameraRotation.x(cameraRotation.x() - mouseDelta.x());
            cameraRotation.y(cameraRotation.y() + mouseDelta.y());
        }
        /*
        if (charPressed == 45 && cameraTargetDistance < 100) { cameraTargetDistance++; }
        if (charPressed == 43 && cameraTargetDistance > 0) { cameraTargetDistance--; }
        if (Raylib.IsKeyDown(KeyboardKey.Up)) { cameraRotation.Y += cameraSpeedPan * cameraSpeedMultiplier; cameraSpeedInactive = 0f; }
        if (Raylib.IsKeyDown(KeyboardKey.Down)) { cameraRotation.Y -= cameraSpeedPan * cameraSpeedMultiplier; cameraSpeedInactive = 0f; }
        if (Raylib.IsKeyDown(KeyboardKey.Left)) { cameraRotation.X += (cameraNorthUp ? -cameraSpeedPan : cameraSpeedPan) * cameraSpeedMultiplier; cameraSpeedInactive = 0f; }
        if (Raylib.IsKeyDown(KeyboardKey.Right)) { cameraRotation.X += (cameraNorthUp ? cameraSpeedPan : -cameraSpeedPan) * cameraSpeedMultiplier; cameraSpeedInactive = 0f; }
        if (Raylib.GetMouseWheelMove() > 0f && cameraTargetDistance >= 5) { cameraTargetDistance -= 5; }
        if (Raylib.GetMouseWheelMove() < 0f && cameraTargetDistance <= 95) { cameraTargetDistance += 5; }
        */
    }

    private static void updateCamera(float deltaTime) {
        //cameraRotation.x(cameraRotation.x() % (float)Math.PI * 2);
        //cameraRotation.y(cameraRotation.y() % (float)Math.PI * 2);
        cameraPosition.x((float)Math.sin(cameraRotation.x()) * (float)Math.cos(cameraRotation.y()));
        cameraPosition.y((float)Math.sin(cameraRotation.y()));
        cameraPosition.z((float)Math.cos(cameraRotation.x()) * (float)Math.cos(cameraRotation.y()));
        //cameraUp.x((float)Math.sin(cameraRotation.x()) * (float)Math.cos(cameraRotation.y() + 0.1f));
        //cameraUp.y((float)Math.sin(cameraRotation.y() + 0.1f));
        //cameraUp.z((float)Math.cos(cameraRotation.c()) * (float)Math.cos(cameraRotation.y() + 0.1f));
        
        camera._position(Vector3Scale(cameraPosition, 10f));
        //camera._position(Vector3Transform(cameraPosition, cameraMatrix));
        //* (1.5f + cameraDistanceMultiplier * 5f), planetarySystem.planetMatrix);
    }

    // Rendering
    private static void render() {
        //UpdateCamera(camera, CAMERA_ORBITAL);
        BeginDrawing();
        ClearBackground(DARKGRAY);
        render3D();
        EndDrawing();
    }

    // 3D rendering
    private static void render3D() {
        BeginMode3D(camera);
        //DrawGrid(1000, 1f);
        //DrawPlane(new Vector3(),new Vector2().x(1f).y(1f),RED);
        //Vector3 circPos = new Vector3();
        
        Matrix circMatrix = MatrixIdentity();
        circMatrix = MatrixTranslate(circPos.x(), circPos.y(), circPos.z());
        
        Matrix boxMatrix = MatrixIdentity();
        boxMatrix = MatrixTranslate(boxPos.x(), boxPos.y(), boxPos.z());

        //circMatrix = MatrixScale(0.5f,0.5f,0.5f);
        Draw3.circle(4f, circMatrix, BLUE);
        Draw3.grid(100, MatrixIdentity(), RED);
        Draw3.box(1f, boxMatrix, GREEN);
        Draw3.axes(1f, circMatrix);
        Draw3.axes(1f, boxMatrix);

        EndMode3D();
    }
    
    // 2D rendering
    private static void render2D() {
        //DrawText("jaylib", 190, 200, 20, VIOLET);
        //GuiLabel(new Rectangle().x(120f).y(120f).width(100f).height(32f), "Hello world");
        DrawFPS(20, 20);
    }
}
