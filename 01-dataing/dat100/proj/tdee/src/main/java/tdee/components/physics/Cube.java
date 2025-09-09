package tdee.components.physics;

import static com.raylib.Raylib.*;

public class Cube implements CollisionShape {

    // Objektvariabler
    private Physics parent;
    private Vector3 size;
    private Vector3[] verts = new Vector3[8];
    private Vector3[] vertsWorld = new Vector3[8];

    // Konstruktør
    public Cube(Physics parent, Vector3 size) {
        this.parent = parent;
        this.size = size;
        size = Vector3Scale(size, 0.5f);
        verts[0] = new Vector3().x(-size.x()).y(-size.y()).z(-size.z());
        verts[1] = new Vector3().x( size.x()).y(-size.y()).z(-size.z());
        verts[2] = new Vector3().x( size.x()).y( size.y()).z(-size.z());
        verts[3] = new Vector3().x(-size.x()).y( size.y()).z(-size.z());
        verts[4] = new Vector3().x(-size.x()).y( size.y()).z( size.z());
        verts[5] = new Vector3().x(-size.x()).y(-size.y()).z( size.z());
        verts[6] = new Vector3().x( size.x()).y(-size.y()).z( size.z());
        verts[7] = new Vector3().x( size.x()).y( size.y()).z( size.z());
        update();
    }

    // Getter for størrelse
    public Vector3 size() {
        return size;
    }

    // Getter for verts
    public Vector3[] verts() {
        return verts;
    }
    
    // Getter for vertsWorld
    public Vector3[] vertsWorld() {
        return vertsWorld;
    }

    // Oppdatering
    public void update() {
        for (int i = 0; i < 8; i++) {
            vertsWorld[i] = Vector3Transform(verts[i], parent.parent().matrix());
        }
    }

    // Tegning av kube
    public void draw(Color color) {
        DrawLine3D(vertsWorld[0], vertsWorld[1], color);
        DrawLine3D(vertsWorld[1], vertsWorld[3], color);
        DrawLine3D(vertsWorld[1], vertsWorld[2], color);
        DrawLine3D(vertsWorld[3], vertsWorld[0], color);
        DrawLine3D(vertsWorld[3], vertsWorld[2], color);
        DrawLine3D(vertsWorld[3], vertsWorld[4], color);
        DrawLine3D(vertsWorld[0], vertsWorld[5], color);
        DrawLine3D(vertsWorld[4], vertsWorld[5], color);
        DrawLine3D(vertsWorld[4], vertsWorld[7], color);
        DrawLine3D(vertsWorld[6], vertsWorld[7], color);
        DrawLine3D(vertsWorld[5], vertsWorld[7], color);
        DrawLine3D(vertsWorld[5], vertsWorld[6], color);
        DrawLine3D(vertsWorld[7], vertsWorld[2], color);
        DrawLine3D(vertsWorld[6], vertsWorld[1], color);
        DrawLine3D(vertsWorld[2], vertsWorld[4], color);
        DrawLine3D(vertsWorld[0], vertsWorld[6], color);
        DrawLine3D(vertsWorld[6], vertsWorld[2], color);
        DrawLine3D(vertsWorld[2], vertsWorld[4], color);
        DrawLine3D(vertsWorld[0], vertsWorld[4], color);
    }
}
