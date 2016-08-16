/**
 * Created by MoreFamily on 4/10/2016.
 */
public class getproductExceptIndex {

    private int[] arr;
    private int count;
    private int index;

    public getproductExceptIndex(int[] arr){
        this.arr = arr;
        count = arr.length;
        index = 0;
    }

    public int[] multiply(){
        int[] result = new int[count];
        for(int i=0; i< count; i++)
            result[i] = 1;


        while(index <= count-1){
            for(int i =0; i <=arr.length-1; i++){
                if(i != index){
                    result[index]*=arr[i];
                }
            }
            ++index;
        }

        return result;
    }

    public static void main(String[] args){
        getproductExceptIndex gp = new getproductExceptIndex(new int[]{1, 7, 3, 4});
        int[] resultArr = gp.multiply();
        for(int i: resultArr){
            System.out.println(i);
        }
    }


}
