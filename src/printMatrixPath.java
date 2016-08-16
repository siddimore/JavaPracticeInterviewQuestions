/**
 * Created by siddimore on 6/23/16.
 */
public class printMatrixPath {

    int rowCount;
    int colCount;
    int[][] arrA;
//    int right = 0;
//    int down = 0;

    public printMatrixPath(int[][]a){
        arrA = a;
        rowCount = a.length;
        colCount = a[0].length;
    }

    public void printAll(int currRow, int currCol, String Path){

        if(currRow == rowCount-1) {
            for (int i = currCol; i < colCount; i++) {
                Path += "-" + arrA[currRow][i];
            }
            System.out.println(Path);
            return;
        }
        if(currCol == colCount-1) {
            for (int i = currRow; i < rowCount; i++) {
                Path += "-" + arrA[i][currCol];
            }
            System.out.println(Path);
            return;
        }

        Path = Path  + arrA[currRow][currCol];
        printAll(currRow+1, currCol, Path);
        printAll(currRow,currCol+1, Path);
    }

    public int count(int[][]a, int row, int col){

        if(row == a.length-1 || col == a.length-1)
            return 1;

        return count(a,row+1,col) + count(a,row,col+1);
    }


    public void nonobstructionPath(int currRow, int currCol, String Path){

        if(currRow == rowCount-1) {
            for (int i = currCol; i < colCount; i++) {
                if(arrA[currRow][i] != -1)
                    Path +=   "row: " + currRow +  " -" + " col: " + i;
//                Path += "-" + arrA[currRow][i];
            }
            System.out.println(Path);
            return;
        }
        if(currCol == colCount-1) {
            for (int i = currRow; i < rowCount; i++) {
                //Path += "-" + arrA[i][currCol];
                if(arrA[i][currCol] != -1)
                    Path += "row: " + i + " -" + " col: " + currCol;
            }
            System.out.println(Path);
            return;
        }

        //Path = Path + "-" + arrA[currRow][currCol];
        nonobstructionPath(currRow+1, currCol, Path);
        nonobstructionPath(currRow,currCol+1, Path);
    }



    public static void main(String[] args){

        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] b = { { 1, -1, 1 }, { -1, -1, 1 }, { 1, 1, 1 } };
//        printMatrixPath p = new printMatrixPath(a);
//        p.printAll(0,0,"");
//        System.out.println("Count noof paths: " + p.count(a,0,0));
        printMatrixPath non = new printMatrixPath(b);
        non.printAll(0,0,"");
        non.nonobstructionPath(0,0,"");
//        System.out.println("Path noof Obstructions: " + p.noofObstruction(b,0,0));
    }


}
