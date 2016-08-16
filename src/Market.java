/**
 * Created by MoreFamily on 4/11/2016.
 */
public class Market {
    int n;
    boolean valSet = false;

    public Market() {

    }

    synchronized int get() {
        if (!valSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Got: " + n);
        valSet = false;
        notify();
        return n;
    }


    synchronized void put(int n) {
        if (valSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.n = n;
        valSet = true;
        System.out.println("Put: " + n);
    }
}
