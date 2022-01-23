package pro.skypro.course2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.skypro.course2.spring.service.CalculatorService;
import pro.skypro.course2.spring.service.impl.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplTest {

    private CalculatorService out;

    @SuppressWarnings("unused")
    private static Stream<Arguments> sumTestParams() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(5, 0, 5),
                Arguments.of(5, -2, 3)
        );
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> subtractTestParams() {
        return Stream.of(
                Arguments.of(2, 2, 0),
                Arguments.of(5, 0, 5),
                Arguments.of(2, 5, -3)
        );
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(5, 0, 0),
                Arguments.of(2, -5, -10)
        );
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(2, 2, 1),
                Arguments.of(0, 5, 0),
                Arguments.of(2, 5, 0)
        );
    }

    @BeforeEach
    public void init() {
        this.out = new CalculatorServiceImpl();
    }

    @Test
    public void test_sum_valid() {
        int result = out.sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void test_sum_with_zero() {
        int result = out.sum(2, 0);
        assertEquals(2, result);
    }


    @Test
    public void test_subtract_valid() {
        int result = out.subtract(3, 2);
        assertEquals(1, result);
    }

    @Test
    public void test_subtract_with_negative_result() {
        int result = out.subtract(2, 5);
        assertEquals(-3, result);
    }

    @Test
    public void test_multiply_valid() {
        int result = out.multiply(2, 5);
        assertEquals(10, result);
    }

    @Test
    public void test_multiply_on_zero() {
        int result = out.multiply(2, 0);
        assertEquals(0, result);
    }

    @Test
    public void test_divide_valid() {
        int result = out.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void test_divide_zero_is_first_arg() {
        int result = out.divide(0, 2);
        assertEquals(0, result);
    }

    @Test
    public void test_divide_on_zero() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> out.divide(5, 0));
    }

    @ParameterizedTest
    @MethodSource("sumTestParams")
    public void test_sum(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.sum(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("subtractTestParams")
    public void test_subtract(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.subtract(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void test_multiply(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void test_divide(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.divide(num1, num2));
    }


}
