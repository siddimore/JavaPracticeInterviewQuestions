import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by MoreFamily on 4/10/2016.
 */
public class MyTopic implements Subject{
    private List<MyObserver> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic(){
        this.observers = new ArrayList<>();
    }

    public void unregister(MyObserver obj){
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }
    public void register(MyObserver obj){
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }
    public Object getUpdate(MyObserver obj){
        return this.message;
    }
    public void notifyObservers(){
        List<MyObserver> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (MyObserver obj : observersLocal) {
            obj.update();
        }

    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}
