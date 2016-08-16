import java.util.LinkedHashSet;

/**
 * Created by MoreFamily on 4/2/2016.
 */
public class linkedList implements linkedListPrint{

    public lNode getHead() {
        return head;
    }

    private lNode head;
    private int size;
    private static final int MAXSIZE = 100;
    private int count = 0;
    private LinkedHashSet orderedSet;
    public linkedList(int size) throws Exception
    {
        if(size > MAXSIZE)
        {
            throw new Exception("Size Cannot be Greater Than: " + Integer.toString(MAXSIZE));
        }
        else
        this.size = size;
        orderedSet = new LinkedHashSet();
    }

    public void insert(int Val)
    {
        if(head == null)
        {
            head = new lNode(Val);
        }
        else
        {
            lNode temp = head;
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(new lNode(Val));
        }
        ++count;
    }

    public void reverse()
    {
        lNode revHead = null;
        lNode current = head;
        lNode Next = head.getNext();

        while(Next.getNext() != null)
        {
            current.setNext(revHead);
            revHead = current;
            current = Next;
            Next = Next.getNext();
        }

        Next.setNext(revHead);
        revHead = Next;
        head = revHead;
    }

    private void printLinkedList()
    {
        lNode temp = head;
        while(temp.getNext() != null)
        {
            System.out.println("Data: " + temp.getVal());
            temp = temp.getNext();
        }
        System.out.println("Data: " + temp.getVal());
        System.out.println();
    }

    public void finishedInserting() {
        printLinkedList();
    }

    public void mergeList(linkedList a, linkedList b){
        lNode head1 = a.getHead();
        lNode head2 = b.getHead();
        lNode temp;
        lNode temp2;
        if(a.count > b.count) {
            temp = head1;
            temp2 = head2;
        }
        else {
            temp = head2;
            temp2 = head1;
        }

        lNode temp3 = temp.getNext();
        while(temp != null){

            if(temp2 == null){
                break;
            }
            else {
                if (temp.getVal() > temp2.getVal()){
                    lNode newNode = new lNode(temp2.getVal());

                }
            }

        }

    }


    class lNode
    {
        private int val;

        public lNode getNext() {
            return next;
        }

        public void setNext(lNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        private lNode next;

        public lNode(int val)
        {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args)
    {
        linkedList L;
        linkedList M;
        try {
            L = new linkedList(30);
            M = new linkedList(30);

            for(int i =0; i<30; i++)
            {
                if(i%2 == 1)
                L.insert(i);
            }

            L.finishedInserting();
            //L.printLinkedList();
            L.reverse();
            L.printLinkedList();

            for(int i =0; i<30; i++)
            {
                if(i%2 == 0)
                    M.insert(i);
            }
            M.printLinkedList();



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                L = new linkedList(linkedList.MAXSIZE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
