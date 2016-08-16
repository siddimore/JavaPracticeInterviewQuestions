import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by siddimore on 6/18/16.
 */
public class MergeKListsPQ {


    PriorityQueue<ListNode> pQ = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.data - l2.data;
        }
    });

    public ListNode process(ListNode[] lists){

        for(ListNode l : lists){
            ListNode head = l;
            do{
                pQ.add(head);
                head = head.next;
            }while(head != null);

        }

        ListNode sortedListHead = null;

        while(!pQ.isEmpty()){

            if(sortedListHead == null){
                sortedListHead = pQ.poll();
            }
            else{
                ListNode temp = sortedListHead;
                while(temp!=null){
                    temp = temp.next;
                }
                temp.next = pQ.poll();
            }
        }

        return sortedListHead;

    }


    public ListNode removeDupes(ListNode dupeList){

        ListNode current;
        ListNode prev;

        current = dupeList.next;
        prev = dupeList;

        do{
            if(current.data == prev.data){
                prev.next = current.next;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        while(current != null);

        return dupeList;
    }

    public ListNode removeNthNode(ListNode head, int K){

        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<K; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = fast;

        return head;
    }




    public class ListNode{

        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
            next = null;
        }

    }



}
