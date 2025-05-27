package Factory;

import Document.Document;
import Document.HTMLDocument;

public class HTMLDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument(String name) {
        return new HTMLDocument(name);
    }
}
