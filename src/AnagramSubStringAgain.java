import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddimore on 6/14/16.
 */
public class AnagramSubStringAgain {

    static List<String> alS = new ArrayList<>();
    static List<Integer> alI = new ArrayList<>();

    //Compare inputString against anagramString
    public static List<Integer> process(String input, String anagram) throws Exception{

        if(input == null )
            throw new Exception("Cannot be null value");

        permute("",anagram);

        for(int i= 0; i < input.length(); i++){

            if(i+anagram.length() <= input.length()) {
                String s = input.substring(i, (i + (anagram.length())));
                if (alS.contains(s)) {
                    alI.add(i);
                }
            }else break;

        }

        return alI;
    }

    //Create ArrayList based on all permutations of word
    private static void permute(String perm, String word){

        if(word.isEmpty() && alS!= null){
            alS.add(perm + word);
        }
        else{

            for(int i=0; i< word.length(); i++){
                permute(perm + word.charAt(i), word.substring(0,i) + word.substring(i + 1, word.length()));
            }
        }
    }

    public static void main(String[] args){

        try {
            List<Integer> indexList = process("BACDGABCDA", "ABCD");
            for(Integer i: indexList){
                System.out.println("Index Anagram present: " + i);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
