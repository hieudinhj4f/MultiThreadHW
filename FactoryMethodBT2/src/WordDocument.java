import javax.print.Doc;

public class WordDocument implements Document{
    @Override
    public void generate(){
        System.out.println("Generating a WordDocument");
    }
}
