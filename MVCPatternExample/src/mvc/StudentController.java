package mvc;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update model data
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // Retrieve model data
    public String getStudentName() {
        return model.getName();
    }

    public String getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    // Display via view
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
