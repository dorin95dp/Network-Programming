import java.io.*;
import java.net.Socket;

/**
 * Created by User on 29.05.2017.
 */
public class Client {

    public static void main(String args[]) throws ClassNotFoundException {

            try {
                Socket socket = new Socket("localhost", 2323);
                System.out.println("Connected");
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String s = (String)inputStream.readObject();
                ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
                writer.writeObject("Hello from Client !" + Math.random());
                System.out.println("Message from server " + s);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (true);
    }
}
