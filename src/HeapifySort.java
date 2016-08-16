/**
 * Created by siddimore on 6/23/16.
 */
public class HeapifySort {

    public void heapSort(int[] arr){
        int n = arr.length;
        for(int i = n/2 -1; i>=0 ; i--){
            heapifyArray(arr, n ,i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapifyArray(arr, i, 0);
        }
    }

    public void heapifyArray(int[] a, int n, int i)
    {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && a[l] > a[largest]){
            largest = l;
        }

        if(r<n && a[r] > a[largest])
            largest = r;

        if(largest != i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            //recursively heapify
            heapifyArray(a, n, largest);

        }
    }

    public static void main(String[] args){
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapifySort hS = new HeapifySort();
        hS.heapSort(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }

}
