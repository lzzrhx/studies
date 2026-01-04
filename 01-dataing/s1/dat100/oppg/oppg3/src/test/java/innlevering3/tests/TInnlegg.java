package innlevering3.tests;
import innlevering3.*;

public class TInnlegg extends Innlegg {

    public TInnlegg(int id, String bruker, String dato) {
        super(id, bruker,dato);
    }

    public TInnlegg(int id, String bruker, String dato, int likes) {
        super(id, bruker,dato,likes);
    }

}
