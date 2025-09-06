import static com.raylib.Raylib.*;

public class Camera {
    private static final int CAMERA_MIN_DIST = 5;
    private static final int CAMERA_MAX_DIST = 20;
    private static final float CAMERA_SPEED_PAN = 0.05f;
    private static final float CAMERA_SPEED_DISTANCE = 0.1f;
    private Camera3D camera;
    private Vector2 rotation = new Vector2();
    private Vector3 pos = new Vector3();
    private Entity target;
    private int targetDistance = 50;
    private float distance = 50f;
    private float distanceMultiplier() { return Smoothstep.quarticPolynomial(distance / 100f); }
    private float speedMultiplier() { return 0.3f + distanceMultiplier() * 0.7f; }

    // Konstruktør
    public Camera(Entity target) {
        camera = new Camera3D();
        camera.up(new Vector3().x(0f).y(1f).z(0f));
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
            rotation.x(rotation.x() - mouseDelta.x());
            rotation.y(rotation.y() + mouseDelta.y());
        }
        // Tastaturkontroll for rotering av kamera
        if (IsKeyDown(KEY_UP)) { rotation.y(rotation.y() + CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_DOWN)) { rotation.y(rotation.y() - CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_LEFT)) { rotation.x(rotation.x() - CAMERA_SPEED_PAN * speedMultiplier()); }
        if (IsKeyDown(KEY_RIGHT)) { rotation.x(rotation.x() + CAMERA_SPEED_PAN * speedMultiplier()); }
        // Musekontroll for zoom av kamera
        if (GetMouseWheelMove() > 0f && targetDistance >= 5) { targetDistance -= 5; }
        if (GetMouseWheelMove() < 0f && targetDistance <= 95) { targetDistance += 5; }
        // Tastaturkontroll for zoom av kamera
        if (GetCharPressed() == 45 && targetDistance < 100) { targetDistance++; }
        if (GetCharPressed() == 43 && targetDistance > 0) { targetDistance--; }
    }

    // Oppdatering av kameraet
    public void update(float deltaTime) {
        camera.target(target.pos());
        float targetDifference = (float)Math.abs(distance - (float)targetDistance);
        if (targetDifference > 0.01f) { distance += (distance < (float)targetDistance ? CAMERA_SPEED_DISTANCE : -CAMERA_SPEED_DISTANCE ) * targetDifference; }
        rotation.x(rotation.x() % ((float)Math.PI * 2f));
        rotation.y(Utils.clampF(rotation.y(), (float)Math.PI * -0.5f, (float)Math.PI * 0.5f));
        pos.x((float)Math.sin(rotation.x()) * (float)Math.cos(rotation.y()));
        pos.y((float)Math.sin(rotation.y()));
        pos.z((float)Math.cos(rotation.x()) * (float)Math.cos(rotation.y()));
        camera._position(Vector3Transform(Vector3Scale(pos, (float)CAMERA_MIN_DIST + distanceMultiplier() * ((float)CAMERA_MAX_DIST - (float)CAMERA_MIN_DIST)), target.matrix()));
    }

}
