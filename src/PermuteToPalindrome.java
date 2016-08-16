import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoreFamily on 5/8/2016.
 */
public class PermuteToPalindrome {

    private String s;

    public List<String> getAl() {
        return al;
    }

    private List<String> al;
    public PermuteToPalindrome(String input){
        this.s = input;
        al = new ArrayList<>();
    }

    private void performPermute(){
        permute("",s);
    }

    //Create PErmutation of input String
    private void permute(String perm, String word){
        if(word.isEmpty()){
            if(isPalindrome(perm+word))
            al.add(perm+word);
        }
        else{
            for(int i=0; i<word.length(); i++){
                permute(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
            }
        }
    }

    //Check Palindrome
    private boolean isPalindrome(String input){
        char[] cArray = input.toCharArray();
        int length = cArray.length;

        for(int i =0; i < cArray.length/2; i++){
            if(cArray[i] != cArray[length - i - 1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        PermuteToPalindrome pp = new PermuteToPalindrome("edified");
        pp.performPermute();
        List<String> permutationList = pp.getAl();
        for(String s:permutationList){
            System.out.println(s);
        }

    }

}
