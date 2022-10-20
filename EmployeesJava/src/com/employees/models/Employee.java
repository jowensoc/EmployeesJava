package com.employees.models;

public class Employee {
    String firstName;
    String lastName;
    String roleName;
    String departmentName;
    Integer employeeID;
    Integer roleID;
    Integer departmentID;

    private void initialise(Integer employeeID, String firstName, String lastName, String roleName, String departmentName) {
        setFirstName(firstName);
        setLastName(lastName);
        setRoleName(roleName);
        setDepartmentName(departmentName);
        setRoleID(0);
        setDepartmentID(0);
        setEmployeeID(employeeID);
    }

    public Employee(String firstName, String lastName) {
        initialise(0, firstName, lastName, "No Job Role yet", "No Department Yet");
    }

    public Employee(String firstName, String lastName, String roleName) {
        initialise(0, firstName, lastName, roleName, "No Department Yet");
    }

    public Employee(String firstName, String lastName, String roleName, String departmentName) {
        initialise(0, firstName, lastName, roleName, departmentName);
    }

    public Employee(Integer employeeID, String firstName, String lastName, String roleName, String departmentName) {
        initialise(employeeID, firstName, lastName, roleName, departmentName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

}
