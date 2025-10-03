public class Kvadrat {
    int sidelengde;

    Kvadrat(int sidelengde) {
        this.sidelengde = sidelengde;
    }

    private int areal() {
        return sidelengde * sidelengde;
    }

    private int omkrets() {
        return sidelengde * 4;
    }

    public boolean sum(Kvadrat a, Kvadrat b) {
        if (a.areal() + b.areal() == this.areal()) {
            return true;
        }
        return false;
    }

    public String toString(){
        return "sidelengde: " + sidelengde + "\n" + "areal: " + areal() + "\n" + "omkrets: " + omkrets();
    }

    public void tegn() {
        for (int i = 0; i < sidelengde; i++) {
            System.out.println("*".repeat(sidelengde));
        }
    }
}
