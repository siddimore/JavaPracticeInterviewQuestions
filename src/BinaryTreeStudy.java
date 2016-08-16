import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by siddimore on 7/19/16.
 */
public class BinaryTreeStudy {

    private BSTNode root;

    public BinaryTreeStudy(){
        root = null;
    }

    private boolean isEmpty(){
        return  root == null;
    }

    public void insert(int data){

        root = insert(root,data);

    }

    private BSTNode insert(BSTNode n, int data) {

        if (n == null) {
            return n = new BSTNode(data);
        } else if (n.getData() >= data) {
            n.left = insert(n.left, data);
        } else {
            n.right = insert(n.right, data);
        }

        return null;
    }

    public void delete(int k){
        if(isEmpty())
            System.out.println("Tree is Empty!!");

        BSTNode nFoundNode = find(k);


    }

    public BSTNode find(int k){
        return find(root, k);
    }

    public BSTNode find(BSTNode n, int k){

        boolean bFound = false;

        while(n!= null && !bFound){

            int rVal = n.getData();

            if(rVal == k){
                bFound = true;
                return n;
            }
            else if(rVal < k){
                n = n.getRight();
            }
            else n = n.getLeft();
        }
        return null;
    }



    public int countNodes(){
        return countNodes(root);
    }

    public int countNodes(BSTNode n) {

        if (n == null)
            return 0;

        int size = 0;
        Queue<BSTNode> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {

            BSTNode node = q.remove();
            ++size;
            System.out.println("Data: " + node.getData());

            if(node.getLeft() != null)
                q.add(n.getLeft());

            if(node.getRight() != null)
                q.add(n.getRight());
        }
        return size;
    }

    BSTNode inOrderSuccessorParentNode(BSTNode root, BSTNode n)
    {
        //check if right node is null
        if(n.right != null)
            return minValue(n.right);

        //step2
        BSTNode p = n.parent;
        while(p!=null && n == p.right){
            n = p;
            p = p.parent;
        }
        return p;
    }

    BSTNode minValue(BSTNode node){

        BSTNode current = node;
        while(current.getLeft()!=null)
            current = current.getLeft();

        return current;
    }


    BSTNode inorderSuccessor(BSTNode root, BSTNode n){

        //step1 of algorithm
        if(n.getRight() != null)
            return minValue(n.getRight());

        BSTNode succ = null;

        while(root!=null){

            if(n.getData() < root.getData()){

                succ = root;
                root = root.getLeft();
            }
            else if (n.getData() > root.getData()){
                root = root.getRight();
            }
            else break;

        }

        return succ;
    }

    BSTNode LowestCommonAncestor(BSTNode root, BSTNode n1, BSTNode n2){

        if(root == null)
            return null;

        if(root.getData() > n1.getData() && root.getData() > n2.getData()){
            return LowestCommonAncestor(root.getLeft(), n1,n2);
        }

        if(root.getData() < n1.getData() && root.getData() < n2.getData()){
            return LowestCommonAncestor(root.getRight(),n1,n2);
        }

        return root;
    }


    void inOrderTraversal(BSTNode root){
        if(root == null)
            return ;

        Stack<BSTNode> stack = new Stack<>();
        BSTNode node = root;

        while(node != null){
            stack.push(node);
            node = node.getLeft();
        }

        while(stack.size() > 0){

            node = stack.pop();
            System.out.println(node.getData() + "");
            if(node.getRight() != null){
                node = node.getRight();

                while(node !=null){
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }
    }

}

