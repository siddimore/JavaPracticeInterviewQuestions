/**
 * Created by siddimore on 6/19/16.
 */
public class printDiagonal {

    public void print(int[][] a){

        //print first half
        int row = 0;

        while(row < a.length){
            int col = 0;
            int tempRow = row;
            while(tempRow >= 0){
                System.out.print(a[tempRow][col] + " ");
                tempRow--;
                col++;
            }
            row++;
            System.out.println();
        }

        //print second half
        int colmn = 1;
        while(colmn < a.length){
            row = a.length-1;
            int tempCol = colmn;

            while(tempCol <= a.length-1){

                System.out.println(a[row][tempCol] + " ");
                tempCol--;
                row++;
            }
            ++colmn;
            System.out.println();
        }
    }

    public static void main(String[] args){

        printDiagonal ptD = new printDiagonal();
        int [][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ptD.print(a);


    }


}
