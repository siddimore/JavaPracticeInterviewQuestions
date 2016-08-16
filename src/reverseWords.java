/**
 * Created by MoreFamily on 4/27/2016.
 */
public class reverseWords {

    String s;

    public reverseWords(String s){
        this.s = s;
    }

    public void reverseString(){
        char[] cArray = s.toCharArray();
        int end = cArray.length-1;
        int start = 0;
        char temp;
        while(start != end){
            temp =  cArray[start];
            cArray[start] = cArray[end];
            cArray[end] = temp;
            ++start;
            --end;
        }

        s = new String(cArray);
    }

    public String reverseEachWord(){
        reverseString();
        String[] words = s.split(" ");
        String reverseString = "";
        StringBuffer sb = new StringBuffer();
        for(String w: words){
            String reverseWord = "";
            for(int i =w.length() -1; i >= 0; i--){
                reverseWord = reverseWord + w.charAt(i);
            }

            reverseString = reverseString + reverseWord + " " ;
        }

        return reverseString;
    }

    public static void main(String[] args){
        reverseWords rW = new reverseWords("I am good");
        System.out.println("String after reversing words: " + rW.reverseEachWord());
    }
}
