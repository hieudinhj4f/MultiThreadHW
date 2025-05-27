public abstract class DocumentFactory {
    public abstract Document createDocument();

    public void produceDocument(){
        createDocument();
    }
}
