import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MoreFamily on 4/9/2016.
 */
public class BinaryTree {

    private int size = 0;

    public BTnode getRoot() {
        return root;
    }

    public void setRoot(BTnode root) {
        this.root = root;
    }

    BTnode root;

    public BinaryTree(){
        root = null;
    }

    private void BFS(BTnode node){
        Queue<BTnode> q = new LinkedList<>();

        if(node == null)
            return;

        q.add(node);

        while(!q.isEmpty()){
            BTnode n = (BTnode) q.remove();
            ++size;
            System.out.println("Data: " + n.getData());

            if(n.getLeft() != null)
                q.add(n.getLeft());

            if(n.getRight() != null)
                q.add(n.getRight());
        }
    }

    private int BFSH(BTnode node){
        Queue<BTnode> q = new LinkedList<>();
        int size = 0;
        if(node == null)
            return 0;

        q.add(node);

        while(!q.isEmpty()){
            BTnode n = (BTnode) q.remove();
            ++size;
            System.out.println("Data: " + n.getData());

            if(n.getLeft() != null)
                q.add(n.getLeft());

            if(n.getRight() != null)
                q.add(n.getRight());
        }
        return size;
    }


    private int heightBFS(BTnode node){

        if(node == null)
            return 0;

        return 1+ Math.max(BFSH(node.getLeft()),BFSH(node.getRight()));
    }

    private int height(BTnode node){

        if(node == null){
            return 0;
        }

        return 1+ Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean isBalance(BTnode n){
        int lh;
        int rh;

        if(n == null)
            return true;

        lh = height(n.getLeft());
        rh = height(n.getRight());

        if(Math.abs(lh - rh) <=1 && isBalance(n.getLeft()) && isBalance(n.getRight())){
            return true;
        }

        return false;
    }

    private int getHeight(BTnode node){
        if (node== null)
            return 0;
        else
        {
        /* compute the height of each subtree */
            int lheight = getHeight(node.getLeft());
            int rheight = getHeight(node.getRight());

        /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    private void givenLevel(BTnode node, int level){
        if(node == null){
            return;
        }
        if(level == 1)
                System.out.println("Value: " + node.getData());
        if(level > 1){
            givenLevel(node.getLeft(), level -1);
            givenLevel(node.getRight(), level -1);
        }
    }

    public void printLevelOrder(BTnode root){
        int h = getHeight(root);
        int i;
        for (i=1; i<=h; i++)
            givenLevel(root, i);
    }

    private void printnodeKDistance(BTnode n, int k){
        if(root == null)
            return;
        if(k == 0){
            System.out.print(n.getData() + " ");
        }
        else{
            printnodeKDistance(n.getLeft(), k-1);
            printnodeKDistance(n.getRight(), k-1);
        }
    }

    private boolean isBST(BTnode n, int min, int max){

        if(n == null)
            return true;

        if(n.getData() < min || n.getData() > max)
        return false;

        return  isBST(n.getLeft(), min, n.getData()-1) || isBST(n.getRight(),
                n.getData()+1, max);
    }

    public static void main(String[] args){

        BinaryTree bT = new BinaryTree();

        BTnode root = bT.getRoot();
        root = new BTnode(1);
        root.setLeft(new BTnode(2));
        root.setRight(new BTnode(3));
        root.getLeft().setLeft(new BTnode(4));
        root.getLeft().setRight(new BTnode(5));
        System.out.println("Height of Binary tree: " + bT.getHeight(root));
        System.out.println("Height of Binary tree BFS: " + bT.heightBFS(root));

        bT.printLevelOrder(root);
        bT.BFS(root);
        System.out.println("Size of Binary tree: " + bT.size);
    }


}
