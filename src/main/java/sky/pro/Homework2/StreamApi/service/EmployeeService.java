package sky.pro.Homework2.StreamApi.service;

import sky.pro.Homework2.StreamApi.exeption.EmployeeNotFoundException;
import sky.pro.Homework2.StreamApi.exeption.EmployeeAlreadyAddedException;
import sky.pro.Homework2.StreamApi.exeption.EmployeeStorageIsFullException;
import sky.pro.Homework2.StreamApi.model.Employee;


import java.util.List;
import java.util.Map;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

//    Employee findEmployee(String name, String lastName) throws EmployeeNotFoundException;


    Employee findEmployee(String firstName, String lastName, int department, int salary);


    Employee getEmloyeeWithMaxSalary(Integer departmentId);

    Employee getEmloyeeWithMinSalary(Integer departmentId);

    List<Employee> getAllEmployees(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeesByDepartments(Integer departmentId);
}

