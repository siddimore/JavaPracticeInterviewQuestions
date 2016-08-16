/**
 * Created by siddimore on 8/2/16.
 */


/** Source code example for "A Practical Introduction to Data
 Structures and Algorithm Analysis, 3rd Edition (Java)"
 by Clifford A. Shaffer
 Copyright 2008-2011 by Clifford A. Shaffer
 */

import java.lang.Comparable;

/** Min-heap implementation */
public class MinHeap<E extends Comparable<? super E>> {
    private E[] Heap;   // Pointer to the heap array
    private int size;   // Maximum size of the heap
    private int n;      // Number of things in heap

    public MinHeap(E[] h, int num, int max)
    {   Heap = h;
        n = num;
        size = max;
        //buildMinHeap();
        buildMaxHeap();
    }

    /** Return current size of the heap */
    public int heapsize() { return n; }

    /** Is pos a leaf position? */
    public boolean isLeaf(int pos)
    { return (pos >= n/2) && (pos < n); }

    /** Return position for left child of pos */
    public int leftchild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    /** Return position for right child of pos */
    public int rightchild(int pos) {
        assert pos < (n-1)/2 : "Position has no right child";
        return 2*pos + 2;
    }

    /** Return position for parent */
    public int parent(int pos) {
        assert pos > 0 : "Position has no parent";
        return (pos-1)/2;
    }


    /** Heapify content of Heap **/
    public void buildMaxHeap(){

        for (int i=n/2-1; i>=0; i--) siftUp(i);
    }

    /** Heapify contents of Heap */
    public void buildMinHeap()
    { for (int i=n/2-1; i>=0; i--) siftdown(i); }

    /** Insert into heap */
    public void insert(E val) {
        assert n < size : "Heap is full";
        int curr = n++;
        Heap[curr] = val;                 // Start at end of heap
        // Now sift up until curr's parent's key > curr's key
        while ((curr != 0)  &&
                (Heap[curr].compareTo(Heap[parent(curr)]) < 0)) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    /** Put element in its correct place */
    private void siftUp(int pos){
        assert (pos >= 0) && (pos <n) : "Illegal Heap Position";
        if(!isLeaf(pos)){

            if(Heap[pos].compareTo(Heap[leftchild(pos)]) < 0 || Heap[pos].compareTo(Heap[rightchild(pos)]) < 0){
                if(Heap[leftchild(pos)].compareTo(Heap[rightchild(pos)]) > 0){
                    swap(pos,leftchild(pos));
                    siftUp(leftchild(pos));
                }
                else{
                    swap(pos,rightchild(pos));
                    siftUp(rightchild(pos));
                }
            }
        }
    }




    /** Put element in its correct place */
    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j<(n-1)) && (Heap[j].compareTo(Heap[j+1]) > 0))
                j++; // j is now index of child with greater value
            if (Heap[pos].compareTo(Heap[j]) <= 0)
                return;
            swap(pos, j);
            pos = j;  // Move down
        }
    }

    public E removemin() {     // Remove minimum value
        assert n > 0 : "Removing from empty heap";
        swap(0, --n); // Swap minimum with last value
        if (n != 0)      // Not on last element
            siftdown(0);   // Put new heap root val in correct place
        return Heap[n];
    }

    /** Remove element at specified position */
    public E remove(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        if (pos == (n-1)) n--; // Last element, no work to be done
        else
        {
             // Swap with last value
            swap(pos, --n);
            // If we just swapped in a small value, push it up
            while ((pos > 0) && (Heap[pos].compareTo(Heap[parent(pos)]) < 0)) {
                swap(pos, parent(pos));
                pos = parent(pos);
            }
            if (n != 0) siftdown(pos);   // If it is big, push down
        }
        return Heap[n];
    }

    public void swap(int i , int j){
        E temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    private void printHeap(){
        if(Heap != null){

            for(E value: Heap){
                System.out.println(value);
            }

        }
    }


    public static void main(String[] args){

        Integer[] array = {12,90,20,1,100};
        MinHeap<Integer> mH = new MinHeap<>(array, array.length,50);
        mH.buildMaxHeap();
        mH.printHeap();
    }
}