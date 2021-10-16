package pro.skypro.lesson2;

import java.math.BigDecimal;
import java.net.URL;

public class Homework02 {

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task5_1();
//        task5_2();
//        task5_3();
//        task6();
//        task7();
    }

    public static void task1() {
        byte clientOS = 0; // 0 - ios; 1 - android

        if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else if (clientOS == 1) {
            System.out.println("Установите версию приложения для Android по ссылке.");
        } else {
            System.out.println("Данная версия ОС не поддерживается!");
        }

    }

    public static void task2() {
        byte clientOS = 10;
        int clientDeviceYear = 2020;

        boolean isLiteNeeded = clientDeviceYear < 2019;
        boolean isIos = clientOS == 0;
        boolean isAndroid = clientOS == 1;

//        if (isIos && isLiteNeeded) {
//            System.out.println("Установите lite-версию приложения для iOS по ссылке.");
//        } else if (isIos && !isLiteNeeded) {
//            System.out.println("Установите версию приложения для iOS по ссылке.");
//        } else if (!isIos && isLiteNeeded) {
//            System.out.println("Установите lite-версию приложения для Android по ссылке.");
//        } else if (!isIos && !isLiteNeeded) {
//            System.out.println("Установите версию приложения для Android по ссылке.");
//        }

        if (isIos) {
            if (isLiteNeeded) {
                System.out.println("Установите lite-версию приложения для iOS по ссылке.");
            } else {
                System.out.println("Установите версию приложения для iOS по ссылке.");
            }
        } else if (isAndroid) {
            if (isLiteNeeded) {
                System.out.println("Установите lite-версию приложения для Android по ссылке.");
            } else {
                System.out.println("Установите версию приложения для Android по ссылке.");
            }
        } else {
            System.out.println("Данная версия ОС не поддерживается!");
        }
    }

    public static void task3() {
        int year = 2020;

//        if (year % 400 == 0) {
//            System.out.println(year + " -- високосный год.");
//        } else if (year % 4 == 0) {
//            if (year % 100 != 0) {
//                System.out.println(year + " -- високосный год.");
//            } else {
//                System.out.println(year + " -- не является високосным годом.");
//            }
//        } else {
//            System.out.println(year + " -- не является високосным годом.");
//        }


        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " -- високосный год.");
        } else {
            System.out.println(year + " -- не является високосным годом.");
        }
//
//        int a = 0;
//        if (a != 0 && 5 / a == 2) {
//
//        }
    }

    public static void task4() {
        int deliveryDistance = 15;

//        if (deliveryDistance <= 20) {
//            System.out.println("Потребуется дней: 1");
//        } else if (deliveryDistance <= 60) {
//            System.out.println("Потребуется дней: 2");
//        } else if (deliveryDistance < 100) {
//            System.out.println("Потребуется дней: 3");
//        } else {
//            System.out.println("Не дождемся");
//        }

        int result = 1;
        if (deliveryDistance > 20) {
            result++;
        }
        if (deliveryDistance > 60 && deliveryDistance <= 100) {
            result++;
        }

        System.out.println("Потребуется дней: " + result);
    }

    public static void task5() {
        int monthNumber = 12;

        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Такого месяца нет.");

        }
    }


    public static void task5_1() {
        int monthNumber = 4;

        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Такого месяца нет.");
                break;
        }
    }

    public static void task7() {
        int age = 25;
        int salary = 81_000;
        int wantedSum = 330_000;

        int maxPayment = salary / 2;
        int creditTerm = 12;
        double interestRate = 10;

        if (age < 23) {
            interestRate += 1.0;
        } else if (age < 30) {
            interestRate += 0.5;
        }

        if (salary > 80_000) {
            interestRate -= 0.7;
        }

        double creditSum = wantedSum * (1 + (interestRate / 100));
        double payment = creditSum / creditTerm;

        System.out.println("Ваш максимальный платеж: " + maxPayment + ". Платеж по кредиту: " + payment);
        if (payment > maxPayment) {
            System.out.println("Отказано.");
        } else {
            System.out.println("Одобрено.");
        }
    }

    public static void task5_2() {
        int monthNumber = 13;

        switch (monthNumber) {
            case 12, 1, 2 -> System.out.println("Зима");
            case 3, 4, 5 -> System.out.println("Весна");
            case 6, 7, 8 -> System.out.println("Лето");
            case 9, 10, 11 -> System.out.println("Осень");
            default -> System.out.println("Такого месяца нет.");
        }
    }


    public static void task5_3() {
        int monthNumber = 12;

        String season = switch (monthNumber) {
            case 12, 1, 2 -> "Зима";
            case 3, 4, 5 -> "Весна";
            case 6, 7, 8 -> "Лето";
            case 9, 10, 11 -> "Осень";
            default -> "Такого месяца нет.";
        };

        System.out.println(season);
    }

    public static void task6() {
        int age = 24;
        int salary = 158_000;
        double limit;

        if (age < 23) {
            limit = salary * 2;
        } else {
            limit = salary * 3;
        }

        int maxSalary = 80_000;
        if (salary >= 50_000 && salary < maxSalary) {
            limit *= 1.2;
//            limit = limit * 1.2;
        } else if (salary >= maxSalary) {
            limit *= 1.5;
        }
        System.out.println("Мы готовы выдать вам кредитную карту с лимитом " + limit + " рублей.");
    }


}
