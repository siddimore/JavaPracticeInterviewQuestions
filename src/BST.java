import sun.invoke.empty.Empty;

import java.util.Stack;

/**
 * Created by MoreFamily on 3/10/2016.
 */
public class BST {

    private BSTNode root;
    public BST()
    {
        root = null;
    }

    private boolean isEmpty()
    {
        return root == null;
    }

    public void insert(int data)
    {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode n, int data)
    {
        if (n == null)
        {
            n = new BSTNode(data);
        }
        else if (n.getData() >= data)
        {
            n.left = insert(n.left, data);
        }
        else
        {
            n.right = insert(n.right, data);
        }
        return n;
    }

    public void delete(int k)
    {
        if(isEmpty())
        {
            //Do nothing
            System.out.println("Tree is Empty");
        }
        BSTNode nFoundNode = find(k);
        if(nFoundNode == null)
        {
            System.out.println("No such Node present in Tree");
        }
        else
        {
            //root = delete(root, k);
            root = delete(nFoundNode, k);
        }
    }

    public BSTNode find(int k)
    {
        return find(root, k);
    }

    public BSTNode find(BSTNode n, int k)
    {
        boolean bFound = false;

        while(n!=null && !bFound)
        {
            int rVal = n.getData();
            if(rVal == k)
            {
                bFound = true;
                return n;
                //break;
            }
            else if(rVal < k)
                n = n.getRight();
            else n = n.getLeft();
        }
        return null;
    }

    public int countNodes()
    {
        return countNodes(root);
    }

    public int countNodes(BSTNode n)
    {
        int l = 1;
        if(n == null)
            return 0;
        else
        {
            l += countNodes(n.getLeft());
            l += countNodes(n.getRight());
        }
        return l;
     }

    private BSTNode delete(BSTNode root , int k)
    {
        {
            BSTNode p, p2, n;
            if (root.getData() == k)
            {
                BSTNode lt, rt;
                lt = root.getLeft();
                rt = root.getRight();
                if (lt == null && rt == null)
                    return null;
                else if (lt == null)
                {
                    p = rt;
                    return p;
                }
                else if (rt == null)
                {
                    p = lt;
                    return p;
                }
                else
                {
                    p2 = rt;
                    p = rt;
                    while (p.getLeft() != null)
                        p = p.getLeft();
                    p.setLeft(lt);
                    return p2;
                }
            }
            if (k < root.getData())
            {
                n = delete(root.getLeft(), k);
                root.setLeft(n);
            }
            else
            {
                n = delete(root.getRight(), k);
                root.setRight(n);
            }
            return root;
        }

    }

    public int smallest()
    {
        return smallest(root);
    }

    public int largest()
    {
        return largest(root);
    }
    private int largest(BSTNode r)
    {
        if(r.getRight() != null)
        {
            return largest(r.getRight());
        }
        return r.getData();

    }

    private int smallest(BSTNode r)
    {
        if(r.getLeft() != null)
        {
            return smallest(r.getLeft());
        }

        return r.getData();
    }

    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }

    private BSTNode lowestCommonAncestor(BSTNode n, int n1, int n2){
        if(n == null) return null;

        if(n.getData() > n1 && n.getData() > n2) {
            return lowestCommonAncestor(n.getLeft(), n1, n2);
        }

        if(n.getData() < n1 && n.getData() < n2){
            return lowestCommonAncestor(n.getRight(),n1,n2);
        }
            return n;
    }

    private boolean isBST(BSTNode r){
        //boolean bBST = false;

        return isBSTUtil(r, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBSTUtil(BSTNode r, int min, int max){
        if(r == null)
            return true;
        if(r.data < min || r.data > max)
            return false;
        return (isBSTUtil(r.left,min,r.data-1) &&
        isBSTUtil(r.right,r.data+1,max));
    }

    private void hasPath(BSTNode root, int sum){

        String path;
        if(root!=null){
            if(root.data > sum)
                return ;
        }
        else{

            path = "" + root.data;
            sum = sum - root.data;
            if(sum == 0)
                System.out.println(path);
            hasPath(root.left,sum);
            hasPath(root.right,sum);
        }
    }




    public class BSTIterator{

        Stack<BSTNode> stack;

        public BSTIterator(BSTNode root) {

            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
        }

            public boolean hasNext(){
                return !stack.isEmpty();
        }

        public int next(){
            BSTNode node = stack.pop();
            int result = node.getData();

            if(node.getRight() != null){
                node = node.getRight();

                while(node != null){
                    stack.push(node);
                    node = node.getLeft();
                }
            }

            return result;
        }

    }

    public static void main(String[] args){


        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        //root.left.left

    }


}
