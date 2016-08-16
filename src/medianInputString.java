import java.util.*;

/**
 * Created by MoreFamily on 5/5/2016.
 */
public class medianInputString {

    public Queue<Integer> minHeap;
    public Queue<Integer> maxHeap;
    public int numElements;

    public medianInputString(){
        maxHeap = new PriorityQueue<>(10, new MaxHeapComparator());
        minHeap = new PriorityQueue<>();
        numElements = 0;
    }

    public void addNumberToStream(Integer num){
        maxHeap.add(num);
        if(numElements%2 == 0){
            if(minHeap.isEmpty()){
                minHeap.add(num);
                numElements++;
                return;
            }else if(maxHeap.peek() > minHeap.peek()){
                int maxHeapRoot = maxHeap.poll();
                int minHeapRoot = minHeap.poll();

                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
            else{
                minHeap.add(maxHeap.poll());
            }
        }
        numElements++;
    }

    public double getMedian(){
        if(numElements%2 !=0){
            return (double)(maxHeap.peek());
        }else{
            return (double)(maxHeap.peek() + minHeap.peek())%2.0;
        }
    }

    private class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        medianInputString streamMedian = new medianInputString();

        streamMedian.addNumberToStream(3);
        streamMedian.addNumberToStream(8);
        streamMedian.addNumberToStream(9);
        streamMedian.addNumberToStream(10);
        streamMedian.addNumberToStream(11);
        System.out.println(streamMedian.getMedian()); // should be 6.5

        streamMedian.addNumberToStream(1);
        System.out.println(streamMedian.getMedian()); // should be 1

        streamMedian.addNumberToStream(5);
        streamMedian.addNumberToStream(10);
        streamMedian.addNumberToStream(12);
        streamMedian.addNumberToStream(2);
        System.out.println(streamMedian.getMedian()); // should be 5

        streamMedian.addNumberToStream(3);
        streamMedian.addNumberToStream(8);
        streamMedian.addNumberToStream(9);
        System.out.println(streamMedian.getMedian()); // should be 6.5
    }
}
