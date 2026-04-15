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

    // Konstanter
    private static final int window_width       = 1280;
    private static final int window_height      = 720;
    private static final int indent_width       = 16;
    private static final int margin_l           = 20;
    private static final int margin_top         = 10;
    private static final int font_size          = 16;
    private static final int font_spacing       = 1;
    private static final Color col_fg           = new Color().r((byte)0xbc).g((byte)0xbc).b((byte)0xbc).a((byte)0xff);
    private static final Color col_bg           = new Color().r((byte)0x1c).g((byte)0x1c).b((byte)0x1c).a((byte)0xff);
    private static final String txt_bunn_none   = "F1: LEGG TIL ANSATT  //  F2: LEGG TIL AVDELING  //  F3: LEGG TIL PROSJEKT  //  F4: FILTRER DATA  //  ESC: AVSLUTT PROGRAM";
    private static final String txt_bunn_window = "ESC: AVBRYT";
    private static final String txt_ansatte     = " [ ANSATTE ] ";
    private static final String txt_prosjekter  = " [ PROSJEKTER ] ";

    // UI-variabler
    private static Color col = new Color().a((byte)0xff);
    private static Font font;
    private static int margin_float_x;
    private static int margin_float_y;
    private static int txt_ansatte_w;
    private static int txt_prosjekter_w;
    private static int line;
    private static int window_line;
    
    // "State"-variabler
    private static Window window;
    private static int sel_avd;
    private static int sel_ans;
    private static int sel_win;
    private static int sel_tab;
    private static int max_sel_avd;
    private static int max_sel_ans;
    private static int max_sel_win;
    private static final int max_sel_tab = 1;
    private static String txt_bunn;

    // Datavariabler
    private static List<Avdeling> avdelinger;
    private static List<List<Ansatt>> ansatte;
   
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
        font = LoadFontEx("PxPlusToshibaSat8x16.ttf", 16, (int[])null, 250);
        margin_float_x = margin_l+font_size*7;
        margin_float_y = margin_top+(int)(9.5*font_size);
        txt_ansatte_w = (int)MeasureTextEx(font, txt_ansatte, font_size, font_spacing).x();
        txt_prosjekter_w = (int)MeasureTextEx(font, txt_prosjekter, font_size, font_spacing).x();
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
        if (window != Window.NONE && IsKeyPressed(KEY_ESCAPE)) {
            changeWindow(Window.NONE);
        }
        switch (window) {
            case Window.NONE:
                if (IsKeyPressed(KEY_F1)) {
                    changeWindow(Window.LEGG_TIL_ANSATT);
                } else if (IsKeyPressed(KEY_F2)) {
                    changeWindow(Window.LEGG_TIL_AVDELING);
                } else if (IsKeyPressed(KEY_F3)) {
                    changeWindow(Window.LEGG_TIL_PROSJEKT);
                } else if (IsKeyPressed(KEY_F4)) {
                    changeWindow(Window.FILTRER_DATA);
                } else if (IsKeyPressed(KEY_ENTER)) {
                    changeToEditMode();
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
                break;
            case Window.REDIGER_ANSATT:
                if (IsKeyPressed(KEY_UP) && (sel_win > 1)) {
                    sel_win--;
                }
                else if (IsKeyPressed(KEY_DOWN) && sel_win < max_sel_win) {
                    sel_win++;
                }
                break;
        }
    }

    // Gjennomfør oppdateringer (per-frame)
    private static void update() {
        line = 0;
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
            if (sel_win > 0) {
                DrawTextEx(font, ">", new Vector2().x(margin_float_x+margin_l).y(margin_float_y+(2+sel_win)*font_size), font_size, font_spacing, col);
            }
            switch (window) {
                case Window.REDIGER_ANSATT:
                    Ansatt ansatt = ansatte.get(sel_avd-1).get(sel_ans-1);
                    Avdeling avdeling = avdelinger.get(sel_avd-1);
                    boolean sjef = avdeling.sjef() == ansatt.id();
                    drawWindowLine("REDIGER ANSATT (#" + ansatt.id() + ")");
                    window_line++;
                    drawWindowLine("BRUKERNAVN:  " + ansatt.brukernavn());
                    drawWindowLine("FORNAVN:     " + ansatt.fornavn());
                    drawWindowLine("ETTERNAVN:   " + ansatt.etternavn());
                    drawWindowLine("STARTDATO:   " + ansatt.startdato());
                    drawWindowLine("STILLING:    " + ansatt.stilling());
                    drawWindowLine("MÅNEDSLØNN:  " + ansatt.lonn() + " NOK");
                    drawWindowLine("AVDELING:    " + avdeling.navn());
                    break;
                case Window.REDIGER_AVDELING:
                case Window.REDIGER_PROSJEKT:
                case Window.LEGG_TIL_ANSATT:
                case Window.LEGG_TIL_AVDELING:
                case Window.LEGG_TIL_PROSJEKT:
                case Window.FILTRER_DATA:
                    DrawTextEx(font, window + " IKKE IMPLEMENTERT!", new Vector2().x(margin_float_x+margin_l).y(margin_float_y+window_line*font_size), font_size, font_spacing, col); window_line++;
                    break;
            }
        }
    }

    // Tegn tekstlinje i "flytende" vindu
    private static void drawWindowLine(String txt) {
        DrawTextEx(font, txt, new Vector2().x(margin_float_x+margin_l+indent_width).y(margin_float_y+window_line*font_size), font_size, font_spacing, col);
        window_line += 1;
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

    // Endre valgt avdeling
    private static void changeSelAvdeling(int n, boolean set_ans_to_last) {
        sel_avd = n;
        max_sel_ans = n > 0 ? ansatte.get(sel_avd-1).size() : 0;
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
            SetExitKey(KEY_NULL);
            txt_bunn = txt_bunn_window;
            if (window == Window.REDIGER_ANSATT) {
                sel_win = 1;
                max_sel_win = 7;
            } else {
                sel_win = 0;
            }
        }
        Program.window = window;
    }

    // Endre fra visningsmodus til redigeringsmodus
    private static void changeToEditMode() {
        switch (sel_tab) {
            case 0:
                if (sel_ans > 0) {
                    changeWindow(Window.REDIGER_ANSATT);
                } else if (sel_avd > 0) {
                    changeWindow(Window.REDIGER_AVDELING);
                }
                break;
            case 1:
                //if (sel_proj > 0) {
                //    changeWindow(Window.REDIGER_PROSJEKT);
                //}
                break;
        }
    }

}
