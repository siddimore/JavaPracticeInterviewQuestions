/**
 * Created by MoreFamily on 4/11/2016.
 */
public class PandC {


    public static void main(String[] args){
        Market m = new Market();
        Producer p = new Producer(m);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.keepPutting();
            }
        });

        Consumer c = new Consumer(m);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.keepGetting();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }


}
