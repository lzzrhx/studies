package src;

public class Lfsr {
    public static void shift32(Seed seed) {
        boolean result = ((
        ((seed.val >> 31) & 0b00000000_00000000_00000000_00000001) ^
        ((seed.val >> 21) & 0b00000000_00000000_00000000_00000001) ^
        ((seed.val >> 1)  & 0b00000000_00000000_00000000_00000001) ^
        ((seed.val >> 0)  & 0b00000000_00000000_00000000_00000001)
        ) == 0b00000000_00000000_00000000_00000001);
        seed.val <<= 1;
        if (result) { seed.val |= 0b00000000_00000000_00000000_00000001; }
    }

    public static boolean check32(Seed seed) {
        shift32(seed);
        if ((seed.val & 0b00000000_00000000_00000000_00000001) == 0b00000000_00000000_00000000_00000001) { return true; }
        return false;
    }

    public static int make32(Seed seed) {
        int result = 0b00000000_00000000_00000000_00000000;
        int mask   = 0b00000000_00000000_00000000_00000001;
        for (int i = 0; i < 32; i++) {
            shift32(seed);
            if ((seed.val & 0b00000000_00000000_00000000_00000001) == 0b00000000_00000000_00000000_00000001) { result |= mask; }
            mask <<= 1;
        }
        return result;
    }
}
