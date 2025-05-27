package builders;

public class IPhone11 implements PhoneBuilder{

    @Override
    public void reset() {
        return new Iphone11();
    }

    public Iphone11(){

    }
    @Override
    public void buildChip() {
        `
    }

    @Override
    public void buildScreen() {

    }

    @Override
    public void buildCase() {

    }

    @Override
    public void buildFrame() {

    }

    @Override
    public Phone getPhone() {
        return null;
    }
}
