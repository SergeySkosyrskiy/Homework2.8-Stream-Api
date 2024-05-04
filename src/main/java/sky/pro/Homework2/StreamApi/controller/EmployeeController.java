package sky.pro.Homework2.StreamApi.controller;


import org.springframework.web.bind.annotation.*;
import sky.pro.Homework2.StreamApi.model.Employee;
import sky.pro.Homework2.StreamApi.service.EmployeeService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmloyeeWithMaxSalary(@RequestParam Integer departmentId) {
        return employeeService.getEmloyeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmloyeeWithMinSalary(@RequestParam Integer departmentId) {
        return employeeService.getEmloyeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(@RequestParam Integer departmentId) {
        return employeeService.getAllEmployees(departmentId);
    }

    @GetMapping("/all-department")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments(@RequestParam Integer departmentId) {
        return employeeService.getAllEmployeesByDepartments(departmentId);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer deparmentId, @RequestParam int salary) {
        return employeeService.addEmployee(firstName, lastName, deparmentId, salary);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department, @RequestParam int salary) {
        return employeeService.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department, @RequestParam int salary) {
        return employeeService.findEmployee(firstName, lastName, department, salary);
    }


}


