/**
 * Created by siddimore on 6/15/16.
 */
public class GCDRecursive {

    int num;

//    public GCDRecursive(int num){
//        this.num = num;
//    }

    public int findGCD(int n1, int n2){

        if(n2 == 0)
            return n1;

        return findGCD(n2, n1%n2);
    }

    public static void main(String[] args){

        GCDRecursive gcd = new GCDRecursive();
        System.out.println("Find Gcd: " +gcd.findGCD(300,24));

    }


}
