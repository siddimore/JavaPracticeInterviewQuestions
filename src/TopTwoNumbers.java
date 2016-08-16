/**
 * Created by MoreFamily on 4/8/2016.
 */
public class TopTwoNumbers {

    private int[] arr;

    public int getTop1() {
        return top1;
    }

    private int top1;

    public int getTop2() {
        return top2;
    }

    private int top2 = 0;

    public TopTwoNumbers(int[] arr){
        this.arr = arr;
    }

    public void parseArray(){
        int temp;
        for(int i=0; i < arr.length; i++){
            if(i == 0) top1  = arr[i];
            else{
                if(arr[i] > top1){
                    temp = top1;
                    top1 = arr[i];
                    top2 = temp;
                }
                else if(arr[i] > top2){
                    top2 = arr[i];
                }
            }
        }
    }

    public static void main(String[] args){
        TopTwoNumbers tt = new TopTwoNumbers(new int[]{Integer.MAX_VALUE, 34, 21, 87, 92, 1});
        tt.parseArray();
        System.out.println("Top1:" + tt.getTop1() + " Top2: " + tt.getTop2());
    }

}
