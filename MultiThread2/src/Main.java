import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int CAPACITY = 10; // N phần tử > 100, nhưng demo ta chọn 10 để dễ test
    private static final Queue<Integer> buffer = new LinkedList<>();

    // Luồng sinh dữ liệu (Producer)
    static class Producer implements Runnable {
        private final int id;
        private final Random rand = new Random();

        public Producer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                int value = rand.nextInt(1000); // Sinh giá trị ngẫu nhiên
                synchronized (buffer) {
                    while (buffer.size() == CAPACITY) {
                        try {
                            System.out.println("P" + id + ": Hàng đợi đầy, đang chờ...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.offer(value);
                    System.out.println("P" + id + ": " + value + " - " + System.currentTimeMillis());
                    buffer.notifyAll();
                }

                try {
                    Thread.sleep(rand.nextInt(2000) + 1000); // Nghỉ ngẫu nhiên 1-3s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Luồng xử lý dữ liệu (Consumer)
    static class Consumer implements Runnable {
        private final int id;
        private final Random rand = new Random();

        public Consumer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                int value;
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("C" + id + ": Hàng đợi rỗng, đang chờ...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    value = buffer.poll();
                    buffer.notifyAll();
                }

                // Mô phỏng xử lý dữ liệu
                String result = (value % 2 == 0) ? "Chẵn" : "Lẻ";
                System.out.println("C" + id + ": " + value + " - " + result + " - " + System.currentTimeMillis());

                try {
                    Thread.sleep(rand.nextInt(3000) + 1000); // Nghỉ ngẫu nhiên 1-4s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng luồng sinh dữ liệu (k ≥ 1): ");
        int k = sc.nextInt();

        System.out.print("Nhập số lượng luồng xử lý dữ liệu (h ≥ 1): ");
        int h = sc.nextInt();

        // Tạo và khởi động k Producer
        for (int i = 1; i <= k; i++) {
            new Thread(new Producer(i)).start();
        }

        // Tạo và khởi động h Consumer
        for (int i = 1; i <= h; i++) {
            new Thread(new Consumer(i)).start();
        }
    }
}
