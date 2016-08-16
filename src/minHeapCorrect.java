/**
 * Created by MoreFamily on 5/5/2016.
 */
public class minHeapCorrect {

    public int size;
    public int[] mH;
    public int position;

    public minHeapCorrect(int size){
        this.size = size;
        mH = new int[size+1];
        position = 0;
    }

    public void createHeap(int [] arrA){
        if(arrA.length>0){
            for(int i=0;i<arrA.length;i++){
                insert(arrA[i]);
            }
        }
    }

    public void display(){
        for(int i=0; i<mH.length; i++){
            System.out.println(" " + mH[i]);
        }
    }

    public void insert(int x){

        if(position == 0){
            mH[position+1] = x;
            position = 2;
        }else{
            mH[position++] = x;
            bubbleup();
        }
    }

    //public void heapifyUP() bubbleup is alias for heapifyUp
    public void bubbleup(){
        int pos = position -1;
        //check if parent node is greater than current node
        //if so swap
        while (pos >0 && mH[pos/2] > mH[pos]){
            int y = mH[pos];
            mH[pos] = mH[pos/2];
            mH[pos/2] = y;
            pos = pos/2;
        }
    }

    public int extractMin(){
        int min = mH[1];
        mH[1] = mH[position-1];
        mH[position -1] = 0;
        position--;
        sinkDown(1);
        return min;
    }

    public void sinkDown(int k){
        int smallest = k;

        if(2*k < position && mH[smallest] > mH[2*k]){
            smallest = 2*k;
        }
        if(2*k+1 < position && mH[smallest] > mH[2*k+1]){
            smallest = 2*k+1;
        }

        if(smallest!=k){
            swap(k,smallest);
            sinkDown(smallest);
        }
    }

    public void swap(int a, int b){
        int temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }

    public static void main(String[] args){
        int[] arrA = {3,2,1,7,8,4,10,16,12};
        System.out.println("Original array: ");
        for(int i: arrA){
            System.out.println(" " + i);
        }

        minHeapCorrect m = new minHeapCorrect(arrA.length);
        System.out.println("=== Min Heap ===");
        m.createHeap(arrA);
        m.display();
        System.out.println("Min: " + m.extractMin());
    }
}
