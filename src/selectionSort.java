/**
 * Created by MoreFamily on 4/16/2016.
 */
public class selectionSort {

    private static int[]  doSelectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;

    }

    private static char[] doReverse(String input){

        char[] arr = input.toCharArray();
        int start = 0;
        int end = arr.length -1;
        char temp = '\0';

        do{
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }while(start < end);

        return arr;
    }

    private static Integer getFirstChar(int index, char[] arr){
        for(int i= index; i < arr.length; i++)
            if(arr[i] != ' ')
                return i;
        return null;
    }

    private static Integer getLastChar(int index, char[] arr){
        for(int i= index; i < arr.length; i++)
            if(arr[i] == ' ')
                return i-1;
        return null;
    }

    private static char[] reverseWord(char[] arr){

        int firstIndex = getFirstChar(0, arr);
        int endIndex = getLastChar(firstIndex, arr);
        char temp = '\0';
        do{
        do{
            temp = arr[firstIndex];
            arr[firstIndex] = arr[endIndex];
            arr[endIndex] = temp;
            ++firstIndex;
            --endIndex;
        }while(firstIndex <= endIndex);

            firstIndex = getFirstChar(firstIndex, arr);
            endIndex = getLastChar(firstIndex, arr);
        }while(endIndex != arr.length);

        return arr;
    }

    public static void main(String[] args){
        int[] arr1 = {10,34,2,56,7,67,88,42};
        int[] result = doSelectionSort(arr1);
        char[] cArray = doReverse("Hello World");
        for(int i: result){
            System.out.println(i);
        }

//        for(char c: cArray){
//            System.out.println(c);
//        }

        cArray = reverseWord(cArray);

        for(char c: cArray){
            System.out.println(c);
        }
    }
}
