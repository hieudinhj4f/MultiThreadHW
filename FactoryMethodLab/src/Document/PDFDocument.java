package Document;

public class PDFDocument implements Document{
    private String name;

    public PDFDocument(String name){
        this.name = name;
    }
    @Override
    public void generate(){
        System.out.println("Generating a PDF Document");
    }
}
