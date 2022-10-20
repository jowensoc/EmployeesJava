package com.employees.models;

import java.util.ArrayList;

public class ServiceResponse {

    public ArrayList<Employee> employeeData;
    public Boolean success;
    public String logMessage;

    private void initialise(Boolean success, String logMessage, ArrayList<Employee> data) {
        setSuccess(success);
        setLogMessage(logMessage);
        setEmployeeData(data);
    }

    public ServiceResponse() {
        initialise(false, "", null);
    }

    public ServiceResponse(Boolean success) {
        initialise(success, "", null);
    }

    public ServiceResponse(Boolean success, String logMessage) {
        initialise(success, logMessage, null);
    }

    public ServiceResponse(Boolean success, String logMessage, ArrayList<Employee> data) {
        initialise(success, "", data);
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setLogMessage(String logMessage) {
        logMessage = logMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setEmployeeData(ArrayList<Employee> data) {
        employeeData = data;
    }

    public ArrayList<Employee> getEmployeeData() {
        return employeeData;
    }


}
