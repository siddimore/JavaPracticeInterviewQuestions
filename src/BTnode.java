/**
 * Created by MoreFamily on 4/9/2016.
 */
public class BTnode{
    public int getData() {
        return data;
    }

    private int data;

    public BTnode getLeft() {
        return left;
    }

    public void setLeft(BTnode left) {
        this.left = left;
    }

    public BTnode getRight() {
        return right;
    }

    public void setRight(BTnode right) {
        this.right = right;
    }

    private BTnode left;
    private BTnode right;

    public BTnode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}