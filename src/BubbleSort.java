/**
 * Created by MoreFamily on 4/5/2016.
 */
public class BubbleSort {

    int[] A = {12,8,7,5,2};

    public BubbleSort()
    {

    }

    private void sort(){

        for(int i =0; i < A.length-1; i++)
            for(int j = 1 ; j <A.length-i; j++)
            {
                if(A[j-1] > A[j])
                {
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                }
            }
    }

    public void print(){
        for(Integer i:A){
         System.out.println("i: " + i);
        }
    }

    public static void main(String[] args){
        BubbleSort B = new BubbleSort();
        B.sort();
        B.print();
    }


}
