import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 4/7/2016.
 */
public class multipleDupes {


    private Map<Integer, Integer>  map;

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    private int[] arr;

    public multipleDupes(int[] arr){
        this.arr = arr;
        map = new LinkedHashMap<>();
    }

    private void getDupes(){
        for(int a: arr){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }
            else{
                int i = map.get(a);
                map.put(a, ++i);
            }
        }
    }

    public static void main(String[] args){
        multipleDupes mD = new multipleDupes(new int[] {1,1,1,1,1,100000,100000,12,15,18,19});
        mD.getDupes();
        Iterator<Map.Entry<Integer, Integer>> it = mD.getMap().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getValue() > 1)
            System.out.println("Key: "+ entry.getKey() + " Value: " + entry.getValue());
        }
    }

}