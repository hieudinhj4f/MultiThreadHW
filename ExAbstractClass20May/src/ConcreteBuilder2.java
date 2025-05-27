public class ConcreteBuilder2 implements Builder {
    private Product2 result;

    @Override
    public void reset() {
        result = new Product2();
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

    public Product2 getResult() {
        return result;
    }
}
