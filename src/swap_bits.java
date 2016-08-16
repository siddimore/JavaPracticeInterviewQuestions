/**
 * Created by siddimore on 6/19/16.
 */
public class swap_bits {

    public static int swapBit(int x, int i, int j){

        if((x>>i & 1) != (x>>j & 1)){
            x ^= (1L << i) | (1L << j);
        }

        return x;
    }

    public static int reverseBit(int x){

        int intSize = 8;
        int y = 0;

        for(int pos = intSize-1; pos >0; pos--){
            y+= (x&1) << pos;
            x = x>>1;
        }

        return y;
    }

    public static boolean kthSetBit(int x, int k){

        if((x&1<<k) != 0)
            return true;

        return false;
    }

    public void insertionSort(int[] input){

        for(int i= 1, k,tmp; i<input.length; i++){
            tmp = input[i];
            for(k =i; k > 0 && tmp < input[k-1]; k--){
                input[k] = input[k-1];
            }
            input[k] = tmp;
        }
    }


    public void moveDown(int[] input, int first, int last){






    }


    public void heapSort(int[] input){







    }

    public static void main(String[] args){
//        System.out.println(swapBit(10, 1,3));

        System.out.println(reverseBit(1));
        System.out.println(kthSetBit(1 ,8));
        int[] t = new int[]{8,5,3,1,9,6,0,7,4,2,5};
        swap_bits swapB = new swap_bits();
        swapB.insertionSort(t);
        System.out.println();


    }


}
