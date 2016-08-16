import java.util.Arrays;

/**
 * Created by MoreFamily on 5/29/2016.
 */
public class ArrayToZero {

    private  boolean[] row;
    private boolean[] column;
    private int[][] matrix;
    public ArrayToZero(int[][] matrix){
        this.matrix = matrix;
        row = new boolean[matrix.length];
        column = new boolean[matrix[0].length];
        Arrays.fill(row, false);
        Arrays.fill(column, false);
    }

    public void setToZero(){

        for(int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        setNullifyRow();
        setNullifyColumn();
    }

    private void setNullifyColumn(){

        for(int i=0; i<row.length; i++){
            if(row[i] == true) nullifyRow(i);
        }

    }

    private void setNullifyRow(){

        for(int i=0; i<row.length; i++)
            if(row[i] == true) nullifyRow(i);
    }

    private void nullifyRow(int row){

        for(int j= 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(int column){

        for(int i= 0; i < matrix.length; i++){
            matrix[i][column] = 0;
        }
    }

    public static void main(String[] args){

    }

}
