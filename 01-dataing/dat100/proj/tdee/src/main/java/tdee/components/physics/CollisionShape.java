package tdee.components.physics;

import com.raylib.Raylib.*; 

public interface CollisionShape {
    public void update();
    public void render3(Color color);
}
