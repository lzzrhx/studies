package src;

import java.util.Locale;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import java.util.List;
import java.util.ArrayList;

public class Program {

    // Flytende vindu
    private enum Window {
        NONE,
        //LEGG_TIL,
        LEGG_TIL_ANSATT,
        LEGG_TIL_AVDELING,
        //LEGG_TIL_PROSJEKT,
        //FILTRER,
        REDIGER_ANSATT,
        //REDIGER_AVDELING,
        //REDIGER_PROSJEKT
    }

    // Klassevariabler
    private static Window window = Window.NONE;
    private static final int l_margin = 2;
    private static final int window_width = 1280;
    private static final int window_height = 720;
    private static final int margin_l = 20;
    private static final int indent_width = 16;
    private static final int margin_top = 10;
    private static final int font_size = 16;
    private static final int font_spacing = 1;
    private static final Color col_fg     = new Color().r((byte)0xbc).g((byte)0xbc).b((byte)0xbc).a((byte)0xff);
    private static final Color col_bg     = new Color().r((byte)0x1c).g((byte)0x1c).b((byte)0x1c).a((byte)0xff);
    private static List<Avdeling> avdelinger;
    private static List<List<Ansatt>> ansatte;
    private static Font font;
    private static Color col = new Color().a((byte)0xff);
    private static int sel_tab = 0;
    private static int sel_avd = 0;
    private static int sel_ans = 0;
    private static int max_sel_avd;
    private static int max_sel_ans;
    private static int margin_float_x;
    private static int margin_float_y;

    private static void init() {
        margin_float_x = margin_l+font_size*7;
        margin_float_y = margin_top+(int)(9.5*font_size);
        SetTraceLogLevel(4);
        InitWindow(window_width, window_height, "oblig3");
        SetTargetFPS(60);
        font = LoadFontEx("PxPlusToshibaSat8x16.ttf", 16, (int[])null, 250);
        avdelinger = Avdeling.hentAlle();
        ansatte = new ArrayList<>();
        for (Avdeling avdeling : avdelinger) {
            ansatte.add(avdeling.hentAnsatte());
        }
        max_sel_avd = avdelinger.size();
        max_sel_ans = ansatte.get(sel_avd).size();
    }

    private static void run() {
        String txt_ansatte = " [ ANSATTE ] ";
        String txt_prosjekter = " [ PROSJEKTER ] ";
        int txt_ansatte_w = (int)MeasureTextEx(font, txt_ansatte, font_size, font_spacing).x();
        int txt_prosjekter_w = (int)MeasureTextEx(font, txt_prosjekter, font_size, font_spacing).x();

        String txt_bunn_none = "F1: LEGG TIL ANSATT  //  F2: LEGG TIL AVDELING  //  F3: FILTRER RESULTAT  //  ESC: AVSLUTT PROGRAM";
        int txt_bunn_none_w = (int)MeasureTextEx(font, txt_bunn_none, font_size, font_spacing).x();
        String txt_bunn_legg_til = "ENTER: OK  //  ESC: AVBRYT";
        int txt_bunn_legg_til_w = (int)MeasureTextEx(font, txt_bunn_legg_til, font_size, font_spacing).x();

        // Hovedløkke
        int line;
        int float_line;
        String txt_bunn = txt_bunn_none;
        int txt_bunn_w = txt_bunn_none_w;
        while (!WindowShouldClose()) {
            line = 0;
            
            // Oppdater farge
            col.r((byte)(((Math.sin((double)System.currentTimeMillis() / 1500d) + 1d) * 50d) ));
            col.g((byte)(((Math.sin((double)System.currentTimeMillis() / 2000d) + 1d) * 50d) ));
            col.b((byte)(((Math.sin((double)System.currentTimeMillis() / 3500d) + 1d) * 50d) ));
            
            // Start grafikktegning
            BeginDrawing();
            ClearBackground(col);
            
            // Topptekst
            DrawTextEx(font, "HØGSKULEN PÅ VESTLANDET", new Vector2().x(margin_l).y(margin_top+line*font_size), font_size, font_spacing, col_fg); line++;

            // Tab seleksjon
            switch (sel_tab) {
                case 0:
                    DrawRectangle(margin_l, margin_top+line*font_size, txt_ansatte_w, font_size, col_fg);
                    break;
                case 1:
                    DrawRectangle(margin_l+txt_ansatte_w, margin_top+line*font_size, txt_prosjekter_w, font_size, col_fg);
            }
            DrawTextEx(font, txt_ansatte, new Vector2().x(margin_l).y(margin_top+line*font_size), font_size, font_spacing, sel_tab == 0 ? col_bg : col_fg);
            DrawTextEx(font, txt_prosjekter, new Vector2().x(margin_l+txt_ansatte_w).y(margin_top+line*font_size), font_size, font_spacing, sel_tab == 1 ? col_bg : col_fg);
            line++;

            // Horisontal linje
            DrawLine(0,margin_top+line*font_size+(int)(font_size*0.5),window_width, margin_top+line*font_size+(int)(font_size*0.5),col_fg);line++;
            
            // Hovedinnhold
            switch (sel_tab) {
                // Ansatte
                case 0:
                    for (int i = 0; i < avdelinger.size(); i++) {
                        // Seleksjonsindikator
                        if (window == Window.NONE && sel_avd == i) {
                            DrawTextEx(font, ">", new Vector2().x(margin_l).y(margin_top+(line+sel_ans)*font_size), font_size, font_spacing, col_fg);
                        }
                        // Avdelingstittel
                        DrawTextEx(font, avdelinger.get(i).navn() + " (" + ansatte.get(i).size() + " ansatte)", new Vector2().x(margin_l+indent_width).y(margin_top+line*font_size), font_size, font_spacing, col_fg);line++;
                        // Liste av ansatte
                        if (ansatte.get(i).size() == 0) {
                            DrawTextEx(font, "Ingen ansatte", new Vector2().x(margin_l+indent_width*2).y(margin_top+line*font_size), font_size, font_spacing, col_fg);line++;
                        } else {
                            DrawLine(margin_l+(int)(indent_width*1.5), margin_top+line*font_size+2, margin_l+(int)(indent_width*1.5), margin_top+(line+ansatte.get(i).size())*font_size-2, col_fg);
                            for (int j = 0; j < ansatte.get(i).size(); j++) {
                                Ansatt ansatt = ansatte.get(i).get(j);
                                DrawTextEx(font, (j == 0 ? "(sjef) " : "") + ansatt.fornavn() + " " + ansatt.etternavn() + ", " + ansatt.stilling(), new Vector2().x(margin_l+indent_width*2).y(margin_top+line*font_size), font_size, font_spacing, col_fg);line++;
                            }
                        }
                        line++;
                    }
                    break;
                // Prosjekter
                case 1:
                    DrawTextEx(font, "Ingen prosjekter", new Vector2().x(margin_l+indent_width).y(margin_top+line*font_size), font_size, font_spacing, col_fg);line++;
                    break;
            }

            // Bunntekst
            DrawLine(0,window_height-font_size*2,window_width, window_height-font_size*2,col_fg);
            DrawTextEx(font, txt_bunn, new Vector2().x((window_width-txt_bunn_w)/2).y(window_height-(int)(font_size*1.5)), font_size, font_spacing, col_fg);

            if (window != Window.NONE) {
                float_line = 1;
                switch (window) {
                    case Window.REDIGER_ANSATT:
                        DrawRectangle(margin_float_x+8, margin_float_y+8, window_width-margin_float_x*2, window_height-margin_float_y*2, col_bg);
                        DrawRectangle(margin_float_x, margin_float_y, window_width-margin_float_x*2, window_height-margin_float_y*2, col_fg);
                        DrawTextEx(font, "REDIGER ANSATT", new Vector2().x(margin_float_x+margin_l).y(margin_float_y+float_line*font_size), font_size, font_spacing, col); float_line++;
                        break;
                    case Window.LEGG_TIL_ANSATT:
                        DrawRectangle(margin_float_x+8, margin_float_y+8, window_width-margin_float_x*2, window_height-margin_float_y*2, col_bg);
                        DrawRectangle(margin_float_x, margin_float_y, window_width-margin_float_x*2, window_height-margin_float_y*2, col_fg);
                        DrawTextEx(font, "FLOATING WINDOW", new Vector2().x(margin_float_x+margin_l).y(margin_float_y+float_line*font_size), font_size, font_spacing, col); float_line++;
                        break;
                }
            }

            // FPS
            DrawFPS(window_width-32, 2);

            // Avslutt grafikktegning
            EndDrawing();

            // Les innputt fra tastatur 
            switch (window) {
                case Window.NONE:
                    if (IsKeyPressed(KEY_F1)) {
                        SetExitKey(KEY_NULL);
                        window = Window.LEGG_TIL_ANSATT;
                    }
                    if (IsKeyPressed(KEY_LEFT) && sel_tab > 0) {
                        sel_tab--;
                        sel_avd = 0;
                        sel_ans = 0;
                    }
                    else if (IsKeyPressed(KEY_RIGHT) && sel_tab < 1) {
                        sel_tab++;
                        sel_avd = 0;
                        sel_ans = 0;
                    }

                    else if (IsKeyPressed(KEY_UP) && (sel_avd > 0 || sel_ans > 0)) {
                        sel_ans--;
                        if (sel_ans < 0) {
                            sel_avd--;
                            max_sel_ans = ansatte.get(sel_avd).size();
                            sel_ans = max_sel_ans;
                        }
                    }
                    else if (IsKeyPressed(KEY_DOWN) && (sel_avd < max_sel_avd-1 || sel_ans < max_sel_ans)) {
                        sel_ans++;
                        if (sel_ans > max_sel_ans) {
                            sel_avd++;
                            sel_ans = 0;
                            max_sel_ans = ansatte.get(sel_avd).size();
                        }
                    }
                    break;
                case Window.LEGG_TIL_ANSATT:
                    if (IsKeyPressed(KEY_ESCAPE)) {
                        SetExitKey(KEY_ESCAPE);
                        window = Window.NONE;
                    }
                    break;
            }
        }
    }

    private static void exit() {
        CloseWindow();
    }

    public static void main(String[] args) {
        init();
        run();
        exit();
    }
}
            /*
            switch (sel) {
                case 0:
                    fig0(window_width, window_height, 20, 200, LIGHTGRAY);
                    break;
                case 1:
                    fig1((window_width - 400) / 2, (window_height - 400) / 2, 4, 400, LIGHTGRAY);
                    break;
                case 2:
                    fig2((window_width - 400) / 2, (window_height - 400) / 2, 4, 400, LIGHTGRAY);
                    break;
            }
            */
