import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by MoreFamily on 4/9/2016.
 */
public class largeArray {

    private String num1;
    private String num2;
    private char[] char1;
    private char[] char2;
    private int[] result;
    private boolean isNegative1 = false;
    private boolean isNegative2 = false;

    public largeArray(String s1, String s2) {
        this.num1 = s1;
        this.num2 = s2;
    }

    public int[] multiply(){
        if(num1.charAt(0) == '-') {
            isNegative1 = true;
            char1 = num1.substring(1).toCharArray();
        }
        else{
            char1 = num1.toCharArray();
        }

        if(num2.charAt(0) == '-') {
            isNegative2 = true;
            char1 = num2.substring(1).toCharArray();
        }
        else {
            char2 = num2.toCharArray();
        }

        result = new int[char1.length + char2.length];

        //Collections.reverse(Arrays.asList(char1));
        //Collections.reverse(Arrays.asList(char2));

        char1 = reverseChar(char1);
        char2 = reverseChar(char2);

        for(int i = 0; i < char1.length; i++)
            for(int j = 0; j<char2.length; j++){
                result[i+j] += (char1[i] - '0') * (char2[j] - '0');
                result[i + j + 1] = result[i+j]/10;
                result[i+j] = result[i+j] % 10;
            }

        Collections.reverse(Arrays.asList(result));

        result = reverseInt(result);
        return result;
    }

//    public int[] reverseMyArray(int[] a){
//        int start = 0;
//        int end = a.length;
//        int temp;
//        while(start<=end){
//            temp = a[start];
//            a[start] = a[end];
//            a[end] = temp;
//            ++start;
//            --end;
//
//
//        }
//
//    }
    public char[] reverseChar(char [] a){
        int start = 0;
        int end = a.length-1;
        char t;
        while(start<=end){
            t = a[start];
            a[start] = a[end];
            a[end] = t;
            ++start;
            --end;
        }

        return a;
    }

    public int[] reverseInt(int [] a){
        int start = 0;
        int end = a.length-1;
        int  t;
        while(start<=end){
            t= a[start];
            a[start] = a[end];
            a[end] = t;
            ++start;
            --end;
        }

        return a;
    }


//    public void reverse(){
//        int start = 0;
//        int end1 = char1.length-1;
//        int end2 = char2.length-1;
//        char t;
//        while(start<=end1){
//            t = char1[start];
//            char1[start] = char1[end1];
//            char1[end1] = t;
//            ++start;
//            --end1;
//        }
//
//        start = 0;
//        while(start<=end2){
//            t = char2[start];
//            char2[start] = char2[end2];
//            char2[end2] = t;
//            ++start;
//            --end2;
//        }
//    }

    public static void main(String[] args){
        largeArray LA = new largeArray("125", "125" +
                "");
        int[] prod = LA.multiply();
        System.out.print("Product of LA: ");
        for(int i: prod){
            System.out.print(i);
        }
    }






}
