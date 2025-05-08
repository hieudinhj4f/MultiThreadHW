import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Main {
    /* Dinh nghia cau truc */
    public static class Element {

        private int[] data;

        public Element(int size) {
            data = new int[size];
            generateRandomData();
        }

        public void generateRandomData() {
            Random rand = new Random();
            for (int i = 0; i < data.length; i++) {
                data[i] = rand.nextInt(1000);
            }
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
        public int getLocalMax(){
            return LocalMax;
        }

        public void run() {
            for (int i = StartIndex; i < EndIndex; i++) {
                if (LocalMax< element.get(i)) {
                    LocalMax = element.get(i);
                }
            }
            LocalDateTime now = LocalDateTime.now();
            System.out.println(Thread.currentThread().getName() + " Max Value : " + LocalMax + " Time find out : " + now);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int dataSize = 10;
        int K = 4;
        ConfigQueue[] threads = new ConfigQueue[K];

        Element e = new Element(dataSize);

        System.out.println("== Mang du lieu ==");
        e.printData();

//        for (int i = 0; i < K; i++) {
//            threads[i] = new ConfigQueue(e, 0, dataSize);
//            threads[i].start();
//        }


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
        System.out.println("Max : "+ finalMax);
    }
}
