package pro.skypro.course2.lesson14;

import java.util.Arrays;
import java.util.Random;

import static pro.skypro.course2.lesson14.SortUtils.*;

public class SortTest {

    private static final int ARRAY_CAPACITY = 10_000;
    private static final int ARRAY_MAX_RANGE_VALUE = 100_000;

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arr1 = random.ints(ARRAY_CAPACITY, 0, ARRAY_MAX_RANGE_VALUE).boxed().toArray(Integer[]::new);
        Integer[] arr2 = Arrays.copyOf(arr1, ARRAY_CAPACITY);
        Integer[] arr3 = Arrays.copyOf(arr1, ARRAY_CAPACITY);
        Integer[] arr4 = Arrays.copyOf(arr1, ARRAY_CAPACITY);
        Integer[] arr5 = Arrays.copyOf(arr1, ARRAY_CAPACITY);

        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println("Bubble Sort: " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println("Selection Sort: " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println("Insert Sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        quickSort(arr4);
        System.out.println("Quick Sort: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        mergeSort(arr5);
        System.out.println("Merge Sort: " + (System.currentTimeMillis() - start));

    }

}
