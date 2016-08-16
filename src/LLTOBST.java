/**
 * Created by siddimore on 6/14/16.
 */
public class LLTOBST {

    static Node head = null;
    static int[] a = null;

    public BSTNode convertLLToBST(int start, int end){

        if(start>end)   return null;
        int mid = (start+end)/2;

        BSTNode leftChild = convertLLToBST(start,mid-1);
        //Add linked list to BSTNode to root head
        BSTNode root = new BSTNode(head.data);
        root.left = leftChild;
        head = head.next;
        root.right = convertLLToBST(mid+1,end);

        return root;
    }

    public BSTNode convertArrayToBST( int start, int end){

        if(start > end) return null;
        int mid = (start + end)/2;

        BSTNode leftChild = convertArrayToBST(start, mid-1);
        BSTNode root = new BSTNode(a[mid]);
        root.left = leftChild;
        root.right = convertArrayToBST(mid+1,end);

        return root;
    }

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    static int getSize(Node head){
        Node temp = head;
        int size = 0;

        while(temp != null){
            ++ size;
            temp = temp.next;
        }

        return size;
    }

    class BSTNode{

        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int val){
            data = val;
            left = null;
            right = null;
        }

    }


    static void inOrder(BSTNode root){

        if(root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void main(String[] args) {

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int size = getSize(head);

        LLTOBST lToBST = new LLTOBST();
        BSTNode root = lToBST.convertLLToBST(1, size);
        System.out.println("Converted LL to BST:");
        inOrder(root);
        a = new int[]{11,12,13,14,15,16};
        BSTNode arrayRoot = lToBST.convertArrayToBST(0,a.length-1);
        System.out.println("Converted Array to BST:");
        inOrder(arrayRoot);

    }
}
