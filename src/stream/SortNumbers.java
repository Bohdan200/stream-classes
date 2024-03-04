package stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class SortNumbers {
    public static void main(String[] args) {
        String[] numbers = new String[]{"3, 6, 1", "7, 4", "12, 9", "20, 14, 27"};

        System.out.println("sort() = " + sort(numbers));
    }

    private static String sort(String[] numbers) {
        return Arrays.stream(numbers)
                .flatMap(line -> Arrays.stream(line.split(", ")))
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
