package com.project.model;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<String> ShowInfo()
    {
        List<String> data = new ArrayList<>();
        data.add(String.valueOf(EmployeeID));
        return data;
    }
}
