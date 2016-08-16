import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MoreFamily on 4/2/2016.
 */
public class firstNonRepeatedCharacter {

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    private String inputString;
    private Map<Character, Integer> charMap;

    public firstNonRepeatedCharacter(String input)
    {
        if(input == null){
            throw new RuntimeException("Input cannot be null");
        }
        else
        this.inputString = input;
        charMap = new LinkedHashMap<>();
    }

    public void parseString()
    {
        inputString = inputString.toLowerCase();
        char[] inputChar = inputString.toCharArray();

        for(int i=0; i < inputChar.length; i++)
        {
            System.out.println(inputChar[i]);
            if(charMap.containsKey(inputChar[i]))
            {
                int j = charMap.get(inputChar[i]);
                ++j;
                charMap.put(inputChar[i], j);
            }
            else {
                charMap.put(inputChar[i], 1);
            }
        }
    }

    //Iterator it = mp.entrySet().iterator();
    //Map.Entry<Integer, Integer> entry : map.entrySet()) {
    public char getNonRepeatedChar() throws Exception
    {
        for (Map.Entry<Character,Integer> entry : charMap.entrySet())
            {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }

            }
        throw new RuntimeException("didn't find any non repeated Character");

        //return '\0';
    }

    public static void main(String[] args)
    {
        firstNonRepeatedCharacter nonC = new firstNonRepeatedCharacter("Test me");
        nonC.parseString();
        try {
            System.out.println("First non repated character: " +nonC.getNonRepeatedChar());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
