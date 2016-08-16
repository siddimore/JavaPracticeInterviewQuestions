/**
 * Created by siddimore on 6/17/16.
 */
public class BinarySearch {

    static int[] a = {1,2,3,4,5,6,7,8};

    public static boolean findElement(int x){

        int start = 0;
        int end = a.length-1;

        while(start<=end){

            int mid = (start+end)/2;
            if(a[mid] == x){
                return true;
            }
            else if(a[mid] > x){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return false;
    }

    public static int findElementRotate(int[] a, int x){

        int start = 0;
        int end = a.length -1;


        while(start<=end){

            int mid = (start+end)/2;

            if(a[mid] == x){
                return mid;
            }

            if(a[mid] >= a[start]) {
                if (a[mid] > x && a[start] <= x) { //check a[mid] is greater than value && a[start] is less than equal to x
                    end = mid - 1; //means first half is in increasing order
                } else {
                    end = mid + 1; //if here array has rotation in second half
                }
            }else{

                if(a[mid] < x && a[end] >= x){
                    start = mid +1 ; // means second half is in increasing order
                }
                else{
                    start = mid -1;
                }

            }
        }


        return -1;
    }

    public static void main(String[] args){

        System.out.println("Find element: " + findElement(2));
        System.out.println("Find element: " + findElementRotate(new int[]{10,11,12,1,2,3,4,5,6},2));

    }
}
