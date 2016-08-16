import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by MoreFamily on 4/3/2016.
 */
public class heap {

    private void swap(int a, int b)
    {

    }
    /** The number of children each node has **/
    private static final int d = 2;
    private int  capacity;
    private int heap_size;
    private int[] heap;
    public heap(int capacity)
    {
        heap_size = 0;
        this.capacity = capacity;
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty()
    {
        return (heap.length == 0) ? true:false;
    }

    public boolean isFull()
    {
        return (heap.length == capacity) ? true:false;
    }

    public void makeEmpty()
    {

    }

    private int parent(int i)
    {
        return (i-1)/d;
    }

    private int kthChild(int i, int k)
    {
        return d* i+k;
    }

    public void insert(int x) throws Exception
    {
        if(isFull()){
            throw new Exception("Overflow exception");
        }
        heap[heap_size++] = x;
        heapifyUp(heap_size -1);
    }

    public int findMin() throws Exception
    {
        if(isEmpty())
            throw new Exception("Heap Empty Underflow Exception");
        return heap[0];
    }

    public int delete(int ind)
    {
        if(isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
            int keyItem = heap[ind];
            heap[ind] = heap[heap_size -1];
            heap_size--;
            //heapifyDown(ind);
            return keyItem;
    }

    private void heapifyUp(int childInd)
    {
        int temp = heap[childInd];
        while(childInd > 0 && temp < heap[parent(childInd)]){
            heap[childInd] = heap[parent(childInd)];
            childInd = parent(childInd);
        }
        heap[childInd] = temp;
    }

    //private oid heapifyDown(int ind)


}
