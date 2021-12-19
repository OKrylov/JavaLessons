package pro.skypro.course2.spring.service;

import pro.skypro.course2.spring.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, int salary);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();
}