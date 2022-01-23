package pro.skypro.course2.spring.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.skypro.course2.spring.exception.EmployeeExistsException;
import pro.skypro.course2.spring.exception.EmployeeNotFoundException;
import pro.skypro.course2.spring.model.Employee;
import pro.skypro.course2.spring.service.EmployeeService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.skypro.course2.spring.service.impl.EmployeeServiceTestConstants.*;

class EmployeeServiceImplTest {


    private EmployeeService out;

    @BeforeEach
    void setUp() {
        out = new EmployeeServiceImpl();
    }

    @Test
    void test_add() {
        Employee actualEmployee = out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void test_add_2_employees() {
        Employee actualEmployee = out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
        actualEmployee = out.add(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
        expectedEmployee = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void test_add_duplicate() {
        out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertThrowsExactly(EmployeeExistsException.class, () -> out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1));

    }

    @Test
    void test_remove_added_employee() {
        out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee actualEmployee = out.remove(FIRST_NAME_1, LAST_NAME_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void test_remove_not_existing_employee() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME_1, LAST_NAME_1));
    }

    @Test
    void test_find_added_employee() {
        out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee actualEmployee = out.find(FIRST_NAME_1, LAST_NAME_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void test_find_not_existing_employee() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME_1, LAST_NAME_1));
    }


    @Test
    void test_getAll_for_added_employee() {
        out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        out.add(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
        Collection<Employee> actual = out.getAll();
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2)
        );

        assertEquals(actual.size(), expected.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }
}