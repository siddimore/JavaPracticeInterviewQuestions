import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MoreFamily on 4/3/2016.
 */
public class ClassATM {
    private static java.util.concurrent.locks.Lock lock;
    private static int balance = 100;

    public ClassATM()
    {
        lock = new ReentrantLock();
    }

    public  int withdraw(int value)
    {
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
            System.out.println("Balance is: " + balance);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        lock.unlock();
        return balance;
    }

    public  int deposit(int value)
    {
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(100);
            balance = temp;
            System.out.println("Balance is: " + balance);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        lock.unlock();
        return balance;
    }

    public static void main(String[] args)
    {
        ClassATM atm = new ClassATM();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; ++i){
                    atm.deposit(1000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; ++i){
                    atm.withdraw(1000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
