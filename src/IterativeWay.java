/**
 * Created by siddimore on 6/19/16.
 */
public class IterativeWay {


    public void swapLinks(MergeKListsPQ.ListNode l){

        MergeKListsPQ.ListNode current = l;
        MergeKListsPQ.ListNode head = l;
        MergeKListsPQ.ListNode ptNext = l.next;
        MergeKListsPQ.ListNode ptOne = l;
        int count = 2;

        while(current != null){

            while(count != 0){
                current.next = ptNext.next;
                ptNext.next = current;
                --count;
            }
            current = current.next;
            ptNext = current.next;
            ++count;


        }




    }




}
