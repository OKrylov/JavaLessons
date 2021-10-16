package pro.skypro.lesson1;

public class Homework01 {


    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
        task8();

        // task1
    }

    public static void task1() {
        byte b = -128;
        short s = 32_767;

        int i = 2_147_483_647;
        long l = 9_223_372_036_854_775_807L;

        long l1 = 128;
        float f = 3.14f;
        double d = 1.797693134862;

//        var r;
//        int a;

//        char c = 'c';
//        boolean flag = true;
    }

    public static void task2() {
        float b1 = 78.2f;
        float b2 = 87.7f;

        /*
        dgs
        dsgsd
        dsgds
         */

        System.out.println("Sum: " + (b1 + b2)); // 78.2 + 87.7 = 165.9
//        System.out.println("Diff: " + (b2 - b1)); // 87.7 - 78.2 = 9.5
        System.out.println("Diff: " + Math.abs(b1 - b2)); // 87.7 - 78.2 = 9.5
    }

    public static void task3() {
//        float gramsInKg = 1000.0f;
        int gramsInKg = 1000;

        int bananaWeight = 80;
        int bananaAmount = 5;

        int milkWeight = 105;
        int milkAmount = 200 / 100;

        int iceCreamWeight = 100;
        int iceCreamAmount = 2;

        int eggWeight = 70;
        int eggAmount = 4;

        int result = (bananaWeight * bananaAmount)
                + (milkWeight * milkAmount)
                + (iceCreamWeight * iceCreamAmount)
                + (eggWeight * eggAmount);

//        int resultInKg = result / gramsInKg;
        float resultInKg = result / (gramsInKg * 1.0f); // int / float => float
        System.out.println(resultInKg);
    }

    public static void task4() {
        int needToLoseKgs = 7;
        int gramsInKilogram = 1000;

        int needToLoseGs = needToLoseKgs * gramsInKilogram;

        int minGramsPerDay = 250;
        int maxGramsPerDay = 500;

        int minDays = needToLoseGs / maxGramsPerDay; // 14
        int maxDays = needToLoseGs / minGramsPerDay; // 28
        int avgDays = (minDays + maxDays) / 2; // 42 / 2 = 21

        System.out.println("Min: " + minDays);
        System.out.println("Max: " + maxDays);
        System.out.println("Avg: " + avgDays);
    }

    public static void task5() {
        int mashaSalary = 67_760;
        int denisSalary = 83_690;
        int kristinaSalary = 86_230;

        int percent = 10;

//        mashaSalary * percent / 100

        float newSalaryMultiplier = 1 + (percent / 100f);  // 1.1f == 110%

        int mashaNewSalary = (int) (mashaSalary * newSalaryMultiplier);
        int mashaTotalSalaryDiff = (mashaNewSalary - mashaSalary) * 12; // (mashaNewSalary * 12) - (mashaSalary * 12)

        int denisNewSalary = (int) (denisSalary * newSalaryMultiplier);
        int denisTotalSalaryDiff = (denisNewSalary - denisSalary) * 12;

        int kristinaNewSalary = (int) (kristinaSalary * newSalaryMultiplier);
        int kristinaTotalSalaryDiff = (kristinaNewSalary - kristinaSalary) * 12;

        System.out.println("Маша теперь получает: " + mashaNewSalary + ". " + "Годовой доход вырос на " + mashaTotalSalaryDiff + " рублей.");
        System.out.println("Денис теперь получает: " + denisNewSalary + ". " + "Годовой доход вырос на " + denisTotalSalaryDiff + " рублей.");
        System.out.println("Кристина теперь получает: " + kristinaNewSalary + ". " + "Годовой доход вырос на " + kristinaTotalSalaryDiff + " рублей.");
    }

    public static void task6() {
        int a = 12;
        int b = 27;
        int c = 44;
        int d = 15;
        int e = 9;

        System.out.println((a * (b + (c - d * e))));
//        int result = (a * (b + (c - d * e))) * -1;
        int result = -(a * (b + (c - d * e)));
        System.out.println(result);
    }

    public static void task7() {
        int a = 5;
        int b = 7;
        System.out.println("A: " + a + ", B: " + b);

//        int temp = a; // temp = 5; a = 5; b = 7;
//        a = b; // temp = 5; a = 7; b = 7;
//        b = temp; // temp = 5; a = 7; b = 5;

        // a =  5; b = 7;
        a = a + b; // a = 12; b = 7;
        b = a - b; // a = 12; b = 5;
        a = a - b; // a = 7; b = 5;
//        System.out.println("A: " + a + ", B: " + b);

        // 1568 = 1000 + 500 + 60 + 8 = 1*10^3 + 5*10^2 + 6*10^1 + 8*10^0
        a = a ^ b ^ (b = a); // 5 = 101 => 1 * 2^2 + 0*2^1 + 1*2^0 => 5; 7 = 111
        // a = a XOR b XOR a
        System.out.println("A: " + a + ", B: " + b);
    }

    public static void task8() {
        int a = 987;
        int b = a / 10; // b=25
        b = b % 10; // 25/10 = 2.5
//        System.out.println(5);
        System.out.println(b);
    }
}
