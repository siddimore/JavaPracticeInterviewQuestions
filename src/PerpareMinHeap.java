/**
 * Created by MoreFamily on 5/10/2016.
 */
public class PerpareMinHeap {

    int[] hArr;
    int heap_size;

    public PerpareMinHeap(int[] a){

        hArr = a;
        heap_size = a.length;
        int i = (heap_size -1)/2;

        while(i>=0){
            MinHeapify(i);
            i--;
        }
    }

    private void swap(int a, int b){
        int temp = hArr[a];
        hArr[a] = hArr[b];
        hArr[b] = temp;
    }

    private void MinHeapify(int i){

        int l = left(i);
        int r = right(i);

        int smallest = i;

        if(l<heap_size && hArr[l] < hArr[smallest])
            smallest = l;

        if(r<heap_size && hArr[r] < hArr[smallest])
            smallest = r;

        if(smallest != i){
            swap(smallest ,i);
            MinHeapify(smallest);
        }

    }
    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    private int replaceMin(int x){

        int root = hArr[0];
        hArr[0] = x;
        if(root < x)
            MinHeapify(0);

        return root;

    }

    public int removeMin() throws Exception {
        int val;
        if (heap_size == 0)
            throw new Exception("Heap is empty");
        else {
            val = hArr[0];
            hArr[0] = hArr[heap_size - 1];
            heap_size--;
            if (heap_size > 0)
                //siftDown(0);
            MinHeapify(0);
        }

        return  val;
    }

    public static void main(String[] args){

        PerpareMinHeap mH = new PerpareMinHeap(new int[]{8,6,9,5,3,1});
        try {
            System.out.println(mH.removeMin());
            System.out.println(mH.removeMin());
            System.out.println(mH.removeMin());
            System.out.println(mH.removeMin());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
