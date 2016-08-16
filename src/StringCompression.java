import java.util.*;

/**
 * Created by MoreFamily on 5/29/2016.
 */
public class StringCompression {

    private String s;
    private Map<Character, Integer> charMap;
    private List<String> al;

    public StringCompression(String s){
        this.s = s;
        charMap = new HashMap<>();
        al = new ArrayList<>();
    }

    public String performCompression(){

        int count =0;
        char processingChar = '0';
        StringBuffer sB;

        for(int i=0; i<s.length(); i++) {

            if (i == 0) {
                processingChar = s.charAt(0);
                ++count;
            } else if (s.charAt(i) != processingChar) {
                sB = new StringBuffer();
                sB.append(processingChar);
                sB.append(count);
                al.add(sB.toString());
                processingChar = s.charAt(i);
                count = 0;
                ++count;
            } else {
                ++count;
            }
        }

        sB = new StringBuffer();
        sB.append(processingChar);
        sB.append(count);
        al.add(sB.toString());
        String retString = "";
        for(String s: al){
            retString = retString+s;
        }
        return retString;
    }

    public static void main(String[] args){
        StringCompression sC = new StringCompression("abccccbbbb");
        System.out.println("Compressed String: " + sC.performCompression());
    }

}
