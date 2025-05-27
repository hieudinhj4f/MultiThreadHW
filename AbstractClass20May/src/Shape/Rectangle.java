package Shape;

public class Rectangle implements Shape{
    private int width;
    private int height;

    public void Rectangle(){

        this.width = width;
        this.height = height;
    }
    @Override
    public Shape Clone(){
        return new Rectangle();
    }
}
