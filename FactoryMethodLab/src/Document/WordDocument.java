package Document;

public class WordDocument implements Document{
    private String name;

    public WordDocument(String name) {
        this.name = name;
    }
    @Override
    public void generate(){
        System.out.println("Generating a Word Document");
    }
}
