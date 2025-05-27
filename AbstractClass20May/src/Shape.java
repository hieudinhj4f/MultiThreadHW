public abstract class Shape {
    private int x;
    private int y;
    public String color;

    public Shape(){}

    public Shape(Shape source){
        if( source != null){
            this.x = source.x;
            this.y = source.y;
            this.color = source.color;
        }
    }

    public abstract Shape clone();
}
