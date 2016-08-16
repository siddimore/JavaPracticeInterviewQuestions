/**
 * Created by siddimore on 6/16/16.
 */
public class CalculatorThreadExample extends Thread{

    long sumToMillion =0;
    long sumToTenMillion =0;

    public void run(){

        synchronized (this){
            calculateSumToMillion();
            notify();
        }
        calculateSumToTenMillion();
    }

    private void calculateSumToMillion(){
        for(int i=0; i<100000; i++){
            sumToMillion +=i;
        }
        System.out.println("Million Done " + sumToMillion);
    }

    private void calculateSumToTenMillion(){
        for(int i=0; i<1000000; i++){
            sumToTenMillion +=i;
        }
        System.out.println("Ten Million Done " + sumToTenMillion);
    }

    public class ThreadWaitNotify {



    }

    public static void main(String[] args) throws InterruptedException{

        CalculatorThreadExample thread1 = new CalculatorThreadExample();
        synchronized(thread1) {
            try {
                thread1.start();
                thread1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread1.sumToMillion);
        }
    }
}
