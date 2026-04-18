package no.hvl.dat107;

import static com.raylib.Raylib.*;

public class Const {
    public static final String TITLE = "HØGSKULEN PÅ VESTLANDET";
    public static final Color COL_FG = new Color().r((byte)0xbc).g((byte)0xbc).b((byte)0xbc).a((byte)0xff);
    public static final Color COL_BG = new Color().r((byte)0x1c).g((byte)0x1c).b((byte)0x1c).a((byte)0xff);
    public static final int FONT_HEIGHT = 16;
    public static final int FONT_WIDTH = FONT_HEIGHT>>1;
    public static final int FONT_SPACING = 1;
    public static final int INDENT = 2;
    public static final int NUM_COLS = 160;
    public static final int NUM_LINES = 45;
    public static final int NUM_HEADER_LINES = 3;
    public static final int NUM_FOOTER_LINES = 2;
    public static final int NUM_MARGIN_LINES = 1;
    public static final int NUM_MAIN_LINES = NUM_LINES - NUM_HEADER_LINES - NUM_FOOTER_LINES - NUM_MARGIN_LINES;
    public static final String TXT_FOOTER_NONE = "F1: LEGG TIL ANSATT  //  F2: LEGG TIL AVDELING  //  F3: LEGG TIL PROSJEKT  //  F4: FILTRER DATA  //  ESC: AVSLUTT PROGRAM";
    public static final int WINDOW_WIDTH = FONT_WIDTH * NUM_COLS;
    public static final int WINDOW_HEIGHT = FONT_HEIGHT * NUM_LINES;
}