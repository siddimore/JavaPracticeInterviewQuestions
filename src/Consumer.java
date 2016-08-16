/**
 * Created by MoreFamily on 4/11/2016.
 */
public class  Consumer {
    Market m;
    Consumer(Market m){
        this.m = m;
    }

    void keepGetting(){
        while(true)
            m.get();
    }
}