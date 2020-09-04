package company.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {

        // localhost is an alias for the ip 127.0.0.1 which points to your computer
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String echoString;
            String response;

            do { // do while because we want to ensure the loop runs at least once
                System.out.println("Enter string to be echoed: ");
                echoString = sc.nextLine();

                stringToEcho.println(echoString);

                if (!echoString.equalsIgnoreCase("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
             } while (!echoString.equalsIgnoreCase("exit"));


        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
