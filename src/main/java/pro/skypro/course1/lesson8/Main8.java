package pro.skypro.course1.lesson8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main8 {

    private static int b;

    public static void main(String[] args) {
//        printIsLeapYear(2021);
//        printRecommendApplicationVersion(0, 2021);
//        System.out.println("Количество дней доставки: " + calculateDeliveryDays(70));
//        findDuplicates("aabccddefgghiijjkk");
//
//        int[] data = {3, 2, 1, 6, 5};
//        int[] result = reverseArray(data);
//        System.out.println("Reversed array: " + Arrays.toString(result));
//        System.out.println("Source array: " + Arrays.toString(data));
////
        int[] array = generateRandomArray();
        System.out.println("Array: " + Arrays.toString(array));
        double avgSum = calculateAverageValueFrom(array);
        System.out.println("Average Sum: " + avgSum);
//
//        int result = test1();
//        test2(result);

    }

    private static void test2(int result) {
        System.out.println(result);
        System.out.println(b);
    }

    private static int test1() {
        int a = 5;
        a += 3;
        b = 4;
        return a;
    }

    // -------------------- task 1

    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " високосный");
        } else {
            System.out.println(year + " не является високосным");
        }
    }

    // -------------------- task 2

    public static void printRecommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        String deviceType = getDeviceType(clientOS);

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Установите ");
        if (deviceIsOld) {
            messageBuilder.append("lite ");
        }
        messageBuilder.append("версию для ");
        messageBuilder.append(deviceType);


        System.out.println(messageBuilder);
    }

    private static String getDeviceType(int clientOS) {
        if (clientOS == 0) {
            return "iOS";
        } else {
            return "Android";
        }
    }

    private static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear < currentYear;
    }


    // -------------------- task 3
    public static int calculateDeliveryDays(int deliveryDistance) {
//        int result = 1;

        if (deliveryDistance <= 20) {
            return 1;
        } else if (deliveryDistance <= 60) {
            return 2;
        } else {
            return 3;
        }

//        if (deliveryDistance > 20) {
//            result++;
//        }
//
//        if (deliveryDistance > 60) {
//            result++;
//        }

//        return result;
    }


    // -------------------- task 4

    public static void findDuplicates(String text) {
        char[] letters = text.toCharArray();
        char prevChar = Character.MAX_VALUE;
        for (char letter : letters) {
            if (letter == prevChar) {
                System.out.println("Найден дубль по символу " + letter);
                return;
            }
            prevChar = letter;
        }
        System.out.println("Дублей не найдено");
    }


    // -------------------- task 5

    public static int[] reverseArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int head = 0;
        int tail = arr.length - 1;
        while (head < tail) {
            int temp = newArr[head];
            newArr[head++] = arr[tail];
            newArr[tail--] = temp;
        }

        return newArr;
    }


    // -------------------- task 6

    public static double calculateAverageValueFrom(int[] arr) {
        int sum = calculateSum(arr);
        return sum / (double) arr.length;
    }

    private static int calculateSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    private static double calculateAverageValue(int sum, int elementAmount) {
        return sum / (double) elementAmount;
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
