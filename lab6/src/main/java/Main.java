import java.io.*;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

     public static void main(String argv []) throws IOException, ClassNotFoundException {
        boolean isStopped = false;
        ServerSocket echoServer = new ServerSocket(2323);

        while (!isStopped) {

            try {
                System.out.println("Waiting for clients ...");
                Socket client = echoServer.accept();
                System.out.println("User connected");
                ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
                outputStream.writeObject("Hello from server");
                outputStream.flush();

                ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
                System.out.println("Meesage from client " + (String) inputStream.readObject());
//                new Thread(new Worker(client, new YepServer())).start();

            } catch (IOException e) {

                System.out.println(e.getMessage());

            }

        }
    }
}
