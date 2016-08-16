import sun.management.jmxremote.SingleEntryRegistry;

/**
 * Created by MoreFamily on 5/16/2016.
 */
public class SingletonDemo {

    static SingletonDemo obj;
    private SingletonDemo()
    {
        System.out.println("Creating first instance of Object");
    }

    public static SingletonDemo getInstance(){
        if(obj != null)
            return obj;
        else
            obj = new SingletonDemo();
        return obj;
    }

    public static void main(String[] args){
        SingletonDemo obj = SingletonDemo.getInstance();
        SingletonDemo obj2 = SingletonDemo.getInstance();

        System.out.println( obj == obj2 ? true : false);
    }
}
