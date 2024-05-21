package api;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;

public class OldInterwievTasks {

    //correct string []{}()
    @Test
    public void hardTaskFromInterview() {
        List<String> poolOfStrings = asList("[]{}()", "{}][()", ")({}[]", "(]{)[}", "()[){}");
        for (String str : poolOfStrings) defineWasTheStringCorrect(str);
    }

    private void defineWasTheStringCorrect(String str) {
        LinkedHashMap<Integer, List<Character>> linkedHashMap = new LinkedHashMap<Integer, List<Character>>() {{
            put(40, asList('(', ')'));
            put(41, asList('(', ')'));
            put(123, asList('{', '}'));
            put(125, asList('{', '}'));
            put(91, asList('[', ']'));
            put(93, asList('[', ']'));
        }};
        boolean result = false;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i = i + 2) {
            Character currentSymbol = array[i];
            int integerRepresentation = (int) currentSymbol;
            List<Character> characterList = linkedHashMap.get(integerRepresentation);
            Character nextSymbol = array[i + 1];
            result = characterList.contains(nextSymbol);
            if (result == false) break;
        }
        System.out.println("Result for string '" + str + "' is: " + result);
    }

    @Test
    public void wasTheStringAPalindrome() {
        boolean result = true;
        String str = "qweww";
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("Was the string: '" + str + "' a palindrome? " + result);
    }

    @Test
    public void revertString() {
        String string = "Y*T*R*E*W*Q";
        String result = "";
        char[] array = string.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            String currentSymbol = String.valueOf(array[i]);
            result = result + currentSymbol;
        }
        System.out.println("Initial string:  " + string);
        System.out.println("Reverted string: " + result);
    }

    //repeatable characters with number of repeats
    @Test
    public void repeatable() {
        String text = "qwertyqwasdy";
        //создаем map в котором key - это символ из строки, value - количетсво повторений
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < text.length(); j++) {
            char ch = text.charAt(j);
            // если map содержит такой ключ (символ из строки), то берем счетчик, увеличиваем его, и сохраняем заново в map
            if (map.containsKey(ch)) {
                int counter = map.get(ch);
                map.put(ch, ++counter);
            } else {
                map.put(ch, 1);
            }
        }
        Set<Character> charKeys = map.keySet();

        for (Character ch : charKeys) {
            int count = map.get(ch);
            if (count > 1) {
                System.out.println(ch + " - " + count);
            }
        }
    }

    //duplicated characters
    @Test
    public void duplicatedChars() {
        String str = "stabcts";
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (chars[i] == chars[j]) {
                    System.out.println(chars[j]);
                    break;
                }
            }
        }
    }

    //count of occurrence in string
    @Test
    public void occurrenceInString() {
        String string = "qwertyast";
        char searchedCharacter = 't';
        int rslt = 0;
        char[] text = string.toCharArray();
        for (char c : text) {
            if (c == searchedCharacter)
                rslt++;
        }
        System.out.println(rslt);
    }

    //vowels and consonants
    @Test
    public void vowelsANdConsonants() {
        int vowls = 0;
        int consonts = 0;
        String text = "qwertyasdfg";
        for (int k = 0; k < text.length(); k++) {
            char c = text.charAt(k);
            if (c == 'a' || c == 'e' || c == 'i' ||
                    c == 'o' || c == 'u') vowls++;
            else consonts++;
        }
        System.out.println("Vowel count is " + vowls);
        System.out.println("Consonant count is: " + consonts);
    }

    //number of different words in a sentence
    @Test
    public void test() {
        String str = "This this is is done by Saket Saket";
        String[] split = str.split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            } else map.put(s, 1);
        }
        System.out.println(map);
    }

    //second largest element
    @Test
    public void secondLargestElement() {
        int[] array = {1, 1, 2, 1, 1, 1, 1};

        int second;
        int arr_size = array.length;
        int largest = second = Integer.MIN_VALUE;

        // Find the largest element
        for (int i = 0; i < arr_size; i++) {
            largest = Math.max(largest, array[i]);
        }

        // Find the second largest element
        for (int i = 0; i < arr_size; i++) {
            if (array[i] != largest) {
                second = Math.max(second, array[i]);
            }
        }
        if (second == Integer.MIN_VALUE)
            System.out.println("There is no second " +
                    "largest element\n");
        else
            System.out.printf("The second largest " +
                    "element is %d\n", second);
    }

    //Fibonacci numbers
    @Test
    public void fibonacci() {
        int num1 = 0, num2 = 1, summ;
        int finalSumma = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("num: " + num1);
            summ = num1 + num2;
            num1 = num2;
            num2 = summ;
            //System.out.println("summ: " + summ);
            finalSumma = finalSumma + summ;
        }
        System.out.println("The final summ is: " + finalSumma);
    }

    //factorial
    @Test
    public void factorial() {
        int num = 6;
        long factorial = multiplyNumbers(num);
        System.out.println("Factorial of " + num + " = " + factorial);
    }

    public long multiplyNumbers(int num) {
        long result;
        if (num >= 1) return num * multiplyNumbers(num - 1);
        else return 1;
    }

    @Test
    public void summFromNumber() {
        int num = 29;
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        System.out.println(sum);
    }

    @Test
    public void userNa() {
        String[][] names = {{"Natalie", "Lee"}, {"Shayne ", "Jensen"}, {"Natalie", "Lee"}, {"Natalie", "Lee"}};

        List<String> userNames = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String firstName = names[i][0];
            firstName = firstName.toLowerCase();
            String lastName = names[i][1];
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
            if (userNames.contains(firstName + lastName)) userNames.add(firstName + lastName + "1");
            else userNames.add(firstName + lastName);
        }
        System.out.println(userNames);
    }

    @Test
    public void threeAndFive() {
        int num = 333;
        if (num % 3 == 0) System.out.println("FIZZ");
        if (num % 5 == 0) System.out.println("BUZZ");
    }

    @Test
    public void max() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        if (array.length == 0) throw new IllegalArgumentException();

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        System.out.println(max);
    }

    @Test
    public void mergeSortedLists() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 8, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> mergedSortedList = new ArrayList<>();

        while (list1.size()>0 || list2.size()>0) {
            if(list1.size()==0 || list2.size()==0) break;
            if (list1.get(0) <= list2.get(0)) {
                mergedSortedList.add(list1.get(0));
                list1.remove(0);
            } else {
                mergedSortedList.add(list2.get(0));
                list2.remove(0);
            }
        }
        if(list1.size()!=0) mergedSortedList.addAll(list1);
        if(list2.size()!=0) mergedSortedList.addAll(list2);

        System.out.println(mergedSortedList);
    }
}