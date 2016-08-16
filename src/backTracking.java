import java.util.HashSet;
import java.util.Set;

/**
 * Created by MoreFamily on 4/23/2016.
 */
public class backTracking {

    public static boolean find (String s, HashSet<String> dict, String answer){

        if(s.length() == 0){
            System.out.println(answer);
            return true;
        }
        else{
            int index = 0;
            String word = "";
            while(index < s.length()){
                word += s.charAt(index);
                if(dict.contains(word)){
                    if(find(s.substring(index+1), dict, answer + word + " ")){
                        return  true;
                    }
                    else index++;
                }
                else index++;
            }
            return  false;
        }
    }

    public static void main(String[] args){

        HashSet<String> hs = new HashSet<String>();
        hs.add("this");
        hs.add("is");
        hs.add("sumit");
        hs.add("jain");
        hs.add("the");
        hs.add("problem");
        String s = "problemtheam";
        String answer = new String();
        find(s, hs, answer);
        System.out.println(answer);

    }
}
