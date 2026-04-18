package no.hvl.dat107;

public class Line {
    String content;
    int indent;
    Line(String content) {
        this(content, 0);
    }
    Line(String content, int indent){
        this.content = content;
        this.indent = indent;
    }
}
