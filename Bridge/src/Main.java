public class Main {
    public static void main(String[] args) {
        HouseDecorate full = new DecorateFully();
        HouseDecorate step = new DecorateStepByStep();

        HouseDetail house1 = new SimpleHouse(full);
        HouseDetail house2 = new LuxuryHouse(step);

        house1.construct();
        System.out.println("---------------");
        house2.construct();
    }
}