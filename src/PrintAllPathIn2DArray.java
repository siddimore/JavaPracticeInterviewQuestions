///**
// * Created by siddimore on 6/20/16.
// */
//public class PrintAllPathIn2DArray {
//
//    static int[][] a;
//    static int rowCount;
//    static int colCount;
//    public static void Process(int[][] a){
//
//        rowCount = a.length;
//        colCount = a[0].length;
//    }
//
//    public static void printAll(int currRow, int currCol, String path){
//
//        if(currRow == rowCount -1){
//            for(int j =currCol; j<colCount; j++){
//                path+="-"+ a[currRow][j];
//            }
//            System.out.println(path);
//            return;
//        }
//
//        if(currCol == colCount-1){
//            for(int j =currRow; j<currRow-1; j++){
//                path+="-"+ a[j][currCol];
//            }
//            System.out.println(path);
//            return;
//        }
//
//        path = path + "-" + a[currRow][currCol];
//        printAll(currRow+1,currCol,path);
//        printAll(currRow,currCol+1,path);
//
//    }
//
//    public static void main(String[] args){
//
//        a = new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//        Process(a);
//        printAll(0,0,"");
//
//    }
//}


public class PrintAllPathIn2DArray {

    int rowCount;
    int colCount;
    int[][] arrA;

    public PrintAllPathIn2DArray(int arrA[][]) {
        this.arrA = arrA;
        rowCount = arrA.length;
        colCount = arrA[0].length;
    }

    public void printAll(int currentRow, int currentColumn, String path) {
        if (currentRow == rowCount - 1) {
            for (int i = currentColumn; i < colCount; i++) {
                path += "-" + arrA[currentRow][i];
            }
            System.out.println(path);
            return;
        }
        if (currentColumn == colCount - 1) {
            for (int i = currentRow; i <= rowCount - 1; i++) {
                path += "-" + arrA[i][currentColumn];
            }
            System.out.println(path);
            return;
        }
        path = path + "-" + arrA[currentRow][currentColumn];
        printAll(currentRow + 1, currentColumn, path);
        printAll(currentRow, currentColumn + 1, path);
        //	printAll(currentRow + 1, currentColumn + 1, path);
    }

    public int countRec(int[][] arrA, int currRow, int currCol){

        if(currRow == arrA.length-1 || currCol == arrA.length -1){

            return 1;
        }

        return countRec(arrA,currRow+1, currCol) + countRec(arrA,currRow, currCol+1);
    }

    public int countDP(){

        int result[][] = new int[arrA.length][arrA.length];
        result[0][0] =1;

        for(int i=0; i< result.length; i++)
            result[0][i] = 1;
        for(int j=0; j< result.length; j++)
            result[j][0] = 1;

        for(int i=1; i<result.length; i++)
            for(int j=1;j<result.length;j++)
                result[i][j] = result[i-1][j] + result[i][j-1];

        return result[arrA.length-1][arrA.length-1];
    }

    public static void main(String args[]) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, {7,8,9} };
        PrintAllPathIn2DArray p = new PrintAllPathIn2DArray(a);
        p.printAll(0, 0, "");
        System.out.println("Noof Paths: " + p.countDP());
    }

}