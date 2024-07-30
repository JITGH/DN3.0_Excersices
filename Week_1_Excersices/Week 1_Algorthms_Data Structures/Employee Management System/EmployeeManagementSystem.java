import java.util.Arrays;
public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }
        //Add a Employee
    public void addEmployee(Employee employee) {
        if (count == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[count++] = employee;
    }
       //Search a Employee
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }
        //Traverse Employee array
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
        // Delete Employee Details
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[--count];
                employees[count] = null;
                return true;
            }
        }
        return false;
    }
}
