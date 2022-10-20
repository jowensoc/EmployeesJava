package com.employees.services;

import com.employees.models.Employee;
import com.employees.models.ServiceResponse;

public interface IEmployeeService {
    ServiceResponse SaveEmployee(Employee obj);
    ServiceResponse DeleteEmployee(Employee obj);
    ServiceResponse GetEmployee(String firstName, String lastName);


}
