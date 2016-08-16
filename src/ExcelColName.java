/**
 * Created by siddimore on 7/21/16.
 */
public class ExcelColName {

    private int colNo;
    private StringBuilder colName;

    //Constructor
    public ExcelColName(int colNo){

        this.colNo = colNo;
        colName = new StringBuilder();
    }

    //Convert column number to column name
    public String Process(){
        int rem = 0;
        while(colNo > 0){

            rem = colNo%26;

            if(rem == 0){
                colName.append('Z');
                colNo = colNo / 26 -1;
            }
            else{
                char c = (char)('A' + (rem-1));
                colName.append(c);
                colNo = colNo /26;
            }

        }

        return colName.reverse().toString();
    }

    public static void main(String[] args){
        ExcelColName ex = new ExcelColName(705);
        System.out.println("Column number:" + ex.Process());
    }
}
