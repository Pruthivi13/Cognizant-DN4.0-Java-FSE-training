package mvc;

public class Main {
    public static void main(String[] args) {
        // Create model and view
        Student student = new Student("Pruthiviraj", "S123", "A");
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        System.out.println("\nUpdating student details...\n");

        // Update data via controller
        controller.setStudentName("Raj Sahu");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
