/**
 * Created by siddimore on 6/20/16.
 */
public class StockSellBestTime {

    public static int getBestTime(int[] stocks){
        int profit = 0;
        int maxDiff = 0;
        int maxdiffSoFar = 0;

        for(int i=0; i< stocks.length; i++) {
            for (int j = i + 1; j < stocks.length; j++) {
                maxdiffSoFar = stocks[j] - stocks[i];

                if(maxdiffSoFar > maxDiff){
                    maxDiff = maxdiffSoFar;
                    maxdiffSoFar = 0;
                }
            }
        }

        return maxDiff;
    }

    public static void main(String[] args){
       System.out.println("Max profit: "  + getBestTime(new int[]{10,25,3,50,1}));
    }
}
