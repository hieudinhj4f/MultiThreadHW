package MPI;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class MPI {
    public static int result(String sentence_from_client) {
        int sum = 0;
        sentence_from_client = sentence_from_client.replace("[", "").replace("]", "");
        String[] numbers = sentence_from_client.split(",");
        for (String numStr : numbers) {
            sum += Integer.parseInt(numStr.trim());
        }
        return sum;
    }

    public static void main(String[] argv) throws Exception {
        String sentence_from_client;
        String sentence_to_client;

        ServerSocket welcomeSocket = new ServerSocket(6543);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            sentence_from_client = inFromClient.readLine();

            sentence_to_client = sentence_from_client + " → Tổng: " + result(sentence_from_client) + "\n";

            outToClient.writeBytes(sentence_to_client);

            System.out.println("Client gửi: " + sentence_from_client);
            System.out.println("Đã trả về: " + sentence_to_client);
        }
    }
}
