/**
 * Created by MoreFamily on 5/18/2016.
 */
public class medianTwoArrya {

    public static double median(int[] a, int[] b) throws NullPointerException{

        int[] m = null;
        if(a == null && b == null){
            throw new NullPointerException("Both Arrays cannot be null");
        }
        else{

            m = new int[a.length + b.length];

            for(int i = 0; i < a.length; i++){
                m[i] = a[i];
            }

            int k = a.length;
            for(int j = 0 ; j < b.length; j++){
                m[k+j] = b[j];
            }
        }

        //Execute Sort
        if(m != null) {
            for (int i = 0; i < m.length; i++)
                for(int j = i; j < m.length; j++){
                    if(m[j] < m[i]){
                        int temp = m[i];
                        m[i] = m[j];
                        m[j] = temp;
                    }
                }
        }

        for(int i= 0; i< m.length; i++){
            System.out.print(m[i] + " ");
        }

        System.out.println("Median is:");
        if(m.length%2 ==0){
            return m[m.length/2];
        }
        else{
            return (m[m.length/2] + m[m.length/2 +1])/2;
        }

    }

    public static void main(String[] args){
        System.out.print(medianTwoArrya.median(new int[]{ 12, 11, 15, 10, 20 }, new int[]{1,2,3,4}));
    }

    //private void sort()
}
