package CourseworkPart2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text");
        String text = scanner.nextLine();  // Read user input
        System.out.println("Description is: " + text);  // Output user input
        String [] words = text.split("\\s");
        System.out.println(words.length);
        for (String subSrt: words) {
            System.out.println(subSrt.length());
        }

        ArrayList <String> list = new ArrayList<>();
        list.add ("yourapp the quick brown fox jumps over the lazy dog тест тест");
        list.stream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(word -> word.replaceAll("[^A-Za-zА-Яа-яЁё]+", "").toLowerCase())
                .filter(word -> word.length() > 0)
                .collect(Collectors.toMap(key -> key, val ->1, Integer::sum))
                .entrySet().stream()
                .sorted ((e1, e2) -> {
                    int val = e1.getValue().compareTo(e2.getValue()) * -1;
                    if (val == 0) {
                        val = e1.getKey().compareTo(e2.getKey());
                        if (e1.getKey().charAt(0) <= 'z'
                                && e2.getKey().charAt(0) > 'z'
                                || e1.getKey().charAt(0) > 'z'
                                && e2.getKey().charAt(0) <= 'z') {
                            val *= -1;
                        }
                    }
                    return val;
                })
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
