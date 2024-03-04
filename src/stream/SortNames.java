package stream;

import generator.Human;
import generator.HumanGenerator;

import java.util.Comparator;
import java.util.List;

public class SortNames {
    public static void main(String[] args) {
       sort(17);
    }

    public static void sort(int count) {
        List<String> names = new HumanGenerator()
                .generate(count)
                .stream()
                .map(Human::name)
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .peek(System.out::println)
                .toList();

        System.out.println("humans.size() = " + names.size());
    }
}
