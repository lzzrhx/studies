package no.hvl.dat107;

import java.util.ArrayList;
import java.util.List;

public class AnsatteGroup {
    Object parent;
    List<Ansatt> ansatte = new ArrayList<>();
    int lineNo;
    AnsatteGroup(Object parent, List<Ansatt> ansatte, int lineNo) {
        this.parent = parent;
        this.ansatte = ansatte;
        this.lineNo = lineNo;
    }
}
