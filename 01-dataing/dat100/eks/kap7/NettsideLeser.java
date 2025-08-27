package kap7;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NettsideLeser {
    public static void main(String[] args) throws Exception {
        URL url = new URL(args[0]);
        URLConnection connection = url.openConnection();
        InputStream inn = connection.getInputStream();
        Scanner leser = new Scanner(new InputStreamReader(inn));
        while (leser.hasNextLine()) {
            System.out.println(leser.nextLine());
        }
        inn.close();
    }
}
