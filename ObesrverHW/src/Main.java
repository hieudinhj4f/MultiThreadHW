import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private final String name;
    public ConcreteObserver(String name) {
        this.name = name;
    }
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

// Subject (Publisher)

class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String state;

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }

    public void setState(String newState) {
        this.state = newState;
        System.out.println("Subject changed state to: " + state);
        notifyObservers();
    }
}

// Main demo
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer obs1 = new ConcreteObserver("Observer 1");
        Observer obs2 = new ConcreteObserver("Observer 2");

        subject.attach(obs1);
        subject.attach(obs2);

        subject.setState("New State A");
        subject.setState("New State B");
    }
}
