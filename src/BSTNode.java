/**
 * Created by MoreFamily on 3/10/2016.
 */
public class BSTNode {
    BSTNode left, right, parent;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getParent()
    {
        return parent;
    }

    public BSTNode getRight() {
        return right;
    }

    public BSTNode getLeft() {
        return left;
    }

    int data;

    public BSTNode()
    {
        left = null;
        right = null;
        parent = null;
        data = 0;
    }

    public BSTNode(int Val)
    {
        left = null;
        right = null;
        parent = null;
        data = Val;
    }

    public void setLeft(BSTNode n)
    {
        left = n;
    }

    public void setRight(BSTNode n)
    {
        right = n;
    }

    public void setParent(BSTNode n){
        parent = n;
    }
}
