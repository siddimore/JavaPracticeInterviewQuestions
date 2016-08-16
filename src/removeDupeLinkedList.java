import java.util.Set;
import java.util.TreeSet;

/**
 * Created by siddimore on 6/14/16.
 */
public class removeDupeLinkedList {

    public void processDupe(myLinkedList lL){

        Set<Integer> set = new TreeSet<>();

        myNode temp = lL.getHead();

        while(temp != null){
            set.add(temp.data);
            temp = temp.next;
        }

        myLinkedList newList = new myLinkedList();
        for(Integer i: set)
        newList.insert(i);
        printList(newList);

    }

    private void printList(myLinkedList list){
        myNode temp = list.getHead();
        while(temp != null) {
            System.out.println("Data is: " + temp.data);
            temp = temp.next;
        }

    }

    public class myLinkedList{

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

        removeDupeLinkedList rmL = new removeDupeLinkedList();
        removeDupeLinkedList.myLinkedList List = rmL.new myLinkedList();
        List.insert(1);
        List.insert(2);
        List.insert(2);
        List.insert(3);
        List.insert(4);
        List.insert(4);
        rmL.processDupe(List);
    }
}
