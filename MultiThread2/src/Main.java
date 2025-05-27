import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Hàng đợi dùng LinkedList, kích thước tối đa là 5
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final int CAPACITY = 5;

    // Lớp Producer implement Runnable
    static class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (queue) {
                    try {
                        // Chờ nếu hàng đợi đầy
                        while (queue.size() == CAPACITY) {
                            System.out.println("Hàng đợi đầy, Producer chờ...");
                            queue.wait();
                        }
                        // Thêm phần tử vào hàng đợi
                        Random random = new Random();
                        queue.offer(random.nextInt(100));
                        System.out.println("Producer sản xuất: " + value + " (Kích thước hàng đợi: " + queue.size() + ")");
                        value++;
                        // Thông báo cho Consumer
                        queue.notify();
                        // Giả lập thời gian sản xuất
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Lớp Consumer implement Runnable
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        // Chờ nếu hàng đợi rỗng
                        while (queue.isEmpty()) {
                            System.out.println("Hàng đợi rỗng, Consumer chờ...");
                            queue.wait();
                        }
                        // Lấy phần tử từ hàng đợi
                        int value = queue.poll();
                        System.out.println("Consumer tiêu thụ: " + value + " (Kích thước hàng đợi: " + queue.size() + ")");
                        // Thông báo cho Producer
                        queue.notify();
                        // Giả lập thời gian tiêu thụ
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Phương thức main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so luong sinh du lieu: ");
        int luongsinhdulieu = sc.nextInt();
        System.out.println("Moi ban nhan so luong su dung du lieu");

        // Tạo và khởi động luồng Producer
        Thread producerThread = new Thread(new Producer(), "Producer-Thread");
        // Tạo và khởi động luồng Consumer
        Thread consumerThread = new Thread(new Consumer(), "Consumer-Thread");
        producerThread.start();
        consumerThread.start();
    }
}