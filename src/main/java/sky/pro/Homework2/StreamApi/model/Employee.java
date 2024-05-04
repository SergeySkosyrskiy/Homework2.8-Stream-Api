package sky.pro.Homework2.StreamApi.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Integer salary;
    private Integer departNum;

    public Employee(String firstName, String lastName, Integer departNum, Integer salary) {

        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.departNum = departNum;
        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getDepartNum() {
        return departNum;
    }

    public void setDepartNum(Integer departNum) {
        this.departNum = departNum;
    }

    public Integer getSalary() {
        return salary;
    }


    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(departNum, employee.departNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departNum);
    }

    @Override
    public String toString() {
        return "Имя - " + firstName +
                ", Фамилия - " + lastName +
                ", отдел: " + departNum +
                ", зарплата сотрудника: " + salary + " руб.";
    }
}