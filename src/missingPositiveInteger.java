import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by siddimore on 6/13/16.
 */
public class missingPositiveInteger {

    Set<Integer> intSet;
    int[]a;
    int lastDigit = 0;
    public missingPositiveInteger(int[] a){

        this.a = a;
        intSet = new TreeSet<>();
    }

    private int process(){

        for(int i =0; i<a.length; i++ )
        intSet.add(a[i]);

        int currentNo = 0;
        int prevNo = 0;
        int j =0;

        //Iterate over Set
        for (int s : intSet) {

            //First Time Current and Previos Number are Same
            if(j == 0) {
                currentNo = s;
                prevNo = s;
            }
            else {
                prevNo = currentNo;
                currentNo = s;
                if (currentNo - prevNo != 1) {
                    return prevNo + 1;
                }
            }
            ++j;
        }

        return 0;
    }

//    private static int processArray(int[] a){
//
//    }

    public static void main(String[] args){
        int[]a = new int[]{0,3,4,6,2,1};
        missingPositiveInteger mP = new missingPositiveInteger(a);

        System.out.println("Missing integer: " + mP.process());
    }
}
