import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static public void main(String argv []) throws IOException {
        System.out.println("Hello World");

        boolean isStopped = false;
        ServerSocket echoServer = new ServerSocket(2323);

        while (!isStopped) {

            try {
                Socket client = echoServer.accept();
                new Thread(new Worker(client, new YepServer())).start();

            } catch (IOException e) {

                System.out.println(e.getMessage());

            }

        }
    }
}
