
import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] argv) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;
        final int capacity = 100;
        final int[] arr = new int[capacity];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(100);

        }

        //Tạo Inputstream(từ bàn phím)
        System.out.print("Input from client: ");
//        BufferedReader inFromUser =
//                new BufferedReader(new InputStreamReader(System.in));
        //Lấy chuỗi ký tự nhập từ bàn phím
        sentence_to_server = Arrays.toString(arr);
//    
        //Tạo socket cho client kết nối đến server qua ID address và port number
        Socket clientSocket = new Socket("127.0.0.1", 6543);

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