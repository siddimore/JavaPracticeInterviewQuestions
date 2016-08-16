/**
 * Created by MoreFamily on 4/10/2016.
 */
public interface Subject {

    public void register(MyObserver obj);
    public void unregister(MyObserver obj);
    public void notifyObservers();
    public Object getUpdate(MyObserver obj);
}
