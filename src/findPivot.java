/**
 * Created by siddimore on 6/15/16.
 */
public class findPivot {

    public static int process(int[] a){

        int i=0;
        int index = 0;
        do{
            if(a[i] > a[i+1] && (i+1 < a.length)){
                index = i+1;
                break;
            }
            ++i;
        }while(i<a.length);

        return index;
    }

    public static void main(String[] args){
        System.out.println(findPivot.process(new int[]{73,84,95,21,27,34}));
    }



}
