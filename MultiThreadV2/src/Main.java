import com.sun.jdi.Value;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public class ConfigThread extends Thread {
        private static final int Capacity = 10;
        private static LinkedList<Integer> configQueue = new LinkedList<>();
        static Semaphore semaphore = new Semaphore(1);


        private static final Semaphore emptySlot = new Semaphore(Capacity);
        private static  final Semaphore fullSlot = new Semaphore(0);
        private static final Semaphore mutex =  new Semaphore(0);


        static class Producer implements Runnable{
            private final int id;
            private final Random rand = new Random();

            public Producer(int id) {
                this.id = id;
            }

            @Override
            public void run() {
                while(true){
                    int value = rand.nextInt(Capacity);

                    try{
                        Thread.sleep(rand.nextInt(2000) + 1000);
                        emptySlot.acquire();
                        mutex.acquire();
                        configQueue.offer(value);
                        System.out.println(value + " da duoc ghi vao thoi gian: " + System.currentTimeMillis());
                        mutex.release();
                        fullSlot.release();


                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        static class Consumer implements Runnable{
            private static int id;
            private final Random rand = new Random();


            public Consumer(int id) {
                this.id = id;
            }

            @Override
            public void run() {
                while(true){

                    try{
                        fullSlot.acquire();
                        mutex.acquire();
                        int value = configQueue.poll();
                        mutex.release();
                        emptySlot.release();
                        System.out.println(value + " da duoc lay vao thoi gian: " + System.currentTimeMillis());

                        Thread.sleep(rand.nextInt(3000) + 1000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng luồng sinh dữ liệu: ");
        int k = sc.nextInt();

        System.out.print("Nhập số lượng luồng xử lý dữ liệu: ");
        int h = sc.nextInt();

        for (int i = 1; i <= k; i++) {
            new Thread(new ConfigThread.Producer(i)).start();
        }

        for (int i = 1; i <= h; i++) {
            new Thread(new ConfigThread.Consumer(i)).start();
        }
    }
}