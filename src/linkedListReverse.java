/**
 * Created by MoreFamily on 5/20/2016.
 */
public class linkedListReverse {


    node head = null;
    public  void createLinkedList(){
        for(int i=0; i< 10; i++){
            insert(i);
        }

        node temp = head;
        System.out.println("LinkedList before Reverse: ");
        while(temp.getNext() != null){
            System.out.println(temp.getVal());
            temp= temp.getNext();
        }

    }

    public void reverse(){
        node rev = null;
        node curr = head;
        node next = head.getNext();

        while(next.getNext()!= null){
            curr.setNext(rev);
            rev = curr;
            curr = next;
            next = next.getNext();
        }
        next.setNext(rev);
        head = rev;

        System.out.println("LinkedList after Reverse: ");
        while(rev.getNext() != null){
            System.out.println(rev.getVal());
            rev=rev.getNext();
        }

    }
    private  void insert(int i){
        if(head == null){
            head = new node(i);
        }else{
            node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new node(i));
        }
    }

    class node{
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public node getNext() {
            return next;
        }

        public void setNext(node next) {
            this.next = next;
        }

        int val;
        node next;

        public node(int i){
            this.val = i;
            this.next = null;
        }
    }

    public static void main(String[] args){
        linkedListReverse lr = new linkedListReverse();
        lr.createLinkedList();
        lr.reverse();
    }


}
