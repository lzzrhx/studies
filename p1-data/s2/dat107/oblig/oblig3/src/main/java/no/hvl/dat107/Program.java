package no.hvl.dat107;

import static com.raylib.Raylib.*;

public class Program {

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

    // DAO-variabler
    private static AnsattDAO ansattDAO = new AnsattDAO();
    private static AvdelingDAO avdelingDAO = new AvdelingDAO();

    // Klassevariabler
    private static Color color = new Color().a((byte)0xff);
    private static Font font;
    private static Window window = Window.NONE;

    public static void main(String[] args) {
        init();
        run();
        exit();
    }

    // Initialisering av programmet
    private static void init() {
        SetTraceLogLevel(4);
        InitWindow(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT, "oblig3");
        SetTargetFPS(60);
        font = LoadFontEx("./assets/PxPlusToshibaSat8x16.ttf", 16, (int[])null, 250);
        View.init(font);
        View.updateAnsatteGroups(avdelingDAO, ansattDAO);
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
        ansattDAO.exit();
        avdelingDAO.exit();
    }

    static void changeWindow(Window window) {
        Program.window = window;
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
                //openEditWindow();
            } else if (IsKeyPressed(KEY_LEFT)) {
                View.decView();
            } else if (IsKeyPressed(KEY_RIGHT)) {
                View.incView();
            } else if (IsKeyPressed(KEY_UP)) {
                View.decSel();
            } else if (IsKeyPressed(KEY_DOWN)) {
                View.incSel();
            }
        }
    }

    // Gjennomfør oppdateringer (per-frame)
    private static void update() {
        color.r((byte)(((Math.sin((double)System.currentTimeMillis() / 1500d) + 1d) * 50d) ));
        color.g((byte)(((Math.sin((double)System.currentTimeMillis() / 2000d) + 1d) * 50d) ));
        color.b((byte)(((Math.sin((double)System.currentTimeMillis() / 3500d) + 1d) * 50d) ));
    }

    // Tegn grafikk
    private static void draw() {
        BeginDrawing();
        ClearBackground(color);
        View.draw(font);
        DrawFPS(Const.WINDOW_WIDTH -32, 2);
        EndDrawing();
    }
}
