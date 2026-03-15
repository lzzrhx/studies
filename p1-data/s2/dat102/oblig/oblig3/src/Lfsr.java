package src;

// Generering av tilfeldige verdier ved bruk av linear-feedback shift register
public class Lfsr {
    private int seed;
    public Lfsr(int seed) { this.seed = seed; }
    public String toString() { return Integer.toString(seed); }
    public void seed(int seed) { this.seed = seed; }
    public int seed() { return seed; }

    // Shift 32-bit seed ved bruk av tap'er: 31,21,1,0
    public void shift32() {
        seed = ((((seed >> 31) & 1) ^ ((seed >> 21) & 1) ^ ((seed >> 1) & 1) ^ ((seed >> 0) & 1)) == 1) ? ((seed << 1) | 1) : (seed << 1);
    }

    // Generer 32-bit int fra 32-bit seed
    public int make32() {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            shift32();
            if ((seed & 1) == 1) { result |= mask; }
            mask <<= 1;
        }
        return result;
    }
    
    // Generer 32-bit int fra 32-bit seed med definert max verdi
    public int make32(int max) {
        return this.make32() % (max+1);
    }

    // Generer 32-bit int fra 32-bit seed med definert max verdi og definert om resultatet er positiv verdi
    public int make32(boolean pos, int max) {
        return pos ? Math.abs(this.make32(max)) : this.make32(max);
    }
}
