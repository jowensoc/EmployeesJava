package com.employees.services;

import org.junit.jupiter.api.Test;
import com.employees.models.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JSONServiceTest {

    private String jsonFilePath = "/Users/john.owens/Development/LabFiles/Employees.json";


    @Test
    void testSaveResponse() {
        JSONService service = new JSONService(jsonFilePath);

        Employee employee = new Employee("Test", "Test");

        var response = service.SaveEmployee(employee);
        assertNotNull(response);

    }

    @Test
    void testDeleteResponse() {
        JSONService service = new JSONService(jsonFilePath);

        Employee employee = new Employee("Test", "Test");

        ServiceResponse response = service.DeleteEmployee(employee);
        assertNotNull(response);

    }

    @Test
    void saveEmployee() {
        JSONService service = new JSONService(jsonFilePath);
        service.setJSONFilePath(jsonFilePath);

        Employee employee = new Employee("Joe", "Bloggs");

        var response = service.SaveEmployee(employee);
        assertTrue(response.getSuccess());
    }

    @Test
    void deleteEmployee() {
        JSONService service = new JSONService(jsonFilePath);
        service.setJSONFilePath(jsonFilePath);

        Employee employee = new Employee("Joe", "Bloggs");

        var response = service.DeleteEmployee(employee);
        assertTrue(response.getSuccess());
    }

    @Test
    void getEmployee() {
        JSONService service = new JSONService(jsonFilePath);
        service.setJSONFilePath(jsonFilePath);

        Employee employee = new Employee("Velma", "Bloggs");

        var response = service.GetEmployee(employee.getFirstName(), employee.getLastName());
        assertTrue(response.getSuccess());

        ArrayList<Employee> lst = response.getEmployeeData();
        var record = lst.get(0);

        assertTrue((record.getFirstName().contains(employee.getFirstName()) && record.getLastName().contains(employee.getLastName())));

    }

    @Test
    void getEmployeeRoles() {
        JSONService service = new JSONService(jsonFilePath);
        service.setJSONFilePath(jsonFilePath);

        Employee employee = new Employee("Velma", "Bloggs");

        var response = service.GetEmployee(employee.getFirstName(), employee.getLastName());

        ArrayList<Employee> lst = response.getEmployeeData();
        var record = lst.get(0);

        assertNotNull(record.getRoleName());
        assertNotNull(record.getDepartmentName());

    }
}