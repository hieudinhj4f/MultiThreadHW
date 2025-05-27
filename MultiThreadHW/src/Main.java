import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class Element {
        private int[] data;

        public Element(int size) {
            data = new int[size];
            generateRandomData();
        }

        public void generateRandomData() {
            Random rand = new Random();
            for (int i = 0; i < data.length; i++) {
                data[i] = rand.nextInt(100);
            }
            data[data.length - 1] = 1000;
        }

        public int get(int i) {
            return data[i];
        }

        public void set(int index, int value) {
            data[index] = value;
        }

        public void printData() {
            System.out.println(Arrays.toString(data));
        }
    }

    public static class ConfigQueue extends Thread {
        private final Element element;
        private final int StartIndex;
        private final int EndIndex;
        private int LocalMax = 0;

        public ConfigQueue(Element e, int StartIndex, int EndIndex) {
            this.element = e;
            this.StartIndex = StartIndex;
            this.EndIndex = EndIndex;
        }

        public int getLocalMax() {
            return LocalMax;
        }

        public void run() {
            long startTime = System.nanoTime();

            for (int i = StartIndex; i < EndIndex; i++) {
                if (LocalMax < element.get(i)) {
                    LocalMax = element.get(i);
                }
            }

            long endTime = System.nanoTime();
            double result = (endTime - startTime) / 1_000_000.0;

            System.out.println(Thread.currentThread().getName() +
                    " Max Value: " + LocalMax +
                    " | Time Taken: " + result + " ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int dataSize, K;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu: ");
        dataSize = sc.nextInt();
        System.out.println("Nhap GAP: ");
        K = sc.nextInt();
        ConfigQueue[] threads = new ConfigQueue[K];

        Element e = new Element(dataSize);

        System.out.println("== Mang du lieu ==");
        e.printData();




        int Gap = dataSize / K;
        for (int i = 0; i < K; i++) {
            int start = i * Gap;
            int end = (i == K - 1) ? dataSize : start + Gap;
            threads[i] = new ConfigQueue(e, start, end);
            threads[i].start();
        }

        for (int i = 0; i < K; i++) {
            threads[i].join();
        }

        int finalMax = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            if (threads[i].getLocalMax() > finalMax) {
                finalMax = threads[i].getLocalMax();
            }
        }
        System.out.println("==> Max: " + finalMax);
    }
}
