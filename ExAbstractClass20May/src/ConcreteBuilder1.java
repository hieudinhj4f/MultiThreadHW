public class ConcreteBuilder1 implements Builder {
    private Product1 result;

    @Override
    public void reset() {
        result = new Product1();
    }

    @Override
    public void buildStepA() {
        result.setFeatureA();
    }

    @Override
    public void buildStepB() {
        result.setFeatureB();
    }

    @Override
    public void buildStepZ() {
        result.setFeatureZ();
    }

    public Product1 getResult() {
        return result;
    }
}
