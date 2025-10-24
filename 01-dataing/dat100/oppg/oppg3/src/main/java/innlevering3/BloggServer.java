package innlevering3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BloggServer {

    // Objektvariabler
    private ServerSocket welcomeSocket;

    // Konstruktør
    public BloggServer(ServerSocket welcomeSocket) {
        this.welcomeSocket = welcomeSocket;
    }

    // Kjør server
    public void process(HtmlBlogg htmlBlogg) {
        try {
            System.out.println("SERVER ACCEPTING");
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            String text = inFromClient.readLine();
            System.out.println("SERVER RECEIVED: " + text);
            String htmlbody = htmlBlogg.toString();
            String header = "HTTP/1.1 200 OK\n" + "Server: DAT100 HTTP Server : 1.0\n" + "Date: " + (new Date()) + "\n"
                    + "Content-type: " + "text/html" + "\n" + "Content-length: " + htmlbody.length() + "\n" + "\n";
            String outtext = header + htmlbody;
            System.out.println("SERVER SENDING: " + outtext);
            outToClient.write(outtext.getBytes());
            outToClient.flush();
            outToClient.close();
            inFromClient.close();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            connectionSocket.close();

        } catch (IOException ex) {
            System.out.println("TCPServer: " + ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
