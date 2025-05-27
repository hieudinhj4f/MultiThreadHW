public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    public void make(String type) {
        builder.reset();
        if (type.equals("simple")) {
            builder.buildStepA();
        } else {
            builder.buildStepB();
            builder.buildStepZ();
        }
    }
}
