/**
 * Created by MoreFamily on 4/7/2016.
 */
public class numCompare {

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    private int[] arr;

    public int getLargest() {
        return largest;
    }

    private int largest =0;

    public int getSmallest() {
        return smallest;
    }

    private int smallest =0;

    public numCompare()
    {
        arr = new int[]{15,100,1,1000,7};
    }

    public void getSmallestLargest()throws NullPointerException{

        if(arr == null) throw new NullPointerException("Array is null");
        else {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {

                    largest = smallest = arr[i];
                } else if (arr[i] > largest) {
                    largest = arr[i];
                } else if (arr[i] < smallest) {
                    smallest = arr[i];
                }
            }
        }
    }



    public static void main(String[] args){
        numCompare n = new numCompare();
        n.getSmallestLargest();
        System.out.println("largest: " + n.getLargest());
        System.out.println("smallest: " + n.getSmallest());
        n.setArr(new int[]{-1,-2,-3,-100});
        n.getSmallestLargest();
        System.out.println("largest: " + n.getLargest());
        System.out.println("smallest: " + n.getSmallest());
        n.setArr(null);
        n.getSmallestLargest();
    }

}
