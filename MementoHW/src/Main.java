import java.util.ArrayList;
import java.util.List;


class Memento {
    private final String state;
    public Memento(String stateToSave) {
        state = stateToSave;
    }
    public String getSavedState() {
        return state;
    }
}

class Originator {
    private String state;
    public void set(String state) {
        this.state = state;
        System.out.println("Set state to: " + state);
    }
    public Memento saveToMemento() {
        System.out.println("Saving to Memento.");
        return new Memento(state);
    }
    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
        System.out.println("Restored state to: " + state);
    }
}


public class Main{
    public static void main(String[] args) {
        List<Memento> savedStates = new ArrayList<>();
        Originator originator = new Originator();

        originator.set("State #1");
        savedStates.add(originator.saveToMemento());

        originator.set("State #2");
        savedStates.add(originator.saveToMemento());

        originator.set("State #3");

        originator.restoreFromMemento(savedStates.get(1));
        originator.restoreFromMemento(savedStates.get(0));
    }
}
