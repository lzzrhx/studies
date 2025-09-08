package tdee;

import static com.raylib.Raylib.*;

public class Camera {
    private static final int CAMERA_MIN_DIST = 5;
    private static final int CAMERA_MAX_DIST = 20;
    private static final float CAMERA_SPEED_PAN = 0.05f;
    private static final float CAMERA_SPEED_DISTANCE = 0.1f;
    private Camera3D camera;
    private Vector2 rot = new Vector2().y((float)Math.PI * 0.25f);
    private Vector3 pos = new Vector3();
    private Vector3 up = new Vector3().y(1f);
    private Entity target;
    private int targetDistance = 50;
    private float distance = 50f;
    private float distanceMultiplier() { return Smoothstep.quarticPolynomial(distance / 100f); }
    private float speedMultiplier() { return 0.3f + distanceMultiplier() * 0.7f; }

    // Konstruktør
    public Camera(Entity target) {
        camera = new Camera3D();
        camera.up(up);
        camera.fovy(45);
        camera.projection(CAMERA_PERSPECTIVE);
        this.target = target;
    }
    
    // Getter for kameraets Camera3D objekt
    public Camera3D camera() {
        return camera;
    }

    // Innputt for kamerakontroll
    public void input() {
        // Musekontroll for rotering av kamera
        if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
            Vector2 mouseDelta = Vector2Scale(GetMouseDelta(), 0.004f * speedMultiplier());
            rot.x(rot.x() - mouseDelta.x());
            rot.y(rot.y() + mouseDelta.y());
        }
        // Tastaturkontroll for rotering av kamera
        if (IsKeyDown(KEY_UP)) { rot.y(rot.y() + CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_DOWN)) { rot.y(rot.y() - CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_LEFT)) { rot.x(rot.x() - CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_RIGHT)) { rot.x(rot.x() + CAMERA_SPEED_PAN * speedMultiplier()); }
        // Musekontroll for zoom av kamera
        if (GetMouseWheelMove() > 0f && targetDistance >= 5) { targetDistance -= 5; }
        if (GetMouseWheelMove() < 0f && targetDistance <= 95) { targetDistance += 5; }
        // Tastaturkontroll for zoom av kamera
        if (GetCharPressed() == 45 && targetDistance < 100) { targetDistance++; }
        if (GetCharPressed() == 43 && targetDistance > 0) { targetDistance--; }
        // Joystick-kontroll for rotering av kamera
        float rightStickX = GetGamepadAxisMovement(0, GAMEPAD_AXIS_RIGHT_X);
        float rightStickY = GetGamepadAxisMovement(0, GAMEPAD_AXIS_RIGHT_Y);
        if (Math.abs(rightStickX) > 0.1f) { rot.x(rot.x() + CAMERA_SPEED_PAN * speedMultiplier() * -rightStickX * 1.5f); }
        if (Math.abs(rightStickY) > 0.1f) { rot.y(rot.y() + CAMERA_SPEED_PAN * speedMultiplier() * rightStickY * 1.5f); }
    }

    // Oppdatering av kameraet
    public void update(float deltaTime) {
        camera.target(target.pos());
        float targetDifference = (float)Math.abs(distance - (float)targetDistance);
        if (targetDifference > 0.01f) { distance += (distance < (float)targetDistance ? CAMERA_SPEED_DISTANCE : -CAMERA_SPEED_DISTANCE ) * targetDifference; }
        rot.x(rot.x() % ((float)Math.PI * 2f));
        rot.y(Utils.clampF(rot.y(), (float)Math.PI * -0.5f, (float)Math.PI * 0.5f));
        pos.x((float)Math.sin(rot.x()) * (float)Math.cos(rot.y()));
        pos.y((float)Math.sin(rot.y()));
        pos.z((float)Math.cos(rot.x()) * (float)Math.cos(rot.y()));
        up.x((float)Math.sin(rot.x()) * (float)Math.cos(rot.y() + 0.1f));
        up.y((float)Math.sin(rot.y() + 0.1f));
        up.z((float)Math.cos(rot.x()) * (float)Math.cos(rot.y() + 0.1f));
        camera.up(Vector3Transform(up, MatrixMultiply(MatrixIdentity(), MatrixRotateXYZ(target.rot()))));
        camera._position(Vector3Transform(Vector3Scale(pos, (float)CAMERA_MIN_DIST + distanceMultiplier() * ((float)CAMERA_MAX_DIST - (float)CAMERA_MIN_DIST)), target.matrix()));
    }

}
