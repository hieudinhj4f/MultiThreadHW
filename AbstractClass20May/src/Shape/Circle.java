package Shape;

public class Circle implements Shape{
    private double radius;
    public Circle() {
        super();
        this.radius = radius;
    }
    @Override
    public Shape Clone(){
        return new Circle();
    }
}
