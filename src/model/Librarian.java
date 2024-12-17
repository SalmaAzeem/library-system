package src.model;
import src.model.Person;

public class Librarian extends Person {
    private int EmployeeID;

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Librarian(String name, int age, String gender, int employeeID) {
        super(name, age, gender);
        EmployeeID = employeeID;
    }
}
