package src;

import java.util.Locale;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import java.util.List;
import java.util.ArrayList;

public class Program {
    // "Flytende" vindu
    private enum Window {
        NONE,
        LEGG_TIL_ANSATT,
        LEGG_TIL_AVDELING,
        LEGG_TIL_PROSJEKT,
        FILTRER_DATA,
        REDIGER_ANSATT,
        REDIGER_AVDELING,
        REDIGER_PROSJEKT
    }

    private enum Datatype {
        VARCHAR,
        DATE,
        INTEGER
    }

    // Konstanter
    private static final int window_width         = 1280;
    private static final int window_height        = 720;
    private static final int indent_width         = 16;
    private static final int margin_l             = 20;
    private static final int margin_top           = 10;
    private static final int font_size            = 16;
    private static final int font_spacing         = 1;
    private static final Color col_fg             = new Color().r((byte)0xbc).g((byte)0xbc).b((byte)0xbc).a((byte)0xff);
    private static final Color col_bg             = new Color().r((byte)0x1c).g((byte)0x1c).b((byte)0x1c).a((byte)0xff);
    private static final String txt_bunn_none     = "F1: LEGG TIL ANSATT  //  F2: LEGG TIL AVDELING  //  F3: LEGG TIL PROSJEKT  //  F4: FILTRER DATA  //  ESC: AVSLUTT PROGRAM";
    private static final String txt_bunn_window   = "ESC: AVBRYT";
    private static final String txt_bunn_edit     = "F1: LAGRE ENDRINGER  //  ESC: AVBRYT";
    private static final String txt_bunn_edit_ans = "F1: LAGRE ENDRINGER  //  F2: SLETT ANSATT  //  ESC: AVBRYT";
    private static final String txt_ansatte       = " [ ANSATTE ] ";
    private static final String txt_prosjekter    = " [ PROSJEKTER ] ";
    private static final int win_line_desc_chars  = 13;

    // UI-variabler
    private static Color col = new Color().a((byte)0xff);
    private static Font font;
    private static int margin_float_x;
    private static int margin_float_y;
    private static int txt_ansatte_w;
    private static int txt_prosjekter_w;
    private static int line;
    private static int window_line;
    private static String window_header;
    private static int win_content_margin;
    private static boolean blink;
    private static int blink_frame;
    
    // "State"-variabler
    private static Window window;
    private static int sel_avd;
    private static int sel_ans;
    private static int sel_win;
    private static int sel_tab;
    private static int max_sel_avd;
    private static int max_sel_ans;
    private static final int max_sel_tab = 1;
    private static String txt_bunn;
    private static boolean win_edit_enable;
    private static boolean win_edit_valid;
    private static boolean win_edit_del_allowed;
    private static int win_edit_pos;
    private static boolean win_edit_change;
    private static int win_edit_max_chars;

    // Datavariabler
    private static List<Avdeling> avdelinger;
    private static List<List<Ansatt>> ansatte;
    private static List<Datatype> window_lines_type = new ArrayList<>();
    private static List<Integer> window_lines_max_chars = new ArrayList<>();
    private static List<String> window_lines = new ArrayList<>();
    private static List<String> window_lines_desc = new ArrayList<>();
    private static List<String> window_lines_readonly = new ArrayList<>();
    private static List<String> window_lines_readonly_desc = new ArrayList<>();
   
    // Entry-point for programmet
    public static void main(String[] args) {
        init();
        run();
        exit();
    }
    
    // Initialisering av programmet
    private static void init() {
        SetTraceLogLevel(4);
        InitWindow(window_width, window_height, "oblig3");
        SetTargetFPS(60);
        changeTab(0);
        changeWindow(Window.NONE);
        font = LoadFontEx("./assets/PxPlusToshibaSat8x16.ttf", 16, (int[])null, 250);
        margin_float_x = margin_l+font_size*7;
        margin_float_y = margin_top+(int)(9.5*font_size);
        txt_ansatte_w = (int)MeasureTextEx(font, txt_ansatte, font_size, font_spacing).x();
        txt_prosjekter_w = (int)MeasureTextEx(font, txt_prosjekter, font_size, font_spacing).x();
        win_content_margin = margin_l+indent_width+(int)(font_size*0.5+font_spacing)*win_line_desc_chars;
        updateAnsatte();
    }

    // Hovedløkke
    private static void run() {
        while (!WindowShouldClose()) {
            input();
            update();
            draw();
        }
    }

    // Avslutting av programmet
    private static void exit() {
        CloseWindow();
    }

    // Håndter tastatur-innputt
    private static void input() {
        if (window == Window.NONE) {
            if (IsKeyPressed(KEY_F1)) {
                changeWindow(Window.LEGG_TIL_ANSATT);
            } else if (IsKeyPressed(KEY_F2)) {
                changeWindow(Window.LEGG_TIL_AVDELING);
            } else if (IsKeyPressed(KEY_F3)) {
                changeWindow(Window.LEGG_TIL_PROSJEKT);
            } else if (IsKeyPressed(KEY_F4)) {
                changeWindow(Window.FILTRER_DATA);
            } else if (IsKeyPressed(KEY_ENTER)) {
                tryEditMainSelection();
            } else if (IsKeyPressed(KEY_LEFT)) {
                changeTab(sel_tab-1);
            }
            else if (IsKeyPressed(KEY_RIGHT)) {
                changeTab(sel_tab+1);
            }
            else if (sel_tab == 0) {
                if (IsKeyPressed(KEY_UP) && (sel_avd > 1 || sel_ans > 0)) {
                    sel_ans--;
                    if (sel_ans < 0) {
                        changeSelAvdeling(sel_avd-1, true);
                    }
                }
                else if (IsKeyPressed(KEY_DOWN) && (sel_avd < max_sel_avd || sel_ans < max_sel_ans)) {
                    sel_ans++;
                    if (sel_ans > max_sel_ans) {
                        changeSelAvdeling(sel_avd+1, false);
                    }
                }
            }
        } else {
            if (win_edit_valid && !win_edit_enable && IsKeyPressed(KEY_F1)) {
                if (win_edit_change) {
                    saveEdit();
                }
                changeWindow(Window.NONE);
            } else if (win_edit_valid && !win_edit_enable && win_edit_del_allowed && IsKeyPressed(KEY_F2)) {
                delEntry();
                changeWindow(Window.NONE);
            } else if (IsKeyPressed(KEY_ESCAPE)) {
                if (win_edit_enable) {
                    toggleLineEditMode();
                } else {
                    changeWindow(Window.NONE);
                }
            } else if (IsKeyPressed(KEY_ENTER)) {
                toggleLineEditMode();
            } else if (win_edit_enable) {
                if (IsKeyPressed(KEY_LEFT)) {
                    changeLineEditPos(win_edit_pos-1);
                } else if (IsKeyPressed(KEY_RIGHT) && win_edit_pos < window_lines.get(sel_win-1).length()) {
                    changeLineEditPos(win_edit_pos+1);
                } else if (IsKeyPressed(KEY_HOME)) {
                    changeLineEditPos(0);
                } else if (IsKeyPressed(KEY_END)) {
                    changeLineEditPos(window_lines.get(sel_win-1).length()-1);
                } else if (IsKeyPressed(KEY_BACKSPACE)) {
                    delLineChar(win_edit_pos-1);
                } else if (IsKeyPressed(KEY_DELETE)) {
                    delLineChar(win_edit_pos);
                } else if (sel_win > 0) {
                    if (IsKeyPressed(KEY_ONE))   { insertLineChar('1'); }
                    else if (IsKeyPressed(KEY_TWO))   { insertLineChar('2'); }
                    else if (IsKeyPressed(KEY_THREE)) { insertLineChar('3'); }
                    else if (IsKeyPressed(KEY_FOUR))  { insertLineChar('4'); }
                    else if (IsKeyPressed(KEY_FIVE))  { insertLineChar('5'); }
                    else if (IsKeyPressed(KEY_SIX))   { insertLineChar('6'); }
                    else if (IsKeyPressed(KEY_SEVEN)) { insertLineChar('7'); }
                    else if (IsKeyPressed(KEY_EIGHT)) { insertLineChar('8'); }
                    else if (IsKeyPressed(KEY_NINE))  { insertLineChar('9'); }
                    else if (IsKeyPressed(KEY_ZERO))  { insertLineChar('0'); }
                    else if (window_lines_type.get(sel_win-1) == Datatype.VARCHAR) {
                        boolean caps = IsKeyDown(KEY_LEFT_SHIFT) || IsKeyDown(KEY_RIGHT_SHIFT) || IsKeyDown(KEY_CAPS_LOCK);
                        if (IsKeyPressed(KEY_SPACE))      { insertLineChar(' '); }
                        else if (IsKeyPressed(KEY_A)) { insertLineChar(caps ? 'A' : 'a'); }
                        else if (IsKeyPressed(KEY_B)) { insertLineChar(caps ? 'B' : 'b'); }
                        else if (IsKeyPressed(KEY_C)) { insertLineChar(caps ? 'C' : 'c'); }
                        else if (IsKeyPressed(KEY_D)) { insertLineChar(caps ? 'D' : 'd'); }
                        else if (IsKeyPressed(KEY_E)) { insertLineChar(caps ? 'E' : 'e'); }
                        else if (IsKeyPressed(KEY_F)) { insertLineChar(caps ? 'F' : 'f'); }
                        else if (IsKeyPressed(KEY_G)) { insertLineChar(caps ? 'G' : 'g'); }
                        else if (IsKeyPressed(KEY_H)) { insertLineChar(caps ? 'H' : 'h'); }
                        else if (IsKeyPressed(KEY_I)) { insertLineChar(caps ? 'I' : 'i'); }
                        else if (IsKeyPressed(KEY_J)) { insertLineChar(caps ? 'J' : 'j'); }
                        else if (IsKeyPressed(KEY_K)) { insertLineChar(caps ? 'K' : 'k'); }
                        else if (IsKeyPressed(KEY_L)) { insertLineChar(caps ? 'L' : 'l'); }
                        else if (IsKeyPressed(KEY_M)) { insertLineChar(caps ? 'M' : 'm'); }
                        else if (IsKeyPressed(KEY_N)) { insertLineChar(caps ? 'N' : 'n'); }
                        else if (IsKeyPressed(KEY_O)) { insertLineChar(caps ? 'O' : 'o'); }
                        else if (IsKeyPressed(KEY_P)) { insertLineChar(caps ? 'P' : 'p'); }
                        else if (IsKeyPressed(KEY_Q)) { insertLineChar(caps ? 'Q' : 'q'); }
                        else if (IsKeyPressed(KEY_R)) { insertLineChar(caps ? 'R' : 'r'); }
                        else if (IsKeyPressed(KEY_S)) { insertLineChar(caps ? 'S' : 's'); }
                        else if (IsKeyPressed(KEY_T)) { insertLineChar(caps ? 'T' : 't'); }
                        else if (IsKeyPressed(KEY_U)) { insertLineChar(caps ? 'U' : 'u'); }
                        else if (IsKeyPressed(KEY_V)) { insertLineChar(caps ? 'V' : 'v'); }
                        else if (IsKeyPressed(KEY_W)) { insertLineChar(caps ? 'W' : 'w'); }
                        else if (IsKeyPressed(KEY_X)) { insertLineChar(caps ? 'X' : 'x'); }
                        else if (IsKeyPressed(KEY_Y)) { insertLineChar(caps ? 'Y' : 'y'); }
                        else if (IsKeyPressed(KEY_Z)) { insertLineChar(caps ? 'Z' : 'z'); }
                    }
                }
            } else {
                if (IsKeyPressed(KEY_UP) && (sel_win > 1)) {
                    sel_win--;
                } else if (IsKeyPressed(KEY_DOWN) && sel_win < window_lines.size()) {
                    sel_win++;
                }
            }
        }
    }

    // Gjennomfør oppdateringer (per-frame)
    private static void update() {
        line = 0;
        if (win_edit_enable) {
            blink_frame++;
            if (blink_frame >= 30) {
                blink = !blink;
                blink_frame = 0;
            }
        }
        col.r((byte)(((Math.sin((double)System.currentTimeMillis() / 1500d) + 1d) * 50d) ));
        col.g((byte)(((Math.sin((double)System.currentTimeMillis() / 2000d) + 1d) * 50d) ));
        col.b((byte)(((Math.sin((double)System.currentTimeMillis() / 3500d) + 1d) * 50d) ));
    }

    // Tegn 2D-grafikk
    private static void draw() {
        BeginDrawing();
        ClearBackground(col);
        drawHeader();
        drawMain();
        drawFooter();
        drawWindow();
        DrawFPS(window_width-32, 2);
        EndDrawing();
    }
    
    // Tegn topptekst
    private static void drawHeader() {
        drawMainLine("HØGSKULEN PÅ VESTLANDET", 0);
        switch (sel_tab) {
            case 0:
                DrawRectangle(margin_l, margin_top+line*font_size, txt_ansatte_w, font_size, col_fg);
                break;
            case 1:
                DrawRectangle(margin_l+txt_ansatte_w, margin_top+line*font_size, txt_prosjekter_w, font_size, col_fg);
                break;
        }
        DrawTextEx(font, txt_ansatte, new Vector2().x(margin_l).y(margin_top+line*font_size), font_size, font_spacing, sel_tab == 0 ? col_bg : col_fg);
        DrawTextEx(font, txt_prosjekter, new Vector2().x(margin_l+txt_ansatte_w).y(margin_top+line*font_size), font_size, font_spacing, sel_tab == 1 ? col_bg : col_fg);
        line++;
        DrawLine(0,margin_top+line*font_size+(int)(font_size*0.5),window_width, margin_top+line*font_size+(int)(font_size*0.5),col_fg);line++;
    }

    // Tegn bunntekst
    private static void drawFooter() {
        DrawLine(0,window_height-font_size*2,window_width, window_height-font_size*2,col_fg);
        DrawTextEx(font, txt_bunn, new Vector2().x((window_width-(int)MeasureTextEx(font, txt_bunn, font_size, font_spacing).x())/2).y(window_height-(int)(font_size*1.5)), font_size, font_spacing, col_fg);
    }

    // Tegn hovedinnhold
    private static void drawMain() {
        switch (sel_tab) {
            // Liste av avdelinger/ansatte
            case 0:
                for (int i = 0; i < avdelinger.size(); i++) {
                    // Seleksjonsindikator
                    if (window == Window.NONE && sel_avd-1 == i) {
                        DrawTextEx(font, ">", new Vector2().x(margin_l).y(margin_top+(line+sel_ans)*font_size), font_size, font_spacing, col_fg);
                    }
                    // Avdelingstittel
                    drawMainLine(avdelinger.get(i).navn() + " (" + ansatte.get(i).size() + " ansatte)", indent_width);
                    // Liste av ansatte i avdeling
                    if (ansatte.get(i).size() == 0) {
                        drawMainLine("Ingen ansatte", indent_width*2);
                    } else {
                        DrawLine(margin_l+(int)(indent_width*1.5), margin_top+line*font_size+2, margin_l+(int)(indent_width*1.5), margin_top+(line+ansatte.get(i).size())*font_size-2, col_fg);
                        for (int j = 0; j < ansatte.get(i).size(); j++) {
                            Ansatt ansatt = ansatte.get(i).get(j);
                            drawMainLine((j == 0 ? "(sjef) " : "") + ansatt.fornavn() + " " + ansatt.etternavn() + ", " + ansatt.stilling(), indent_width*2);
                        }
                    }
                    // Tom linje mellom avdelinger
                    line++;
                }
                break;
            // Liste av prosjekter
            case 1:
                drawMainLine("Ingen prosjekter", indent_width);
                break;
        }
    }

    // Tegn tekstlinje i hovedvinduet
    private static void drawMainLine(String txt, int indent) {
        DrawTextEx(font, txt, new Vector2().x(margin_l+indent).y(margin_top+line*font_size), font_size, font_spacing, col_fg);
        line += 1;
    }

    // Tegn "flytende" vindu
    private static void drawWindow() {
        if (window != Window.NONE) {
            window_line = 1;
            DrawRectangle(margin_float_x+8, margin_float_y+8, window_width-margin_float_x*2, window_height-margin_float_y*2, col_bg);
            DrawRectangle(margin_float_x, margin_float_y, window_width-margin_float_x*2, window_height-margin_float_y*2, col_fg);
            DrawTextEx(font, window_header, new Vector2().x(margin_float_x+margin_l+indent_width).y(margin_float_y+window_line*font_size), font_size, font_spacing, col);
            window_line++;
            window_line++;
            for (int i = 0; i < window_lines.size(); i++) {
                drawWindowLine(window_lines_desc.get(i), window_lines.get(i));
            }
            window_line++;
            if (window_lines_readonly.size() > 0) {
                for (int i = 0; i < window_lines_readonly.size(); i++) {
                    drawWindowLine(window_lines_readonly_desc.get(i), window_lines_readonly.get(i));
                }
            }
            if (win_edit_enable) {
                if (blink) {
                    DrawRectangle(margin_float_x+win_content_margin+(int)(win_edit_pos*(font_size*0.5+font_spacing)),margin_float_y+(2+sel_win)*font_size, (int)(font_size*0.5), font_size, col);
                    if (win_edit_pos == 0 || win_edit_pos < window_lines.get(sel_win-1).length()) {
                        DrawTextEx(font, win_edit_pos < window_lines.get(sel_win-1).length() ? Character.toString(window_lines.get(sel_win-1).charAt(win_edit_pos)) : "-", new Vector2().x(margin_float_x+win_content_margin+(int)(win_edit_pos*(font_size*0.5+font_spacing))).y(margin_float_y+(2+sel_win)*font_size), font_size, font_spacing, col_fg);
                    }
                }
            } else if (sel_win > 0) {
                DrawTextEx(font, ">", new Vector2().x(margin_float_x+margin_l).y(margin_float_y+(2+sel_win)*font_size), font_size, font_spacing, col);
            }
        }
    }

    // Tegn tekstlinje i "flytende" vindu
    private static void drawWindowLine(String desc, String txt) {
        DrawTextEx(font, desc + ":", new Vector2().x(margin_float_x+margin_l+indent_width).y(margin_float_y+window_line*font_size), font_size, font_spacing, col);
        DrawTextEx(font, txt.equals("") ? "-" : txt, new Vector2().x(margin_float_x+win_content_margin).y(margin_float_y+window_line*font_size), font_size, font_spacing, col);
        window_line++;
    }

    // Oppdater listen av avdelinger/ansatte
    private static void updateAnsatte() {
        avdelinger = Avdeling.hentAlle();
        ansatte = new ArrayList<>();
        for (Avdeling avdeling : avdelinger) {
            ansatte.add(avdeling.hentAnsatte());
        }
        max_sel_avd = avdelinger.size();
        changeSelAvdeling(max_sel_avd > 0 ? 1 : 0, false);
    }

    private static void updateAnsMax() {
        max_sel_ans = sel_avd > 0 ? ansatte.get(sel_avd-1).size() : 0;
        if (sel_ans > max_sel_ans) { sel_ans = max_sel_ans; }
    }

    // Endre valgt avdeling
    private static void changeSelAvdeling(int n, boolean set_ans_to_last) {
        sel_avd = n;
        updateAnsMax();
        sel_ans = set_ans_to_last ? max_sel_ans : 0;
    }

    // Endre valgt tab
    private static void changeTab(int n) {
        if (n >= 0 && n <= max_sel_tab) {
            sel_tab = n;
        }
    }

    // Endre aktivt "flytende" vindu
    private static void changeWindow(Window window) {
        if (window == Window.NONE) {
            SetExitKey(KEY_ESCAPE);
            txt_bunn = txt_bunn_none;
        } else {
            clearWindowLines();
            win_edit_valid = false;
            win_edit_del_allowed = false;
            txt_bunn = txt_bunn_window;
            switch (window) {
                case Window.REDIGER_ANSATT:
                    Ansatt ansatt = ansatte.get(sel_avd-1).get(sel_ans-1);
                    Avdeling avdeling = avdelinger.get(sel_avd-1);
                    window_header = "REDIGER ANSATT (#" + ansatt.id() + ")";
                    addWindowLine("BRUKERNAVN", ansatt.brukernavn(), Datatype.VARCHAR, 4);
                    addWindowLine("FORNAVN", ansatt.fornavn(), Datatype.VARCHAR, 50);
                    addWindowLine("ETTERNAVN", ansatt.etternavn(), Datatype.VARCHAR, 50);
                    addWindowLine("STARTDATO", ansatt.startdatoAsString(), Datatype.DATE, 10);
                    addWindowLine("STILLING", ansatt.stilling(), Datatype.VARCHAR, 50);
                    addWindowLine("MÅNEDSLØNN", ansatt.lonn()+"", Datatype.INTEGER, 9);
                    addWindowLineReadonly("AVDELING", avdeling.navn());
                    win_edit_valid = true;
                    win_edit_del_allowed = !(avdeling.sjef() == ansatt.id());
                    txt_bunn = win_edit_del_allowed ? txt_bunn_edit_ans : txt_bunn_edit;
                    break;
                case Window.LEGG_TIL_ANSATT:
                    window_header = "LEGG TIL ANSATT";
                    addWindowLine("BRUKERNAVN", "", Datatype.VARCHAR, 4);
                    addWindowLine("FORNAVN", "", Datatype.VARCHAR, 50);
                    addWindowLine("ETTERNAVN", "", Datatype.VARCHAR, 50);
                    addWindowLine("STARTDATO", "01-01-2026", Datatype.DATE, 10);
                    addWindowLine("STILLING", "", Datatype.VARCHAR, 50);
                    addWindowLine("MÅNEDSLØNN", "0", Datatype.INTEGER, 9);
                    //addWindowLineReadonly("AVDELING", avdeling.navn());
                    win_edit_valid = true;
                    txt_bunn = txt_bunn_edit;
                    break;
                case Window.LEGG_TIL_AVDELING:
                case Window.LEGG_TIL_PROSJEKT:
                case Window.FILTRER_DATA:
                case Window.REDIGER_AVDELING:
                case Window.REDIGER_PROSJEKT:
                    window_header = window + " IKKE IMPLEMENTERT!";
                    break;
            }
            SetExitKey(KEY_NULL);
            sel_win = window_lines.size() == 0 ? 0 : 1;
            win_edit_enable = false;
            win_edit_change = false;
        }
        Program.window = window;
    }

    private static void addWindowLine(String desc, String txt, Datatype datatype, int max_chars) {
        window_lines_desc.add(desc);
        window_lines.add(txt);
        window_lines_type.add(datatype);
        window_lines_max_chars.add(max_chars);
    }
    
    private static void addWindowLineReadonly(String desc, String txt) {
        window_lines_readonly_desc.add(desc);
        window_lines_readonly.add(txt);
    }

    private static void clearWindowLines() {
        window_lines.clear();
        window_lines_type.clear();
        window_lines_max_chars.clear();
        window_lines_desc.clear();
        window_lines_readonly.clear();
        window_lines_readonly_desc.clear();
    }

    // Endre fra visningsmodus til redigeringsmodus
    private static void tryEditMainSelection() {
        switch (sel_tab) {
            case 0:
                if (sel_ans > 0) {
                    changeWindow(Window.REDIGER_ANSATT);
                } else if (sel_avd > 0) {
                    changeWindow(Window.REDIGER_AVDELING);
                }
                break;
            //case 1:
                //if (sel_proj > 0) {
                //    changeWindow(Window.REDIGER_PROSJEKT);
                //}
                //break;
        }
    }

    // Start / stop redigering av linje
    private static void toggleLineEditMode() {
        if (sel_win > 0) {
            win_edit_enable = !win_edit_enable;
            if (win_edit_enable) {
                win_edit_max_chars = window_lines_max_chars.get(sel_win-1);
                win_edit_pos = 0;
                resetBlink();
            }
        }
    }

    private static void resetBlink() {
        blink = true;
        blink_frame = 0;
    }

    // Endre karakterposisjon for linjeredigering
    private static void changeLineEditPos(int n) {
        resetBlink();
        n = n >= win_edit_max_chars ? win_edit_max_chars-1 : n;
        if (n >= 0) {
            if (window_lines_type.get(sel_win-1) == Datatype.DATE && window_lines.get(sel_win-1).charAt(n) == '-') {
                n = n > win_edit_pos ? n+1 : n-1;
            }
            win_edit_pos = n;
        }
    }

    // Endre karakter i valgt posisjon
    private static void changeLineChar(char new_char) {
        if (!(new_char == ' ' && win_edit_pos >= window_lines.get(sel_win-1).length())) {
            win_edit_change = true;
            char[] chars;
            char[] old_chars = window_lines.get(sel_win-1).toCharArray();
            if (win_edit_pos < window_lines.get(sel_win-1).length()) {
                chars = old_chars;
            } else {
                chars = new char[win_edit_pos+1];
                for (int i = 0; i < old_chars.length; i++) {
                    chars[i] = old_chars[i];
                }
                for (int i = old_chars.length; i < chars.length; i++) {
                    chars[i] = ' ';
                }
            }
            chars[win_edit_pos] = new_char;
            window_lines.set(sel_win-1, String.valueOf(chars));
        }
        changeLineEditPos(win_edit_pos+1);
    }
    
    // Sett inn karakter i valgt posisjon
    private static void insertLineChar(char new_char) {
        char[] old_chars = window_lines.get(sel_win-1).toCharArray();
        if (old_chars.length >= win_edit_max_chars) {
            changeLineChar(new_char);
        } else {
            if (old_chars.length < win_edit_max_chars && win_edit_pos <= win_edit_max_chars) {
            //if (!(new_char == ' ' && win_edit_pos >= window_lines.get(sel_win-1).length()) && old_chars.length < win_edit_max_chars && win_edit_pos <= win_edit_max_chars) {
                win_edit_change = true;
                char[] chars = new char[win_edit_pos+1 > old_chars.length ? win_edit_pos+1 : old_chars.length+1];
                for (int i = 0; i < old_chars.length; i++) {
                    chars[i >= win_edit_pos ? i+1 : i] = old_chars[i];
                }
                for (int i = win_edit_pos < old_chars.length ? old_chars.length + 1 : old_chars.length; i < chars.length; i++) {
                    chars[i] = ' ';
                }
                chars[win_edit_pos] = new_char;
                window_lines.set(sel_win-1, String.valueOf(chars));
            }
            changeLineEditPos(win_edit_pos+1);
        }
    }
   
    // Slett karakter på valgt posisjon
    private static void delLineChar(int n) {
        char[] old_chars = window_lines.get(sel_win-1).toCharArray();
        if (n >= 0 && n < old_chars.length) {
            win_edit_change = true;
            if (old_chars.length == 1) {
                window_lines.set(sel_win-1, window_lines_type.get(sel_win-1) == Datatype.INTEGER ? "0" : "");
            } else {
                char[] chars = new char[old_chars.length-1];
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = old_chars[i >= n ? i+1 : i];
                }
                window_lines.set(sel_win-1, String.valueOf(chars));
            }
        }
        changeLineEditPos(n);
    }

    // Lagre endringer
    private static void saveEdit() {
        switch(window) {
            case Window.LEGG_TIL_ANSATT:
                ansatte.get(sel_avd-1).add(new Ansatt(window_lines.get(0), window_lines.get(1), window_lines.get(2), window_lines.get(3), window_lines.get(4), window_lines.get(5), 1));
                updateAnsMax();
                break;
            case Window.REDIGER_ANSATT:
                ansatte.get(sel_avd-1).get(sel_ans-1).oppdater(window_lines.get(0), window_lines.get(1), window_lines.get(2), window_lines.get(3), window_lines.get(4), window_lines.get(5));
                break;
        }
    }

    // Slett
    private static void delEntry() {
        switch(window) {
            case Window.REDIGER_ANSATT:
                ansatte.get(sel_avd-1).get(sel_ans-1).slett();
                ansatte.get(sel_avd-1).remove(sel_ans-1);
                updateAnsMax();
                break;
        }
    }

}
