package com.employees.services;

import com.employees.models.Employee;
import com.employees.models.ServiceResponse;

// TUTORIAL STUFF
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

// END TUTORIAL STUFF

public class JSONService implements IEmployeeService {

    private String filePath;

    private ArrayList<Employee> listOfEmployees;

    private String readFromJSON() {
        String fileContents = "";

        return fileContents;
    }

    private void writeJSON() {

    }

    public JSONService(String filePath) {
        this.listOfEmployees = new ArrayList<Employee>();
        setJSONFilePath(filePath);
        createMockList();
    }

    private void createMockList() {
        SaveEmployee(new Employee("Joe", "Bloggs", "Developer", "I.T."));
        SaveEmployee(new Employee("Joe", "Bloggs", "Developer", "I.T."));
        SaveEmployee(new Employee("Jane", "Bloggs", "Manager", "Management"));
        SaveEmployee(new Employee("Peter", "Bloggs", "Developer", "I.T."));
        SaveEmployee(new Employee("Velma", "Bloggs", "Interaction Designer", "I.T."));
    }

    public void setJSONFilePath(String filePath) {
        filePath = filePath;
    }

    @Override
    public ServiceResponse SaveEmployee(Employee obj) {
        ServiceResponse serviceResponse = new ServiceResponse(false);
        Boolean savedFlag = false;

        // FIND EMPLOYEE BY ID AND THEN UPDATE RECORD
        for (var emp: listOfEmployees) {
            if (obj.getEmployeeID() == emp.getEmployeeID()) {
                obj.setFirstName(emp.getFirstName());
                obj.setLastName(emp.getLastName());
                savedFlag = true;
                break;
            }
        }

        // NOT FOUND? add new record
        if (!savedFlag) {
            Integer newID = listOfEmployees.size() + 1;
            obj.setEmployeeID(newID);
            savedFlag = true;
            listOfEmployees.add(obj);
        }

        serviceResponse.setSuccess(savedFlag);
        serviceResponse.setLogMessage("Saved record. ID: " + obj.getEmployeeID().toString());

        return serviceResponse;
    }

    @Override
    public ServiceResponse DeleteEmployee(Employee obj) {
        ServiceResponse serviceResponse = new ServiceResponse(false);
        Boolean deletedFlag = false;
        String logMessage = "Deleted record";

        // FIND EMPLOYEE BY ID AND THEN UPDATE RECORD
        for (var emp: listOfEmployees) {
            if (obj.getFirstName().contains(emp.getFirstName()) && obj.getLastName().contains(emp.getLastName())) {
                obj.setFirstName(emp.getFirstName());
                obj.setLastName(emp.getLastName());
                deletedFlag = true;
                break;
            }
        }

        // NOT FOUND? add new record
        if (!deletedFlag) {
            logMessage = "Deleted Message";
        }

        serviceResponse.setSuccess(deletedFlag);
        serviceResponse.setLogMessage(logMessage);

        return serviceResponse;
    }

    @Override
    public ServiceResponse GetEmployee(String firstName, String lastname) {
        ServiceResponse serviceResponse = new ServiceResponse(false);
        Boolean foundFlag = false;
        String logMessage = "Did not find record";

        // FIND EMPLOYEE BY ID AND THEN UPDATE RECORD
        for (var emp: listOfEmployees) {
            if (emp.getFirstName().contains(firstName) && emp.getLastName().contains(lastname)) {
                serviceResponse.employeeData = new ArrayList<>();
                serviceResponse.employeeData.add(emp);
                foundFlag = true;
                break;
            }
        }

        // NOT FOUND? add new record
        if (!foundFlag) {
            logMessage = "Found record";
        }

        serviceResponse.setSuccess(foundFlag);
        serviceResponse.setLogMessage(logMessage);

        return serviceResponse;
    }
}
