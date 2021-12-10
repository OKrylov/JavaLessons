package pro.skypro.course2.lesson6;

import java.util.*;

public class CollectionHomework {

    private static final List<Integer> nums = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5, 6, 7);
    private static final List<String> words = Arrays.asList(
            "What", "is", "love?",
            "baby", "don't", "hurt", "me",
            "don't", "hurt", "me",
            "no more"
    );

    public static void main(String[] args) {
        task1();
//        task2();
//        task3_1();
//        task3_2();
//        task4();
    }

    private static void task1() {
        for (Integer num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static void task2() {
        List<Integer> uniqueList = new ArrayList<>(Set.copyOf(nums));
        Collections.sort(uniqueList);
        uniqueList.removeIf(num -> num % 2 != 0);
        for (Integer num : uniqueList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void task3_1() {
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords);
    }

    private static void task3_2() {
        Set<String> uniqueWords = new HashSet<>(words);
        List<String> duplicatedWords = new ArrayList<>(words);
        for (String uniqueWord : uniqueWords) {
            duplicatedWords.remove(uniqueWord);
        }
        uniqueWords.removeAll(duplicatedWords);
        System.out.println(uniqueWords);
    }

    public static void task4() {
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println(words.size() - uniqueWords.size());
    }
}
