import java.util.ArrayList;

/**
 * Created by MoreFamily on 4/14/2016.
 */
public class LCS {
    private char[] A;
    private char[] B;

    public LCS(){
        //A = input1.toCharArray();
        //B = input2.toCharArray();
    }

    public void setString(String input1, String input2){A = input1.toCharArray();
        B = input2.toCharArray();
    }

    public ArrayList<Character> LCSCheck(){

        int l1 = A.length;
        int l2 = B.length;
        int inorder = 0;
        ArrayList<Character> al = new ArrayList<>();

        if(l1> l2){
            for(int i=0; i < l1; i++){
                for(int j=0; j < l2; j++){
                    if(A[i] == B[j]){
                        if((!al.contains(A[i]) && i>= inorder)){
                            inorder = j;
                            al.add(A[i]);
                            //break;
                        }
//                        else{
//                            return null;
//                        }
                    }
                }
            }
        }else{
            for(int i=0; i < l2; i++){
                for(int j=0; j < l1; j++){
                    if(B[i] == A[j]){
                        if((!al.contains(B[i]) && i>= inorder)){
                            inorder = j;
                            al.add(B[i]);
                            //break;
                        }
                        else{
                            //return null;
                        }
                    }
                }
            }
        }


        return al;
    }


}
