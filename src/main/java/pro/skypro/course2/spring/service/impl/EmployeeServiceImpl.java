package pro.skypro.course2.spring.service.impl;

import org.springframework.stereotype.Service;
import pro.skypro.course2.spring.exception.EmployeeExistsException;
import pro.skypro.course2.spring.exception.EmployeeNotFoundException;
import pro.skypro.course2.spring.model.Employee;
import pro.skypro.course2.spring.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new LinkedHashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        String key = getKey(employee);

        if (employees.containsKey(key)) {
            throw new EmployeeExistsException();
        }

        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        Employee deletedValue = employees.remove(getKey(employee));
        if (deletedValue == null) {
            throw new EmployeeNotFoundException();
        }

        return deletedValue;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Set.copyOf(employees.values());
    }

    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getLastName());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + "_" + lastName;
    }
}