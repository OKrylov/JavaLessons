package pro.skypro.course2.spring.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skypro.course2.spring.exception.EmployeeNotFoundException;
import pro.skypro.course2.spring.model.Employee;
import pro.skypro.course2.spring.service.EmployeeService;

import java.util.*;

import static pro.skypro.course2.spring.service.impl.EmployeeServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeServiceMock.getAll()).thenReturn(List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2)
        ));
    }

    @Test
    public void test_min_salary() {
        Employee actualResult = out.getEmployeeWithMinSalary(DEPARTMENT_1);
        Employee expectedResult = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_min_salary_for_empty_department() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMinSalary(DEPARTMENT_2));
    }

    @Test
    public void test_max_salary() {
        Employee actualResult = out.getEmployeeWithMaxSalary(DEPARTMENT_1);
        Employee expectedResult = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_max_salary_for_empty_department() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMaxSalary(DEPARTMENT_2));
    }

    @Test
    public void test_get_employee_for_department() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_1);
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2)
        );
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    public void test_get_employee_for_empty_department() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_2);
        List<Employee> expected = Collections.emptyList();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_get_all_employee_by_department() {
        Map<Integer, List<Employee>> actual = out.getAllEmployeesByDepartment();
        Map<Integer, List<Employee>> expected = Map.of(
                DEPARTMENT_1, List.of(
                        new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                        new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2)
                )
        );
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_get_all_employee_by_department_no_departments() {
        Mockito.when(employeeServiceMock.getAll()).thenReturn(Collections.emptyList());
        Map<Integer, List<Employee>> actual = out.getAllEmployeesByDepartment();
        Map<Integer, List<Employee>> expected = Collections.emptyMap();
        Assertions.assertEquals(expected, actual);

    }


}
