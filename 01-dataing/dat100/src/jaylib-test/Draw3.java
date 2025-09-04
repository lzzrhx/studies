import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Draw3 {
    
    public static void circle(float radius, Matrix matrix, Color color)
    {
        int points = 20 + (int)(radius * 4f);
        Vector3[] circlePoints = new Vector3[points];
        for (int i = 0; i < points; i++)
        {
            circlePoints[i] = new Vector3();
            float circlePos = 1f / (float)points * (float)i * (float)Math.PI * 2f;
            circlePoints[i].x((float)Math.sin(circlePos) * radius);
            circlePoints[i].z((float)Math.cos(circlePos) * radius);
        }
        for (int i = 0; i < points; i++)
        {
            DrawLine3D(Vector3Transform(circlePoints[i], matrix), Vector3Transform(circlePoints[(i + 1) % points], matrix), color);
        }
    }

    public static void grid(int size, Matrix matrix, Color color)
    {
        for (int i = -size; i <= size; i++)
        {
            DrawLine3D(Vector3Transform(new Vector3().x(-(float)size).y(0f).z((float)i), matrix), Vector3Transform(new Vector3().x((float)size).y(0f).z((float)i), matrix), color);
            DrawLine3D(Vector3Transform(new Vector3().x((float)i).y(0f).z(-(float)size), matrix), Vector3Transform(new Vector3().x((float)i).y(0f).z((float)size), matrix), color);
        }
    }

    public static void axes(float size, Matrix matrix)
    {
        DrawLine3D(Vector3Transform(new Vector3().x(-size).y(0f).z(0f), matrix), Vector3Transform(new Vector3().x(size).y(0f).z(0f), matrix), RED);
        DrawLine3D(Vector3Transform(new Vector3().x(0f).y(-size).z(0f), matrix), Vector3Transform(new Vector3().x(0f).y(size).z(0f), matrix), BLUE);
        DrawLine3D(Vector3Transform(new Vector3().x(0f).y(0f).z(-size), matrix), Vector3Transform(new Vector3().x(0f).y(0f).z(size), matrix), GREEN);
    }

    
    public static void box(float size, Matrix matrix, Color color)
    {
        Vector3[] points = new Vector3[8];
        points[0] = Vector3Transform(new Vector3().x(-size).y( size).z(-size), matrix);
        points[1] = Vector3Transform(new Vector3().x( size).y( size).z(-size), matrix);
        points[2] = Vector3Transform(new Vector3().x(-size).y(-size).z(-size), matrix);
        points[3] = Vector3Transform(new Vector3().x( size).y(-size).z(-size), matrix);
        points[4] = Vector3Transform(new Vector3().x(-size).y( size).z( size), matrix);
        points[5] = Vector3Transform(new Vector3().x( size).y( size).z( size), matrix);
        points[6] = Vector3Transform(new Vector3().x(-size).y(-size).z( size), matrix);
        points[7] = Vector3Transform(new Vector3().x( size).y(-size).z( size), matrix);
        DrawLine3D(points[0], points[1], color);
        DrawLine3D(points[2], points[3], color);
        DrawLine3D(points[0], points[2], color);
        DrawLine3D(points[1], points[3], color);
        DrawLine3D(points[4], points[5], color);
        DrawLine3D(points[6], points[7], color);
        DrawLine3D(points[4], points[6], color);
        DrawLine3D(points[5], points[7], color);
        DrawLine3D(points[0], points[4], color);
        DrawLine3D(points[1], points[5], color);
        DrawLine3D(points[2], points[6], color);
        DrawLine3D(points[3], points[7], color);
    }

}
