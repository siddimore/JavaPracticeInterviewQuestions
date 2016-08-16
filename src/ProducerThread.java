import java.util.List;
import java.util.concurrent.RunnableFuture;

/**
 * Created by MoreFamily on 4/15/2016.
 */
public class ProducerThread implements Runnable {

    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public ProducerThread(List<Integer> sharedQ, int size){
        this.taskQueue = sharedQ;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run() {

        int counter = 0;

        while(true){
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void produce(int i) throws InterruptedException{
        synchronized (taskQueue){
            while(taskQueue.size() == MAX_CAPACITY){
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
        }
    }
}
