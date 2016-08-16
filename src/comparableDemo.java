import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by MoreFamily on 4/26/2016.
 */
public class comparableDemo {

    private int size;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String brand;

    public comparableDemo(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

//    @Override
//    public int compareTo(comparableDemo other){
//     if(this.getSize() > other.getSize())
//         return 1;
//        else if (this.getSize() < other.getSize())
//         return -1;
//        else return 0;
//    }

//    @Override
//    public int compare(comparableDemo other){
//        if(this.getSize() > other.getSize())
//            return 1;
//        else if (this.getSize() < other.getSize())
//            return -1;
//        else return 0;
//    }


   static class SizeComparator implements Comparator<comparableDemo> {

        @Override
        public int compare(comparableDemo o1, comparableDemo o2) {
            if(o1.getSize() > o2.getSize())
                return 1;
            else if (o1.getSize() < o2.getSize())
                return -1;
            else return 0;
        }
    }


    public static void main(String[] args){
        comparableDemo tv1 = new comparableDemo(55,"Samsung");
        comparableDemo tv2 = new comparableDemo(55,"Sony");
        comparableDemo tv3 = new comparableDemo(55,"Panasonic");

        ArrayList<comparableDemo> al = new ArrayList<>();
        al.add(tv1);
        al.add(tv2);
        al.add(tv3);

        Collections.sort(al, new SizeComparator());
    }
}
