import java.util.*;

/**
 * Created by MoreFamily on 4/16/2016.
 */
public class nonRepeated {

    private Map<Character, Boolean> charMap;
    private Set<Character> dupeSet;
    private Set<Character> nonDupeSet;
    private char[] cArray;
    private String s;

    public nonRepeated() {
        dupeSet = new LinkedHashSet<>();
        nonDupeSet = new LinkedHashSet<>();
        charMap = new LinkedHashMap<>();
    }

    public Integer arraySol(String input){
        int[] arr = new int[26];
        int index = 0;
        cArray = input.toLowerCase().toCharArray();

        for(char c: cArray){
            index = c-'a';
            arr[index]  = ++arr[index];
        }

        for(int i: arr){
            if(i == 1)
                return i;
        }
        return null;
    }

    private Character getFirstEntry() {
        Iterator it = charMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (!(boolean) pair.getValue()) {
                return (char) pair.getKey();
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return null;
    }

    public char firstChar(String input) {
        cArray = input.toLowerCase().toCharArray();

        for (char c : cArray) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, false);
            } else {
                charMap.put(c, true);
            }
        }

        return getFirstEntry();
    }

    public static void main(String[] args){
        nonRepeated nR = new nonRepeated();
        System.out.println("First non repeated character: " +nR.firstChar("GeeksForGeeks"));
        System.out.println("First non repeated index: " +nR.arraySol("GeeksForGeeks"));
    }


}
