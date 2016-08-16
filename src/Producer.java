/**
 * Created by MoreFamily on 4/11/2016.
 */
public class Producer {
    Market m;
    int i = 0;
    Producer(Market m){
        this.m = m;
    }

    void keepPutting(){
        while(true)
            m.put(i++);
    }
}

