import Factory.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Checking Program");
        String name = "Testing.file";
        DocumentFactory pdf = new PDFDocumentFactory();
        pdf.produceDocument(name);
        DocumentFactory word = new WordDocumentFactory();
        word.produceDocument(name);
        DocumentFactory text = new TextDocumentFactory();
        text.produceDocument(name);
        DocumentFactory html = new HTMLDocumentFactory();
        html.produceDocument(name);

    }
}