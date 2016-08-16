import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * Created by MoreFamily on 3/31/2016.
 */
public class THanor {


    public static void move(int n, char from, char to, char inter)
    {
        if(n == 1)
        {
            System.out.println("Moving disc " + Integer.toString(n) + " from " + from + " to " +  to);
        }
        else
        {
            move(n-1, from, inter, to);
            System.out.println("Moving disc " + Integer.toString(n) + " from " + from + " to " +  to);
            move(n-1, inter, to, from);
        }
    }

    static  class binarySearch{

        private static int[] Array;
        private static int search(int[] A, int x)
        {
            Array = new int[A.length];
            Array = A;
            int lowerBound = 0;
            int upperBound = A.length;
            int midPoint = 0;
            while(lowerBound <= upperBound)
            {
                midPoint = (lowerBound + upperBound)/2;

                if(Array[midPoint] == x)
                {
                    System.out.println("Found Value");
                    return midPoint;
                }
                else if(Array[midPoint] < x)
                {
                    lowerBound = midPoint + 1;
                }
                else
                {
                    upperBound = midPoint - 1;
                }
            }

            return 0;
        }
    }
    public static void main(String[] args)
    {
        THanor.move(10, 'A' , 'C', 'B');
        binarySearch.search(new int[] {1,2,3,4,5,6,7,8,9}, 5);
    }


}

