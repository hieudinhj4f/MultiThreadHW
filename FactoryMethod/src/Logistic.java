
public abstract class Logistic {
    public abstract Transport createTransport();

    public void planDelivery(){
        Transport t = createTransport();
        t.deliver();
    };

}
