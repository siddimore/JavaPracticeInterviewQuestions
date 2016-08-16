/**
 * Created by MoreFamily on 4/9/2016.
 */
public class loopLinkedList {

    private node head;

    public void insert(int val){
        if(head == null)
            head = new node(val);
            else{

            node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new node(val));
        }
    }

    public void createLoop() throws Exception {

        if (head == null) {
            throw new Exception("Empty List cannot have a loop");
        } else {
            node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(head);
        }
    }

    public void detectLoop(){
        node sp = head;
        node fp = head.getNext();

        while(sp != null && fp !=null&& fp.getNext() !=null){
            sp = sp.getNext();
            fp = fp.getNext().getNext();
            if(sp == fp){
                System.out.println("Detected a Loop");
                break;
            }
        }
    }


    class node{

        private int data;
        private node next;

        public node getNext() {
            return next;
        }

        public void setNext(node next) {
            this.next = next;
        }

        public node(int data){
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args){
        loopLinkedList list = new loopLinkedList();
        list.insert(20);
        list.insert(15);
        list.insert(4);
        list.insert(10);
        try {
            //list.createLoop();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        list.detectLoop();

    }
}
