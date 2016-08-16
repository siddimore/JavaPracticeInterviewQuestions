import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoreFamily on 5/19/2016.
 */
public class swapstrings {

    String s1;
    String s2;

    public swapstrings(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    private List<String> swap(){

        s1 = s1 + s2;
        s2 = s1.substring(0,s1.length() - s2.length());
        s1 = s1.substring(s2.length());

        List<String> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);

        return sList;
    }

    public List<String> performSwap(){
        return swap();
    }

    public static void main(String[] args){
        swapstrings sS = new swapstrings("Test" , "Swap");
        for(String s: sS.performSwap())
        {
            System.out.println(s);
        }
    }
}
