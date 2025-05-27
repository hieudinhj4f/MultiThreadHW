import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static class ConfigThread extends Thread {
        public static class Consumer{
            private static LinkedList<Integer> queue = new LinkedList<>();
            static Semaphore semaphore = new Semaphore(1);

        }
        public class Producer extends Thread{
            private final String name;


            public Producer(String name) {
                this.name = name;
            }
            @Override
            public void run(){
                while(true){
                    Random rand = new Random();
                    int value = rand.nextInt(100);
                    Thread.sleep(rand.nextInt(1000));

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so luong du lieu ");
        int soluongdulieu = sc.nextInt();
        System.out.println("Moi ban nhap so luong ");
        int soluongtieuthu = sc.nextInt();

        for( int i = 0; i < soluongdulieu; i++ ){
            ConfigThread ct = new ConfigThread();

        }

        for ( int i = 0; i < soluongtieuthu; i++ ){

        }
    }
}