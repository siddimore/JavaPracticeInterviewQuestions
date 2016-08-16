import java.util.HashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 5/4/2016.
 */
public class LRUCacheQIm {

    private Map<Integer,LRUCacheNode> lruMap = null;
    private LRUCacheQ queue = null;
    private int capacity, currentSize;

    public LRUCacheQIm(int capacity){
        this.capacity = capacity;
        currentSize = 0;
        lruMap = new HashMap<>();
        queue = new LRUCacheQ();
    }

    class LRUCacheQ {
        private LRUCacheNode start;

        public LRUCacheNode getEnd() {
            return end;
        }

        public  LRUCacheNode getStart() {
            return start;
        }

        private LRUCacheNode end;

        public LRUCacheQ() {
            start = end = null;
        }

        //add node to front of queue
        public void addToFront(LRUCacheNode n) {
            n.setNext(start);
            n.setPrevious(null);

            if (start != null)
                start.setPrevious(n);

            start = n;

            if (end != null) {
                end = n;
            }
            lruMap.put(n.getKey(), n);
        }

        //bring node to front of queue
        public void bringToFront(LRUCacheNode n) {
            LRUCacheNode prevNode = n.getPrevious();
            LRUCacheNode nextNode = n.getNext();

            if (prevNode != null)
                prevNode.setNext(nextNode);// = nextNode;
            else
                start = nextNode;
            if (nextNode != null)
                nextNode.setPrevious(prevNode); //= prevNode;
            else
                end = prevNode;
            addToFront(n);
        }

        //remove Last node from queue
        public void removeLastNode() {
            LRUCacheNode lastNode = lruMap.remove(end.getKey());
            end = end.getPrevious();
            if (end != null)
                end.setNext(null);
            lastNode = null;
        }
    }

    //print Cache
    private void printLRUCache()
    {
        LRUCacheNode traversNode = queue.getStart();
        while(traversNode != null)
        {
            System.out.println("Key: " + traversNode.getKey()
                    + " Value: " + traversNode.getData());
            traversNode = traversNode.getNext();
        }
        System.out.println();
    }

    //get Element from LRUCache
    private int get(int Key) {
        if (this.lruMap.containsKey(Key)) {
            LRUCacheNode retNode = this.lruMap.get(Key);
            queue.bringToFront(retNode);
            return retNode.getData();
        } else
            return -1;
    }

    //set Element LRUCache
    private void set(int Key, int Value) {
        if (this.lruMap.containsKey(Key)) {
            LRUCacheNode retNode = this.lruMap.get(Key);
            queue.bringToFront(retNode);
        } else {
            LRUCacheNode insertnode = new LRUCacheNode(Key, Value);
            if (currentSize < capacity) {
                queue.addToFront(insertnode);
                currentSize++;
            } else {
                queue.removeLastNode();
                queue.addToFront(insertnode);
            }
        }
    }

    //Driver program
    public static void main(String[] args){

        LRUCacheQIm lCache = new LRUCacheQIm(15);

        for(int i = 0; i < 15; i++)
        {
            lCache.set(i, i*2);
        }
        lCache.printLRUCache();
    }

}

