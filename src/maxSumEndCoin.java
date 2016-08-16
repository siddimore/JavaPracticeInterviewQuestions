import java.util.*;

/**
 * Created by MoreFamily on 4/16/2016.
 */
public class maxSumEndCoin {

    private Integer[] array;

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public List<Integer> getaL() {
        return aL;
    }

    private List<Integer> aL;

    public  maxSumEndCoin(Integer[] input){
        this.array = input;
        aL = new ArrayList<>();
        aL = new LinkedList(Arrays.asList(array));
    }

    private int pickCoin() throws IndexOutOfBoundsException{
        int start = 0;
        int end = aL.size()-1;
        int val = 0;

        if(start < end) {
            if (aL.get(start + 1) > aL.get(end - 1)) {
                val = aL.get(end);
                aL.remove(end);
                return val;
            } else {
                val = aL.get(start);
                aL.remove(start);
                return val;
            }
        }else throw new IndexOutOfBoundsException("Reached end of Array");
    }

    public static void main(String[] args){
        //Integer[] inputArray = new Integer[]{12,10,48, 10, 24,5};
        //Integer[] inputArray = new Integer[]{18,20, 15, 30, 10,14};//18 20 15 30 10 14
        Integer[] inputArray = new Integer[]{18,9, 2, 1, 5,14};
        maxSumEndCoin mCoin = new maxSumEndCoin(inputArray);
        List<Integer> mL = mCoin.getaL();
        try {
            do {
                if(mL.size() % 2 == 0) {
                    System.out.println("Player1 picks: " +mCoin.pickCoin());
                }else
                {
                    System.out.println("Player2 picks: " +mCoin.pickCoin());
                }
                mL = mCoin.getaL();
            } while (mL.size() > 0);
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Player2 picks Last Coin: " + mL.get(0));
        }
        //mCoin.setArray(inputArray);
    }
}
