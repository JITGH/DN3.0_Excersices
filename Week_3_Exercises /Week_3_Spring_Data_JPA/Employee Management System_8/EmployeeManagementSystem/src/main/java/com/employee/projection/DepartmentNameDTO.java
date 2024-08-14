package com.employee.projection;


public class DepartmentNameDTO {

    private String name;

    // Constructor used in the query
    public DepartmentNameDTO(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter (optional)
    public void setName(String name) {
        this.name = name;
    }
}
