
public class Main {
    public static void main(String[] args) {
        Logistic roadLogistic = new RoadLogistic();
        roadLogistic.planDelivery();

        Logistic sealogistic = new SeaLogistic();
        sealogistic.planDelivery();
    }
}