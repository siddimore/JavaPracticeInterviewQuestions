import java.util.Arrays;

/**
 * Created by MoreFamily on 4/27/2016.
 */
public class panagram {

    private String s;
    private boolean[] bArray;
    public panagram(String s){
        this.s = s.toLowerCase();
        bArray = new boolean[26];
        Arrays.fill(bArray, false);
    }

    public boolean checkPanagram(){

        for(char c: s.toCharArray()) {
            if (c != ' ') {
                if (bArray[c - 'a'] == false) {
                    bArray[c - 'a'] = true;
                }
            }
        }

        for(boolean b: bArray){
            if(b == false)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        panagram p = new panagram("We promptly judged antique ivory buckles for the prize");
        if(p.checkPanagram())
            System.out.println("Panagranm");
        else
            System.out.println("Not Panagram");


    }


}
