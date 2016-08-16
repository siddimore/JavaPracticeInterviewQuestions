import java.util.*;

/**
 * Created by MoreFamily on 5/28/2016.
 */


//The longest Increas­ing Sub­se­quence (LIS) prob­lem is to find the length of the longest sub­se­quence
//        in a given array such that all ele­ments of the sub­se­quence are sorted in increas­ing order.
public class LongestIncreasingSeq {

public static List<Integer> Process(int[] inputArray){

    int longestSoFar = 0;
    List<Integer> longAL = new ArrayList<>();

    for(int i=0; i < inputArray.length; i++){

        if(inputArray[i] > longestSoFar){
            longestSoFar = inputArray[i];
            longAL.add(longestSoFar);
        }
    }

    return longAL;
}

    static Set<Character> tSet = new TreeSet<>();

    public static int returnCommonSequenceSum(String a, String b){

        if(a.length() == 0 || b.length() == 0)
            return 0;

        int lenA = a.length();
        int lenB = b.length();

        if(a.charAt(lenA -1) == b.charAt(lenB-1)){
            return 1 + returnCommonSequenceSum(a.substring(0, lenA-1),
                    b.substring(0, lenB -1));
        }else{
            return Math.max(returnCommonSequenceSum(a.substring(0, lenA-1),
                    b.substring(0, lenB)),returnCommonSequenceSum(a.substring(0, lenA),
                    b.substring(0, lenB-1)));
        }

        //return 0;
    }


    public static int returnSeq(List<Integer> a, List<Integer> b){

        if(a.size() == 0 || b.size() ==0)
            return 0;

        int lenA = a.size();
        int lenB = b.size();

        if(a.get(lenA - 1) == b.get(lenB-1))
            return 1 + returnSeq(a.subList(0,a.size()-1), b.subList(0,b.size()-1));
        else{
            return Math.max(returnSeq(a.subList(0,a.size()-1),b.subList(0,b.size())),returnSeq(a.subList(0,a.size()),b.subList(0,b.size()-1)));
        }


    }

    public static void prLongestIncreasingSeq(Integer[] inputArray){

        Integer[] a;
        a = new Integer[inputArray.length];

        for(int i=0; i<inputArray.length; i++)
            a[i] = inputArray[i];

        List<Integer> unsortedList = Arrays.asList(a);
        Arrays.sort(inputArray);
        List<Integer> sortedList = Arrays.asList(inputArray);
        System.out.println("Longest int seq: " + returnSeq(unsortedList,sortedList));



//        int[] unSortedA = Arrays.copyOf(inputArray,inputArray.length);
//        Arrays.sort(inputArray);
//        String unsortedString = "";
//        String sortedString = "";
//        for(Integer i: unSortedA){
//            unsortedString += i;
//        }
//
//        for(Integer i: inputArray){
//            sortedString += i;
//        }
////        String unSortedS = unSortedA.toString();
////        String sortedS = inputArray.toString();
//        System.out.println("Longest int seq: " + returnCommonSequenceSum(unsortedString,sortedString));
//        System.out.println();
//        for(Character c: tSet)
//            System.out.print(c + " ");
    }

    public static void main(String[] args){
                 //0,1,3,4,5,6,9
        //int X[] = {3,1,5,0,6,4,9};
        Integer[] X = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        //List<Integer> al = Process(X);
        prLongestIncreasingSeq(X);
        //List<Integer> al = Process(new int[]{ 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 });
       // System.out.println(al.toString());
    }
}
