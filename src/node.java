/**
 * Created by MoreFamily on 2/28/2016.
 */
public class node {
    public int getKey() {
        return key;
    }

    private int key;

    public int getData() {
        return data;
    }

    private int data;
    private node previous;

    public node getNext() {
        return next;
    }

    private node next;

    public static node getStart() {
        return start;
    }

    private static node start;

    public static node getEnd() {
        return end;
    }

    private static node end;

    public node(int Key, int Value)
    {
        this.key = Key;
        this.data = Value;
        previous = null;
        next = null;
    }

    public static void addToFront(node insertNode)
    {
        insertNode.next = start;
        insertNode.previous = null;
        if(start!=null)
            start.previous = insertNode;
        start = insertNode;
        if(end!=null)
            end = insertNode;
        if(lruCache.CacheMap != null)
        lruCache.CacheMap.put(insertNode.key, insertNode);
    }


    public static void bringToFront(node Node)
    {
        node prevNode = Node.previous;
        node nextNode = Node.next;

        if(prevNode != null)
            prevNode.next = nextNode;
        else
            start = nextNode;
        if(nextNode != null)
            nextNode.previous = prevNode;
        else
            end = prevNode;
        addToFront(Node);
    }

    public static void removeLastNode()
    {
        node lasTNode = lruCache.CacheMap.remove(end.key);
        end = end.previous;
        if(end!=null)
            end.next = null;
        lasTNode = null;
    }

}
