/**
 * Created by siddimore on 6/19/16.
 */
public class heapSortImplementation {

    public void heapsort(int[] input) {
        // convert input to heap
        int leastParent = (input.length - 1) / 2;
        for (int i = leastParent; i >= 0; i--) {
            moveDown(input, i, input.length - 1);
        }
        // flatten heap into sorted array
        for (int i = input.length - 1; i > 0; i--) {
            if (input[0] > input[i]) {
                swap(input, 0, i);
                moveDown(input, 0, i - 1);
            }
        }
    }

    private void moveDown(int[] input, int first, int last) {
        int largest = 2 * first + 1;
        while (largest <= last) {
            // right child exists and is larger than left child
            if (largest < last && input[largest] < input[largest + 1]) {
                largest++;
            }
            // right child is larger than parent
            if (input[largest] > input[first]) {
                swap(input, largest, first);
                // move down to largest child
                first = largest;
                largest = 2 * first + 1;
            } else {
                return;// force exit
            }
        }
    }

    private void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static void main(String[] args){

        heapSortImplementation hI = new heapSortImplementation();
        int []a1={4,1,3,2,16,9,10,14,8,7};
        hI.heapsort(a1);
        for(int i: a1){
            System.out.print(i + "\t");
        }
    }
}
