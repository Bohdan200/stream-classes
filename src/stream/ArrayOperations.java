package stream;

import java.util.*;

public class ArrayOperations {
    public static void main(String[] args) {
        String[] arr = new String[]{"1, 2, 0", "4, 5"};

        System.out.println("sort() = " + sort(arr));
    }

    private static String sort(String[] arr) {
        String result = Arrays.stream(arr)
                .map(el -> {
                    String[] parts = el.split(",");
                    int[] numbers = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        numbers[i] = Integer.parseInt(parts[i].trim());
                    }
                    Arrays.sort(numbers);

                    StringBuilder str = new StringBuilder();
                    for (int number : numbers) {
                        str.append(number).append(", ");
                    }

                    return str.toString();
                })
                .reduce("", (acc, el) -> acc + el);

        return result.substring(0, result.length() - 2);
    }
}
