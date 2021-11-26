package pro.skypro.course1.lesson7;

public class Main7 {

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
        task8();
    }

    private static void task1() {
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
//        String fullName = lastName + " " + firstName + " " + middleName;
        String fullName = String.join(" ", lastName, firstName, middleName);
        System.out.println("ФИО сотрудника - " + fullName);
    }

    private static void task2() {
        String fullName = "Ivanov Ivan Ivanovich";
        String upperFullName = fullName.toUpperCase();
        System.out.println(upperFullName);
//        fullName.toUpperCase();
//        System.out.println(fullName);
//        System.out.println(fullName.toUpperCase());
    }

    private static void task3() {
        String fullName = " Ivanov Ivan Ivanovich   ";
//        String result = fullName.replace(' ', ';');
//        String result = fullName.replace(" ", ";");
        fullName = fullName.trim();
        fullName = fullName.replace(" ", ";");
        fullName = fullName.toUpperCase();

        fullName = fullName.trim()
                .replace(" ", ";")
                .toUpperCase();

//        fullName = fullName.replace(" ", ";");
//        fullName = fullName.toUpperCase();

        System.out.println(fullName);
    }

    private static void task4() {
        String fullName = "Иванов Семён Семёнович";
        String validFullName = fullName.replace('ё', 'е');
        System.out.println("Данные ФИО сотрудника – " + validFullName);
    }

    private static void task5() {
        String fullName = "Ivanov Ivan Ivanovich";

        String[] words = fullName.split(" ");

        String lastName = words[0];
        String firstName = words[1];
        String middleName = words[2];

//        System.out.println(fullName.indexOf(" "));
//        System.out.println(fullName.lastIndexOf(" "));
//
//        String lastName = fullName.substring(0, fullName.indexOf(" "));
//        String firstName = fullName.substring(fullName.indexOf(" ") + 1, fullName.lastIndexOf(" "));
//        String middleName = fullName.substring(fullName.lastIndexOf(" ") + 1);

        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }

    private static void task6() {
        String fullName = "ivanov ivan ivanovich";

        char[] charArray = fullName.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0 || charArray[i - 1] == ' ') {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        System.out.println(String.valueOf(charArray));



        String[] words = fullName.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();

            if (Character.isLowerCase(chars[0])) {
                chars[0] = Character.toUpperCase(chars[0]);
                words[i] = String.valueOf(chars);
//                words[i] = new String(chars);
            }
        }

        System.out.println(String.join(" ", words));
    }

    private static void task7() {
        String s1 = "1357";
        String s2 = "246";
        // 123456

        StringBuilder sb = new StringBuilder();
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }

        String r = "1" + "2" + "3" + "4";


        String result = sb.toString();
        System.out.println(result);
    }

    private static void task8() {
        String s = "aabccccddefgghiijjkk";
//        String s = "acdgijk";

        char prevChar = Character.MAX_VALUE;
//        System.out.println(prevChar);

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i - 1] == chars[i]) {
//                if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
//                    sb.append(chars[i]);
//                }
//            }
//        }
//
//        System.out.println(sb.toString());


        boolean isDuplicateFound = false;
        for (char letter : chars) {
            if (letter != prevChar) {
                isDuplicateFound = false;
            } else if (isDuplicateFound) {
                continue;
            } else {
                sb.append(letter);
                isDuplicateFound = true;
            }
        }

        System.out.println(sb.toString());
    }

}
