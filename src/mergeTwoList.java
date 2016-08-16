/**
 * Created by siddimore on 6/14/16.
 */
public class mergeTwoList {

    public mergeTwoList(){

    }

    public void process(linkedListImplementation L1, linkedListImplementation L2){

        myNode head1 = L1.getHead();
        myNode head2 = L2.getHead();

        while(head1!= null && head2 != null){

            if(head1.data < head2.data){
                System.out.println(head1.data);
                head1 = head1.next;
            }
            else {
                System.out.println(head2.data);
                head2 = head2.next;
            }
        }

        if(head1!=null){
            System.out.println(head1.data);
            head1 = head1.next;
        }
        else  if(head2!=null) {
            System.out.println(head2.data);
            head2 = head2.next;
        }
    }

    public class linkedListImplementation{

        public myNode getHead() {
            return head;
        }

        myNode head = null;

        public void insert(int data){

            if(head == null){
                head = new myNode(data);
            }
            else{
                myNode temp = head;

                while(temp.next!=null){
                    temp = temp.next;
                }

                temp.next = new myNode(data);
            }
        }
    }

    class myNode{
        int data;
        myNode next;

        public myNode(int data){
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args){

        mergeTwoList mT = new mergeTwoList();
        mergeTwoList.linkedListImplementation lL1 = mT.new linkedListImplementation();
        lL1.insert(1);
        lL1.insert(3);
        lL1.insert(10);
        lL1.insert(15);

        mergeTwoList.linkedListImplementation lL2 = mT.new linkedListImplementation();
        lL2.insert(2);
        lL2.insert(4);
        lL2.insert(8);

        mT.process(lL1,lL2);


    }


}
