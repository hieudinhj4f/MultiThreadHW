package Factory;

import Document.Document;
import Document.PDFDocument;

public class PDFDocumentFactory extends DocumentFactory {
    public Document createDocument(String name) {
        return new PDFDocument(name);
    }
}
