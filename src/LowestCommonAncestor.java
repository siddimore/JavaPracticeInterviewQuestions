/**
 * Created by siddimore on 6/13/16.
 */
public class LowestCommonAncestor {

public Node getLCA(Node root, Node n1, Node n2) {
    if (root == null)
        return null;
    else {
        //if node.data == n1.data || node.data == n2.data then return root
        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }
    }

    //Look in left sub tree
    Node left = getLCA(root.left, n1, n2);
    //Look in right sub tree
    Node right = getLCA(root.right, n1, n2);

    //if left is not null and right is not null
    //root is LCA,return root
    if (left != null && right != null)
        return root;

    //Otherwise left is LCA
    if (left != null)
        return left;
        //Otherwise right is LCA
    else if (right!=null)
            return right;

    return null;
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

public static void main(String[] args) throws java.lang.Exception{

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    Node n3 = new Node(5);
    root.left.right = n3;
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    Node n1 = new Node(8);
    root.left.left.left = n1;
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(20);

    root.left.right.left.left = new Node(11);
    Node n2 = new Node(30);

    root.left.right.left.right = n2;

    LowestCommonAncestor lca = new LowestCommonAncestor();
    Node x = lca.getLCA(root,n1,n2);
    System.out.println("Lowest Common Ancestor: " + x.data);
}

}
