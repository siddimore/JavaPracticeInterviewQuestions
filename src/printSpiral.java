/**
 * Created by siddimore on 6/21/16.
 */
public class printSpiral {

    public static void printSpiral(int[][] a){

        int i, k =0,l=0;
        int m = a.length;
        int n = a.length;

        /*
        k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator*/


        while(k < m && l < n){

            //print first rown from remaining rows
            for(i=l; i<n; i++){
                System.out.print(a[k][i]);
            }
            k++;

            //print last colmn from remaining colmns
            for(i = k; i<m; i++)
            {
                System.out.print(a[i][n-1]);
            }

            n--;

            if(k<m){
                for(i = n-1; i>=1; i--){
                    System.out.print(a[m-1][i]);
                }
                m--;
            }

            if(l<n){
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(a[i][l]);
                }
                l++;
            }

        }

    }

    public static void main(String[] args){
        int[][] a =   { {1,  2,  3},
                        {4,  5,  6},
                        {7,  8,  9}
                      };
        printSpiral(a);
    }



}
