import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MoreFamily on 5/17/2016.
 */
public class regexDemo {

    public static void demo(String input){

        String content = input;
        String pattern = "(.*)(\\d+)(.*)";

        //Create a pattern object
        Pattern r = Pattern.compile(pattern);

        //Now Create Matcher Object
        Matcher m = r.matcher(input);

        if(m.find()){
            System.out.println("Found Value: " + m.group(0));
            System.out.println("Found Value: " + m.group(1));
            System.out.println("Found Value: " + m.group(2));
        }
        else{
            System.out.println("No Match");
        }
    }

    public void main(String[] args){
        regexDemo.demo("This order was placed for QT3000! OK?");
    }

}
