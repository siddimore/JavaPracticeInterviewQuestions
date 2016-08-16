/**
 * Created by MoreFamily on 4/25/2016.
 */
public class powerOfN {

    private int n;
    private int x;
    private int temp;

    public powerOfN(int x, int n){
        this.x = x;
        this.n = n;
    }

    public int compute(int x, int n){

        int temp = 1;

        if(n == 0)
            return 1;
        temp = compute(x, n/2);

        if(n%2 == 0)
            return temp * temp;
        else
            return temp*temp*x;
    }

    public static void main(String[] args){
        powerOfN pN = new powerOfN(2, 3);
        System.out.println("Power: " + pN.compute(2 ,4));
    }
}
