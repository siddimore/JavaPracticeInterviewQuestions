import java.util.HashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 3/15/2016.
 */
public class LRUCacheP {

    class node
    {
        private int value;
        private int key;
        private node pre;
        private node next;

        public node(int key, int Val)
        {
            value = Val;
            pre = next = null;
            this.key = key;
        }

        public node getNext() {
            return next;
        }

        public void setNext(node next) {
            this.next = next;
        }

        public node getPre() {
            return pre;
        }

        public void setPre(node pre) {
            this.pre = pre;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    private Map<Integer, node> LMap;
    private int capacity;
    private node head;
    private node end;
    public LRUCacheP(int size)
    {
        LMap =  new HashMap<>();
        capacity = size;
    }

    public int get(int Key)
    {
        if(LMap.containsKey(Key))
        {
            node n = LMap.get(Key);
            remove(n);
            setHead(n);
            return n.getValue();
        }

        return -1;
    }

    public void remove(node toRemove)
    {
        if(toRemove.getPre()!=null)
        {
            toRemove.getPre().getNext().setNext(toRemove.getNext());
        }
        else
        {
            head = toRemove.getNext();
        }

        if(toRemove.getNext() != null)
        {
            toRemove.getNext().setPre(toRemove.getPre());
        }
    }

    public void setHead(node n)
    {
        n.setNext(head);
        n.setPre(null);
        head = n;

        if(end == null)
            end = head;
    }

    public void set(int key, int value) throws IndexOutOfBoundsException
    {
        if(LMap.containsKey(key))
        {
            node old = LMap.get(key);
            old.setValue(value);
            remove(old);
            setHead(old);
        }
        else
        {
            node newNode = new node(key, value);
            if(LMap.size() >= this.capacity)
            {
                LMap.remove(end.key);
                remove(end);
                setHead(newNode);
            }
            else
            {
                setHead(newNode);
            }
            LMap.put(key, newNode);
        }

    }
}
