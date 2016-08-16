///**
// * Created by MoreFamily on 5/28/2016.
// */
//public class AddTwoList {
//
//
//    static class linkedList{
//
//        nodeForLinkedList head;
//        int count = 0;
//
//        public linkedList(){
//            head = null;
//        }
//
//        public void insert(int val){
//
//            if(head == null){
//                head = new nodeForLinkedList(val);
//            }
//            else{
//                nodeForLinkedList temp = new nodeForLinkedList(val);
//                temp.setNext(head);
//                head = temp;
//            }
//            ++count;
//        }
//
//        public nodeForLinkedList reverse(){
//
//            nodeForLinkedList revHead = null;
//            nodeForLinkedList current = head;
//            nodeForLinkedList next = current.getNext();
//            while(current.getNext() != null)
//            {
//                current.setNext(revHead);
//                revHead = current;
//                current = next;
//                next = next.getNext();
//            }
//            current.setNext(revHead);
//            revHead = current;
//            return  revHead;
//        }
//    }
//
//    class nodeForLinkedList{
//        int val;
//
//        public nodeForLinkedList getNext() {
//            return next;
//        }
//
//        public void setNext(nodeForLinkedList next) {
//            this.next = next;
//        }
//
//        public int getVal() {
//            return val;
//        }
//
//        public void setVal(int val) {
//            this.val = val;
//        }
//
//        nodeForLinkedList next;
//
//        public nodeForLinkedList(int val){
//            this.val = val;
//            next = null;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        linkedList list1 = new linkedList();
//        li
//
//    }
//}
