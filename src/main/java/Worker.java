import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker implements Runnable {

    Socket client = null;
    YepServer yepServer;

    public Worker(Socket client, YepServer yepServer) {
        this.client = client;
        this.yepServer = yepServer;
    }

    public void run() {

        try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Message received: " + inputLine);
                String echo = yepServer.processInput(inputLine);
                out.println(echo);
                System.out.println("Echo sent: " + echo);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
