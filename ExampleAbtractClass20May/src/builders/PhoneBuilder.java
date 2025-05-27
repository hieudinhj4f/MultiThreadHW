package builders;

public interface PhoneBuilder {
    void reset();
    public void buildChip();
    public void buildScreen();
    public void buildCase();
    public void buildFrame();

    public Phone getPhone();
}

