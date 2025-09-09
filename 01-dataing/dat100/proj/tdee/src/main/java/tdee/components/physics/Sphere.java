package tdee.components.physics;

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

}
