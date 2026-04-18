package no.hvl.dat107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.raylib.Raylib.*;

public class View {
    enum Type {
        ANSATTE,
        PROSJEKTER
    }

    private static Type selView;
    private static View[] tabs;
    private static String headerTxtAll;
    private static int headerTxtWidthAll = 0;
    private static int selGrp;
    private static int selAns;
    private static String footerText;

    private String headerTxt;
    private int headerTxtWidth;
    private int headerTxtOffset;
    private View.Type type;
    private List<AnsatteGroup> ansatteGroups = new ArrayList<>();
    private Line[] lines;

    public static void init(Font font) {
        setView(0);
        footerText(Const.TXT_FOOTER_NONE);
        tabs = new View[Type.values().length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tabs.length; i++) {
            tabs[i] = new View(View.Type.values()[i], font);
            sb.append(tabs[i].headerTxt);
            headerTxtWidthAll += tabs[i].headerTxtWidth;
        }
        headerTxtAll = sb.toString();
    }

    View(Type type, Font font) {
        this.type = type;
        this.lines = new Line[Const.NUM_MAIN_LINES];
        this.headerTxt = " [ " + type + " ] ";
        this.headerTxtWidth = (int)MeasureTextEx(font, this.headerTxt, Const.FONT_HEIGHT, Const.FONT_SPACING).x();
        this.headerTxtOffset = View.headerTxtWidthAll;
    }

    public static void footerText(String footerText) { View.footerText = footerText; }

    public static View current() {
        return View.tabs[View.selView.ordinal()];
    }

    public static void decView() {
        View.setView(View.selView.ordinal()-1);
    }

    public static void incView() {
        View.setView(View.selView.ordinal()+1);
    }

    private static void setView(int n) {
        if (n >= 0 && n < Type.values().length) {
            selView = Type.values()[n];
            selGrp = 0;
            selAns = 0;
        }
    }

    public static void decSel() {
        if (selGrp > 0 || selAns > 0) {
            selAns -= 1;
            if (selAns < 0) {
                selGrp -= 1;
                selAns = current().ansatteGroups.get(selGrp).ansatte.size();
            }
        }
    }

    public static void incSel() {
        if (!current().ansatteGroups.isEmpty() && (selGrp < current().ansatteGroups.size()-1 || selAns < current().ansatteGroups.get(selGrp).ansatte.size())) {
            selAns += 1;
            if (selAns > current().ansatteGroups.get(selGrp).ansatte.size()) {
                selGrp += 1;
                selAns = 0;
            }
        }
    }

    public static void updateAnsatteGroups(AvdelingDAO avdelingDAO, AnsattDAO ansattDAO) {
        for (View tab : View.tabs) {
            tab.ansatteGroups.clear();
            Arrays.fill(tab.lines, null);
            int lineNo = 0;
            switch (tab.type) {
                case View.Type.ANSATTE:
                    List<Avdeling> avdelinger = avdelingDAO.hentAlle();
                    if (avdelinger.isEmpty()) {
                        tab.lines[lineNo] = new Line("Ingen avdelinger funnet.", 2);
                    } else {
                        for (Avdeling avdeling : avdelinger) {
                            List<Ansatt> ansatte = ansattDAO.hentAlleFraAvdeling(avdeling);
                            tab.ansatteGroups.add(new AnsatteGroup(avdeling, ansatte, lineNo));
                            if (lineNo < tab.lines.length) {
                                tab.lines[lineNo] = new Line(avdeling.navn() + " (" + ansatte.size() + " ansatte)", 2);
                            }
                            lineNo += 1;
                            if (ansatte.isEmpty()) {
                                tab.lines[lineNo] = new Line("Ingen ansatte funnet.", 4);
                            } else {
                                for (Ansatt ansatt : ansatte) {
                                    boolean sjef = ansatt.equals(avdeling.sjef());
                                    if (lineNo < tab.lines.length) {
                                        tab.lines[lineNo] = new Line((sjef ? "(sjef) " : "") + ansatt.fornavn() + " " + ansatt.etternavn() + ", " + ansatt.stilling(), 4);
                                    }
                                    lineNo += 1;
                                }
                            }
                            lineNo += 1;
                        }
                    }
                    break;
                case Type.PROSJEKTER:
                    tab.lines[lineNo] = new Line("Ingen prosjekter funnet.", 2);
                    break;
            }
        }
    }

    public static void draw(Font font) {
        drawAnsattGroups(font);
        drawHeader(font);
        drawFooter(font);
    }

    private static void drawAnsattGroups(Font font) {
        int tabY = (int) ((Const.NUM_MARGIN_LINES * 0.5 + 1) * Const.FONT_HEIGHT);
        drawTextLine(font, View.headerTxtAll, 0, 1);
        DrawRectangle(Const.INDENT * Const.FONT_WIDTH + View.current().headerTxtOffset, tabY, View.current().headerTxtWidth, Const.FONT_HEIGHT, Const.COL_FG);
        DrawTextEx(font, View.current().headerTxt, new Vector2().x(Const.INDENT * (Const.FONT_WIDTH + Const.FONT_SPACING) + View.current().headerTxtOffset).y(tabY), Const.FONT_HEIGHT, Const.FONT_SPACING, Const.COL_BG);
        if (!View.current().ansatteGroups.isEmpty()) {
            drawTextLine(font, ">",0, Const.NUM_HEADER_LINES + current().ansatteGroups.get(selGrp).lineNo + selAns);
        }
        for (int i = 0; i < current().lines.length; i++) {
            Line line = current().lines[i];
            if (line != null) {
                drawTextLine(font, line.content, line.indent, i+ Const.NUM_HEADER_LINES);
            }
        }
        for (AnsatteGroup group : current().ansatteGroups) {
            DrawLine((int)((Const.INDENT + 3) * Const.FONT_WIDTH), (int)((Const.NUM_HEADER_LINES + group.lineNo + 1 + Const.NUM_MARGIN_LINES * 0.5) * Const.FONT_HEIGHT) + 4, (int)((Const.INDENT + 3) * Const.FONT_WIDTH), (int)((Const.NUM_HEADER_LINES + group.lineNo + 1 + Const.NUM_MARGIN_LINES * 0.5 + (group.ansatte.isEmpty() ? 1 : group.ansatte.size())) * Const.FONT_HEIGHT) - 4, Const.COL_FG);
        }
    }

    private static void drawHeader(Font font) {
        drawTextLine(font, Const.TITLE, 0, 0);
        DrawLine(0, (int)((Const.NUM_HEADER_LINES + Const.NUM_MARGIN_LINES * 0.5 - 0.5) * Const.FONT_HEIGHT), Const.WINDOW_WIDTH, (int)((Const.NUM_HEADER_LINES + Const.NUM_MARGIN_LINES *0.5-0.5) * Const.FONT_HEIGHT), Const.COL_FG);
    }

    private static void drawFooter(Font font) {
        drawTextLineCentered(font, footerText, Const.NUM_LINES - Const.NUM_FOOTER_LINES - Const.NUM_MARGIN_LINES +1);
        DrawLine(0, (int)((Const.NUM_LINES - Const.NUM_MARGIN_LINES * 0.5 - Const.NUM_FOOTER_LINES + 0.5) * Const.FONT_HEIGHT), Const.WINDOW_WIDTH, (int)((Const.NUM_LINES - Const.NUM_MARGIN_LINES * 0.5 - Const.NUM_FOOTER_LINES +0.5) * Const.FONT_HEIGHT), Const.COL_FG);
    }

    private static void drawTextLine(Font font, String txt, int lineIndent, int lineNo) {
        DrawTextEx(font, txt, new Vector2().x((lineIndent + Const.INDENT) * (Const.FONT_WIDTH + Const.FONT_SPACING)).y(lineNo * Const.FONT_HEIGHT +(int)(Const.NUM_MARGIN_LINES * 0.5 * Const.FONT_HEIGHT)), Const.FONT_HEIGHT, Const.FONT_SPACING, Const.COL_FG);
    }

    private static void drawTextLineCentered(Font font, String txt, int lineNo) {
        DrawTextEx(font, txt, new Vector2().x((Const.WINDOW_WIDTH -(int)MeasureTextEx(font, txt, Const.FONT_HEIGHT, Const.FONT_SPACING).x()) / 2).y(lineNo * Const.FONT_HEIGHT + (int)(Const.NUM_MARGIN_LINES * 0.5 * Const.FONT_HEIGHT)), Const.FONT_HEIGHT, Const.FONT_SPACING, Const.COL_FG);
    }
}