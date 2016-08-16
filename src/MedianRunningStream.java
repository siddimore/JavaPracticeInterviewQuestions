import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by siddimore on 6/4/16.
 */
public class MedianRunningStream {


    public static int getMedian(final int current, final int med, final PriorityQueue<Integer> left, final PriorityQueue<Integer> right){
        final int balance = left.size() - right.size();
        int median = med;


        if(balance == 0){
            if(current < median){
                left.offer(current);
                median = left.peek();
            }
            else{
                right.offer(current);
                median = right.peek();
            }
        }

        //if balance is greater than 0
        //Add to Right PQ or MaxHeap
        if(balance > 0){
            if(current < median){
                right.offer(left.poll());
                left.offer(current);
            }
            else{
                right.offer(current);
            }
        }

        //if balance is less than 0
        //Add to Left PQ or MinHeap
        if(balance < 0){
            if(current < median){
                left.offer(current);
            }
            else{
                left.offer(right.poll());
                right.offer(current);
            }
        }

        if(left.size()!=0 && right.size()!=0)
        median = (left.peek() + right.peek()) / 2;
        else if(left.size() != 0)
            median = left.peek();
        else median = right.peek();

        return median;
    }

    public static int getStreamMedian(final int[] streamArray){
        int median = 0;
        final PriorityQueue<Integer> left = new PriorityQueue<Integer>(16, Collections.reverseOrder());
        final PriorityQueue<Integer> right = new PriorityQueue<Integer>(16);

        for (int i = 0; i < streamArray.length; i++) {
            median = getMedian(streamArray[i], median, left, right);
        }
        return median;
    }

    public static void main(String[] args){

        int[] array = new int[150];

        for(int i=0; i<150; i++){
            array[i] = i;
            //System.out.println("Median of Stream: " + getStreamMedian(array));
        }

        System.out.println("Median of Stream: " + getStreamMedian(array));
    }


}
