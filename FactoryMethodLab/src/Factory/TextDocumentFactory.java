package Factory;

import Document.Document;
import Document.TextDocument;

public class TextDocumentFactory extends DocumentFactory{
    public Document createDocument(String name) {
        return new TextDocument(name);
    }
}
