/**
 * Created by MoreFamily on 4/17/2016.
 */
public class studentview {
        public void printStudentDetails(String studentName, String studentRollNo) throws NullPointerException{

            if(studentName == null || studentRollNo == null){
                throw new NullPointerException("Elements cannot be null");
            }
            else {
                System.out.println("Student: ");
                System.out.println("Name: " + studentName);
                System.out.println("Roll No: " + studentRollNo);
            }
        }
}
