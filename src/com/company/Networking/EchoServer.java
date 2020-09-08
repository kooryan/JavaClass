package company.Networking;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    public static void main(String[] args) {

        // can be a number between [0, 65535] but some numbers may be reserved
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
              new Echoer(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
