/**
 * Created by MoreFamily on 4/1/2016.
 */
public class doubleNode {
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public doubleNode getNext() {
        return next;
    }

    public void setNext(doubleNode next) {
        this.next = next;
    }

    public doubleNode getPrev() {
        return prev;
    }

    public void setPrev(doubleNode prev) {
        this.prev = prev;
    }

    int data;
    doubleNode next;
    doubleNode prev;

    public doubleNode(int Val)
    {
        this.data = Val;
        next = null;
        prev = null;
    }


}
