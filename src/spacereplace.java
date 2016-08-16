/**
 * Created by MoreFamily on 4/23/2016.
 */
public class spacereplace {

    public static String replace(String s1){
        char[] cArray = s1.toCharArray();
        char[] cNewArray = null;
        int length = cArray.length;
        int spaceLength = 0;

        for(int i=0; i < cArray.length; i++){
            if(cArray[i] == ' '){
                ++spaceLength;
            }
        }

        int newLength = cArray.length + 2*spaceLength;
        cNewArray = new char[newLength];

        length = length-1;
        while(length >=0){

            if(cArray[length] != ' '){
                cNewArray[newLength-1] = cArray[length];
                --length;
                --newLength;
            }
            else{
                cNewArray[newLength-1] = '0';
                cNewArray[newLength -2] = '2';
                cNewArray[newLength -3] = '%';
                newLength = newLength -3;
                --length;
            }

        }

        return new String(cNewArray);
    }

    public static void main(String[] args){
        String s = spacereplace.replace("I am Siddharth More");
        System.out.println(s);

    }

}
