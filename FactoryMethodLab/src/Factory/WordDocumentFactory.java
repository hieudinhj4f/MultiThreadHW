package Factory;

import Document.Document;
import Document.WordDocument;
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
}
