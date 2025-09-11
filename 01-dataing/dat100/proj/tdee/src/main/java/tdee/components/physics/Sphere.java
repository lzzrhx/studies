package tdee.components.physics;

import tdee.Draw3;

import static com.raylib.Raylib.*;
public class Sphere implements CollisionShape {
    
    // Objektvariabler
    private Physics parent;
    private float radius;

    // Konstruktør
    public Sphere(Physics parent, float radius) {
        this.parent = parent;
        this.radius = radius;
    }

    // Getter for radius
    public float radius() {
        return radius;
    }

    // Oppdatering
    public void update() {
    }
    
    // Tegning av 3D grafikk
    public void render3(Color color) {
        Draw3.sphere(radius, parent.parent.matrix(), color);
    }

}
