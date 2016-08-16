/**
 * Created by siddimore on 6/13/16.
 */
public class LowestCommonAncestorBST {

    public Node getLCA(Node root, Node n1, Node n2){
        if(root == null)
            return null;

        if(root.data > n1.data && root.data > n2.data)
            return getLCA(root.left,n1,n2);
        else if(root.data < n1.data && root.data < n2.data)
            return getLCA(root.right,n1,n2);

        return root;
    }


    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }

    public static void main(String[] args){

        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        Node n1 = new Node(5);
        root.left.left = n1;
        root.left.right = new Node(13);
        Node n2 = new Node(14);
        root.left.right.right = n2;
        root.left.right.left = new Node(12);

        LowestCommonAncestorBST lcaBST = new LowestCommonAncestorBST();
        System.out.println("Recursive: " + lcaBST.getLCA(root,n1,n2).data);



    }
}
