package api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterwievTasks {

    @Test
    public void revertString() {
        String str = "Hello World";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
    }

    @Test
    public void maxNumberFromArray() {
        int[] nums = {1, 5, 3, 9, 7};

        int largestNumber = Arrays.stream(nums)
                .max()
                .orElseThrow(); // Throw NoSuchElementException if array is empty

        System.out.println("Largest number: " + largestNumber);
    }

    @Test
    public void removeDuplicateFromArray() {
        int[] nums = {1, 2, 3, 1, 2, 4, 5};
        List<Integer> list = Arrays.stream(nums)
                .boxed() // Convert int to Integer
                .distinct()
                .toList();
        list.forEach(System.out::println);
//        Set<Integer> set = new HashSet<>(list);
//        set.forEach(System.out::println);
    }

    @Test
    public void removeStringDuplicates() {
        String[] array = {"apple", "banana", "apple", "orange", "banana", "grape"};

        List<String> uniqueList = Arrays.stream(array)
                .distinct()
                .collect(Collectors.toList());

        // Convert back to array if needed
        String[] uniqueArray = uniqueList.toArray(new String[uniqueList.size()]);

        System.out.println("Array without duplicates: " + Arrays.toString(uniqueArray));
    }

    @Test
    public void findAndReplaceInsideText() {

        String text = "hello world. It's me";
        String source = "world";
        String target = "JavaScript";

        // If the source string is empty, return the original text
        if (source.isEmpty()) {
            System.out.println(text);
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            // Check if the substring from the current position (i) matches the source
            if (text.startsWith(source, i)) {
                // Append the target to the result and skip the length of the source
                result.append(target);
                i += source.length();
            } else {
                // Otherwise, just append the current character to the result
                result.append(text.charAt(i));
                i++;
            }
        }

        System.out.println(result.toString());
    }

    @Test
    public void pairsOfIntThatGivesFive() {
        int[] arr = {1, 3, 4, 2, 1, 5, 0};

        Set<List<Integer>> map = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == 5) {

                    map.add(List.of(arr[i], arr[j]));
                }
            }
        }

        map.forEach(list -> System.out.println(list.get(0) + " " + list.get(1)));
    }

    @Test
    public void secondLargestNumber() {
        int[] numbers = {10, 5, 20, 8, 15, 10};

        int secondLargest = Arrays.stream(numbers)
                .boxed()  // Convert int to Integer
                .distinct()  // Remove duplicates
                .sorted((a, b) -> b - a)  // Sort in descending order
                .skip(1)  // Skip the largest number
                .findFirst()  // Get the second largest number
                .orElseThrow(() -> new IllegalArgumentException("Array is empty or has only one element"));

        System.out.println("Second largest number: " + secondLargest);
    }

    @Test
    public void factorial() {
        int num = 5;
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is " + fact);
    }

    @Test
    public void threeAndFive() {
        int num = 22;
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FIZZBAZZ");
        } else if (num % 3 == 0) {
            System.out.println("FIZZ");
        } else if (num % 5 == 0) {
            System.out.println("BAZZ");
        } else {
            System.out.println("Not FIZZ or BUZZ");
        }
    }


    @Test
    public void customizeMapAndPrintIt() {
        Map<String, String> map = new HashMap<>() {{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }};

        Map<String, String> modifiedMap = map.entrySet().stream()
                .map(entry -> {
                    String modifiedValue = entry.getValue() + " modified";
                    return Map.entry(entry.getKey(), modifiedValue);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        modifiedMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test //anagram - words contain the same letters
    public void twoStringsAreAnagrams() {
        String str1 = "silent";
        String str2 = "listen";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }

    @Test
    public void mergeArraysInOrder() {
        int[] array1 = {3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8};

        int[] mergedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .sorted()
                .toArray();

        System.out.println("Merged and sorted array: " + Arrays.toString(mergedArray));
    }

}