/**
 * Created by MoreFamily on 4/17/2016.
 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        student model  = retriveStudentFromDatabase();

        //Create a view : to write student details on console
        studentview view = new studentview();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static student retriveStudentFromDatabase(){
        student student = new student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}