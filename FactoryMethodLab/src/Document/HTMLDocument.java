package Document;

public class HTMLDocument implements Document {
    private String name;

    public HTMLDocument(String name) {
        this.name = name;
    }
    @Override
    public void generate(){
        this.name = name;
        System.out.println("HTML Document: "+name);
    }
}
