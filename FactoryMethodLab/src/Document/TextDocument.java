package Document;

public class TextDocument implements Document{
    private String name;

    public TextDocument(String name) {
        this.name = name;
    }
    @Override
    public void generate(){
        System.out.println("Generating a Text Document");
    }
}
