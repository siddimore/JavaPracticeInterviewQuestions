/**
 * Created by MoreFamily on 4/28/2016.
 */
public class reverse {

    static StringBuilder newString = new StringBuilder();
    //example: Hello this is my World
    //returns: DLROW ym si siht OLLEH
    public static String ReverseStringWithOddUppers(String str) throws NullPointerException {

        char[] modArray;
        if(str == null){
            throw new NullPointerException("String is null");
        }
        else {
            String modifiedString = capitalizeOddWords(str);
            //modString: HELLO this is my WORLD
            modArray  = modifiedString.toCharArray();


            int start = 0;
            int end = modArray.length - 1;
            char temp;
            while (start <= end) {
                temp = modArray[start];
                modArray[start] = modArray[end];
                modArray[end] = temp;
                ++start;
                --end;
            }
        }

        return new String(modArray);
    }

    //input= Hello this is my World
    public static String capitalizeOddWords(String input){
        String[] stArray = input.split(" ");
        int count = stArray.length;
        newString = new StringBuilder();
        for(String s: stArray){

            if(s.length() % 2 != 0){
                newString.append(s.toUpperCase());
            }
            else{
                newString.append(s);
            }
            --count;
            if(count != 0)
            newString.append(" ");
        }

        return  newString.toString();
    }

    public static void main(String[] args){
        //Valid input
        System.out.println(ReverseStringWithOddUppers("Hello this is my World"));
        //Valid input
        System.out.println(ReverseStringWithOddUppers(" this is my World"));
        //Empty String
        System.out.println(ReverseStringWithOddUppers(""));
        //Empty String
        //System.out.print(ReverseStringWithOddUppers(null));
        //AlphaNumeric
        System.out.println(ReverseStringWithOddUppers("123 This world my"));
        //numeric String
        //Empty String
        System.out.println(ReverseStringWithOddUppers("1234"));
        //String with special characters
        System.out.println(ReverseStringWithOddUppers("%$#@1234 This world"));
        System.out.println(ReverseStringWithOddUppers("A"));
        System.out.println(ReverseStringWithOddUppers("AB\0"));
        System.out.println(ReverseStringWithOddUppers("Hello this is my World Hello this is my World Hello this is my World "));
        System.out.println(ReverseStringWithOddUppers("non english character"));
        System.out.println(ReverseStringWithOddUppers("-123 Hello world"));
        System.out.println(ReverseStringWithOddUppers("He worl"));
        System.out.println(ReverseStringWithOddUppers("Hel world"));



    }
}
