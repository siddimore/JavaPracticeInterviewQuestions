import java.util.List;

/**
 * Created by MoreFamily on 4/15/2016.
 */
public class ConsumerThread implements Runnable {

    private final List<Integer> taskQ;

    public ConsumerThread(List<Integer> sharedQ){
        this.taskQ = sharedQ;
    }

    public void run(){
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume()throws InterruptedException{

        synchronized (taskQ){
            while(taskQ.isEmpty()){
                    try {
                        System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQ.size());
                        taskQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            Thread.sleep(1000);
            int i= taskQ.remove(0);
            System.out.println("Consumed: " + i);
            taskQ.notifyAll();
        }
    }


}
