/**
 * Created by siddimore on 7/21/16.
 */
public class missingNumber {

    int[] array;
    int diff;
    public missingNumber(int[] array, int diff){
        this.array = array;
        this.diff = diff;
    }

    public int findMissingUtil(int low, int high, int diff){

        if(high <= low)
            return Integer.MAX_VALUE;

        int mid = low + (high -low)/2;

        if((array[mid+1]-array[mid])!= diff )
            return (array[mid]+diff);

        if(mid > 0 && (array[mid] -array[mid-1] != diff))
            return (array[mid-1] + diff);

        if(array[mid] == array[0] + mid*diff)
            return findMissingUtil(mid+1,high,diff);

        return findMissingUtil(low,mid-1, diff);
    }

    public static void main(String[] args){

        int[] array = {2,4,8,10,12,14};
        int diff = (array[array.length-1] - array[0]) / array.length;

        missingNumber mN = new missingNumber(array, diff);
        System.out.print("Mising Element: " +mN.findMissingUtil(0, array.length-1, diff));
    }

}
