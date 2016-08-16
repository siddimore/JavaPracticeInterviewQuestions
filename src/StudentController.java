/**
 * Created by MoreFamily on 4/17/2016.
 */

public class StudentController {
    private student model;

    public void setView(studentview view) {
        this.view = view;
    }

    public void setModel(student model) {
        this.model = model;
    }

    private studentview view;

    public StudentController(student model, studentview view){
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo(){
        return model.getRollNo();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
