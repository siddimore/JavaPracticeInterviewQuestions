/**
 * Created by MoreFamily on 5/4/2016.
 */
public class LRUCacheNode {

    public int getKey() {
        return key;
    }

    private int key;

    public int getData() {
        return data;
    }

    private int data;

    private LRUCacheNode next;
    public LRUCacheNode getNext() {
        return next;
    }

    public void setNext(LRUCacheNode next) {
        this.next = next;
    }

    private LRUCacheNode previous;
    public void setPrevious(LRUCacheNode previous) {
        this.previous = previous;
    }
    public LRUCacheNode getPrevious()
    {
        return previous;
    }



//    public static node getStart() {
//        return start;
//    }
//
//    private static node start;
//
//    public static node getEnd() {
//        return end;
//    }
//
//    private static node end;

    public LRUCacheNode(int Key, int Value)
    {
        this.key = Key;
        this.data = Value;
        previous = null;
        next = null;
    }
}
