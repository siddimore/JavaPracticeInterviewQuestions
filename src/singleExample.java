/**
 * Created by MoreFamily on 5/7/2016.
 */
public class singleExample {

    //Thread Safe singleton with Lazy initialization
        private static singleExample instance;

        private singleExample(){}

        public static synchronized singleExample getInstance(){
            if(instance == null){
                instance = new singleExample();
            }
            return instance;
        }
}
