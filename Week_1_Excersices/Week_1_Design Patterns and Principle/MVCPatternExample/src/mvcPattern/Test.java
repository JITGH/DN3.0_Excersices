package mvcPattern;

public class Test {
	public static void main(String[] args) {
        // Create a Student model
        Student model = new Student("1", "John Doe", "A");

        // Create a Student view
        StudentView view = new StudentView();

        // Create a Student controller
        StudentController controller = new StudentController(model, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();    
	}
}
