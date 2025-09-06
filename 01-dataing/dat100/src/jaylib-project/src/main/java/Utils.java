public class Utils{

    // Clamp float verdi innenfor en gitt minimum og maksimum verdi
    public static float clampF(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
}
