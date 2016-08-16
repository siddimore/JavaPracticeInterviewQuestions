import sun.misc.LRUCache;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by MoreFamily on 2/28/2016.
 */
public class lruCache {

    private int capacity;
    public static Map<Integer, node> CacheMap;
    private node head;
    private node end;
    private int currentSize;

    public lruCache(int capacity)
    {
        this.capacity = capacity;
        currentSize = 0;
        this.CacheMap = new HashMap<>();
    }

    private void printLRUCache()
    {
        node traversNode = node.getStart();
        while(traversNode != null)
        {
            System.out.println("Key: " + traversNode.getKey()
            + " Value: " + traversNode.getData());
            traversNode = traversNode.getNext();
        }
        System.out.println();
    }

    private int get(int Key)
    {
        if(this.CacheMap.containsKey(Key))
        {
            node retNode = this.CacheMap.get(Key);
            node.bringToFront(retNode);
            return retNode.getData();
        }
        else
            return -1;
    }

    private void set(int Key, int Value)
    {
        if(this.CacheMap.containsKey(Key))
        {
            node retNode = this.CacheMap.get(Key);
            node.bringToFront(retNode);
        }
        else
        {
            node insertnode = new node(Key, Value);
            if(currentSize < capacity)
            {
                node.addToFront(insertnode);
                currentSize++;
            }
            else
            {
                node.removeLastNode();
                node.addToFront(insertnode);
            }
        }
    }



    public static void main(String[] args)
    {
        lruCache lCache = new lruCache(15);

        for(int i = 0; i < 15; i++)
        {
            lCache.set(i, i*2);
        }
        lCache.printLRUCache();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        for(int i =0; i <5; i++)
//        {
//        }
//        executorService.execute(new worker());

//        Thread R1 = new Thread( new TestThread("Thread 1"));
//        R1.start();
//
//        Thread R2 = new Thread( new TestThread("Thread 2"));
//        R2.start();

        BST bst = new BST();
        bst.insert(8);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(10);
        bst.insert(15);
        bst.insert(2);
        bst.postorder();
        System.out.println();
        bst.preorder();
        System.out.println();
        bst.inorder();
        System.out.println("Smallest element: " + bst.smallest());
        System.out.println("Largest element: " + bst.largest());
        bst.delete(5);
        bst.inorder();


        List<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));

        System.out.println();
        Collections.sort(list);

        for(Dog a: list)//printing the sorted list of names
            System.out.print(a.getName() + ", ");

        // Sorts the array list using comparator
        Collections.sort(list, new Dog());
        System.out.println(" ");
        for(Dog a: list)//printing the sorted list of ages
            System.out.print(a.getName() +"  : "+
                    a.getAge() + ", ");

    }
}

