package Factory;

import Document.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument(String name);
    public void produceDocument(String name){
        Document doc = createDocument(name);
        doc.generate();
    };
}
