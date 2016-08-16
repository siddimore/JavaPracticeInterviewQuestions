import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by MoreFamily on 4/17/2016.
 */
public class occurence {

    private char[] cArray;
    private ArrayList<Character> result;
    private Map<Character, Integer> map;
    public  occurence(char[] input){
        this.cArray = input;
        map = new HashMap<>();
        result = new ArrayList<>();
    }

    private ArrayList<Character> parseArray(){

        for(char c: cArray){

            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                int i = map.get(c);
                map.put(c, ++i);
            }
        }

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry thisEntry = (Map.Entry) it.next();
            Object key = thisEntry.getKey();
            int value = (int)thisEntry.getValue();
            result.add((char)key);
            result.add((char)(value + '0'));
        }

        return result;
    }

    public static void main(String[] args){

        occurence oc = new occurence(new char[] {'a','a','a','a','b','b','b','c','c','d','d','e','f','f'});
        ArrayList<Character> result = oc.parseArray();

        for(char c: result){
            System.out.print(c);
        }
    }
}
