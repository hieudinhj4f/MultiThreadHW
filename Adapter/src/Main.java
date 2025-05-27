public class Main {
    public interface DepartmentClassifying {
        public String ClassifiedRoutine(String DepartmentAddress);
    }
    public static class HouseClassifying {
        public String HouseClassifiedRoutine(String DepartmentAddress) {
            return "House classified: " + DepartmentAddress;
        }
    }
    public static class Adapter implements DepartmentClassifying {
        private HouseClassifying hs;

        public Adapter(HouseClassifying hs) {
            this.hs = hs;
        }

        @Override
        public String ClassifiedRoutine(String DepartmentAddress) {
            return hs.HouseClassifiedRoutine(DepartmentAddress);
        }
    }

    public static void main(String[] args) {
        HouseClassifying house = new HouseClassifying();
        DepartmentClassifying adapter = new Adapter(house);
        String result = adapter.ClassifiedRoutine("123 Department Street");
        System.out.println(result); // Output: House classified: 123 Department Street
    }
}
