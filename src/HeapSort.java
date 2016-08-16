//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
///**
// * Created by MoreFamily on 5/28/2016.
// */
//public class HeapSort {
//
//    private static int[] a;
//    private static int n;
//    private static int left;
//    private static int right;
//    private static int largest;
//
//    public static void buildHeap(int[] a){
//        n = a.length -1;
//
//        for(int i = n/2; i>=0;i--){
//            maxHeap(a, i);
//        }
//    }
//
//    private static void maxHeap(int[] a, int i){
//        left = 2*i +1;
//        right = 2*i+2;
//        largest = i;
//
//        if(left<=n && a[left] > a[largest]){
//            largest = left;
//        }
//
//        if(right<=n && a[right] > a[largest]){
//            largest = right;
//        }
//
//        if(largest != i){
//            exchange(i,largest);
//            maxHeap(a, largest);
//        }
//
//    }
//
//    private static void exchange(int m, int n){
//
//        int temp = a[m];
//        a[m] = a[n];
//        a[n] = temp;
//    }
//
//    public static int[] sort(int[] inputArray){
//        a = inputArray;
//        buildHeap(a);
//
//        for(int i=n;i>0;i--){
//            exchange(0, i);
//            n=n-1;
//            maxHeap(a, 0);
//        }
//        return a;
//    }
//
//    public static Stack<Integer> sortAscending(int[] inputArray){
//        Stack<Integer> s = new Stack<>();
//        a = inputArray;
//        buildHeap(a);
//
//        for(int i: a ){
//            s.add(i);
//        }
//
//        return  s;
//    }
//
//    public static Queue<Integer> sortDescending(int[] inputArray){
//        Queue<Integer> q = new LinkedList<>();
//
//        a = inputArray;
//        buildHeap(a);
//
//        for(int i: a ){
//            q.add(i);
//        }
//
//        return  q;
//    }
//    public static void print(int[] arrayInput){
//        for(int i: arrayInput)
//            System.out.print(i + "\t");
//        System.out.println();
//    }
//
//    public static void main(String[] args){
//
//        int []a1={4,1,3,2,16,9,10,14,8,7};
//        HeapSort.print(a1);
//        int[] sortedArray = sort(a1);
//        HeapSort.print(sortedArray);
//
//        Stack<Integer> ascendingOrder = HeapSort.sortAscending(a1);
//        System.out.println("Sorting in Ascending Manner");
//        for(int i =0; i < ascendingOrder.size(); i++)
//            System.out.print(ascendingOrder.pop() + "\t");
//        System.out.println();
//        Queue<Integer> descendingOrder = HeapSort.sortDescending(a1);
//        System.out.println("Sorting in Descending Manner");
//        for(int i: descendingOrder){
//            System.out.print(i + "\t");
//        }
//    }
//
//}
//
//

import java.util.*;

public class HeapSort {

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;


    public static void buildheap(int []a) {
        n = a.length-1;
        for(int i=n/2; i>=0; i--){
            maxheap(a,i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2*i;
        right = 2*i+1;

        if(left <= n && a[left] > a[i]){
            largest=left;
        } else {
            largest=i;
        }

        if(right <= n && a[right] > a[largest]) {
            largest=right;
        }
        if(largest!=i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] myarray) {
        a = myarray;
        buildheap(a);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }

    public static void main(String[] args) {
        int []numbers={55,2,93,1,23,10,66,12,7,54,3};
        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}