package pro.skypro.course1.lesson8;

import java.util.Arrays;
import java.util.Random;

public class Main81 {

    public static void main(String[] args) {
        int[] arr = generateRandomArray();
        System.out.println(Arrays.toString(arr));

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
    }

    private static int[] generateRandomArray() {
        Random random = new java.util.Random();
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
