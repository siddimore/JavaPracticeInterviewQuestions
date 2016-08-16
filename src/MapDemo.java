import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by MoreFamily on 5/17/2016.
 */
public class MapDemo {

    static Map<Integer, String> stringMap;

    public static void demo(){
        stringMap = new HashMap<>();
        System.out.println("Adding Enteries to Map");
        String s = "This is Map Demo! Hope you get the idea";
        String[] sArray = s.split(" ");
        int count = 0;
        for(String str: sArray)
        {
            stringMap.put(count,str);
            ++count;
        }

        System.out.println("Get Demo");
        //Get Demo
        for(int i= 0; i < count; i++){
            System.out.println("Value: " + stringMap.get(i));
        }

        //Iterator iterator = stringMap.iterator();




    }

}
