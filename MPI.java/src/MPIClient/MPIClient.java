package MPIClient;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class MPIClient {
    public static void main(String[] argv) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;
        Random rand = new Random();
        final int Capacity = 100;
        int[] arr = new int[Capacity];
        for (int i = 0; i < Capacity; i++){
            arr[i] = rand.nextInt(100);
        }

        //Tạo Inputstream(từ bàn phím)
        System.out.print("Input from client: ");
//        BufferedReader inFromUser =
//                new BufferedReader(new InputStreamReader(System.in));
        //Lấy chuỗi ký tự nhập từ bàn phím
        sentence_to_server = Arrays.toString(arr);
//
        //Tạo socket cho client kết nối đến server qua ID address và port number
        Socket clientSocket = new Socket("127.20.10.2", 6543);

        //Tạo OutputStream nối với Socket
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        //Tạo inputStream nối với Socket
        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));
//
        //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
        outToServer.writeBytes(sentence_to_server + '\n');

        //Đọc tin từ Server thông qua InputSteam đã nối với socket
        sentence_from_server = inFromServer.readLine();

        //print kết qua ra màn hình
        System.out.println("FROM SERVER: " + sentence_from_server);

        //Đóng liên kết socket
        clientSocket.close();
    }
}