package sky.pro.Homework2.StreamApi.service;

import org.springframework.stereotype.Service;
import sky.pro.Homework2.StreamApi.exeption.EmployeeNotFoundException;
import sky.pro.Homework2.StreamApi.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = List.of(
            new Employee("Иван", "Иванов", 1, 15000),
            new Employee("Семён", "Семёнов", 2, 17000),
            new Employee("Дмитрий", "Дмитриев", 2, 12000),
            new Employee("Фёдор", "Фёдоров", 1, 18000));

//    private static final int MAX_EMPLOYEES = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.add(employee);
        return employee;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        boolean deleted = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.equals(newEmployee)) {
                employees.remove(i);
            }
        }
        return newEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employeeToFind = new Employee(firstName, lastName, department, salary);
        for (Employee employee : employees) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }


        //if (!employees.contains(employeeToFind.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
//        else {
//            return employees.get(Integer.parseInt(employeeToFind.getFullName()));
//        }
//    }

    @Override
    public Employee getEmloyeeWithMaxSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartNum().equals(departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));

    }

    @Override
    public Employee getEmloyeeWithMinSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartNum().equals(departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));

    }

    @Override
    public List<Employee> getAllEmployees(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartNum().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments(Integer departmentId) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartNum));
    }


};






