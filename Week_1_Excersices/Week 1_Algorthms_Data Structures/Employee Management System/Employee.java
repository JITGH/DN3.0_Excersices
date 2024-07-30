

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double Salary;

    public Employee(String employeeId, String name, String position, double Salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.Salary = Salary;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return this.Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    @Override
    public String toString() {
        return
        "Employee ID: " +employeeId +"\n"+ 
        "Name: " + name +"\n"+ 
        "Position: " + position +"\n"+ 
        "Salary: " + Salary+"\n";
    }


}
