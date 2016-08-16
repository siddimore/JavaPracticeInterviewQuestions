import java.util.*;

/**
 * Created by MoreFamily on 5/8/2016.
 */
public class stackSort {

    List<Item> l1 = new ArrayList<>();

    public stackSort(){

    }

    private List<Item> populateArrayList(){
        Random randomGenerator = new Random();

        for(int i=0; i< 10; i++){
            Item item = new Item(i,randomGenerator.nextDouble());
            l1.add(item);
        }

        //Collections.sort(l1);

        Collections.sort(l1, new itemComparator());


        return l1;
    }


    class itemComparator implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
            return (o2.number - o1.number);
        }
    }
     class Item implements Comparable<Item> {

         public Integer getNumber() {
             return number;
         }

         public void setNumber(Integer number) {
             this.number = number;
         }

         public Double getDistance() {
             return distance;
         }

         public void setDistance(Double distance) {
             this.distance = distance;
         }

         private Integer number;
         private Double distance;

         public String toString(){
             return new String(number + " " + distance);
         }

         public Item(Integer number, Double distance){
            this.number = number;
            this.distance = distance;
         }

        @Override
        public int compareTo(Item o) {
            return this.distance > o.distance ? -1 : 1;
        }
    }

    public static void main(String[] args){
        stackSort ss = new stackSort();
        List<Item> al = ss.populateArrayList();

        for(Item item: al){
            System.out.println("Item: " + item.toString());
        }
    }
}
