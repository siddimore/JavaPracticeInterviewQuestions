import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by siddimore on 8/3/16.
 */
public class MaxNumberFromGivenNumber {

    private int number;
    private List<Integer> digitiList;

    public MaxNumberFromGivenNumber(int number){
        this.number = number;
        digitiList = new ArrayList<>();
    }

    public void process(){

        while(this.number != 0){
            digitiList.add(number%10);
            number = number /10;
        }

        Collections.sort(digitiList, Collections.reverseOrder());
        int number = 0;
        for(Integer i: digitiList){
            number += i;
            number = number * 10;
           System.out.print(i);
        }
        System.out.println(number);
    }

    public static void main(String[] args){
        MaxNumberFromGivenNumber mgb = new MaxNumberFromGivenNumber(123);
        mgb.process();
    }

}
