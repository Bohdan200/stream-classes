package stream;

import generator.Human;
import generator.HumanGenerator;

import java.util.Comparator;
import java.util.List;

public class NamesSorted {
    public static void main(String[] args) {
       sort(17);
    }

    private static void sort(int count) {
        List<String> humans = new HumanGenerator()
                .generate(count)
                .stream()
                .map(Human::getName)
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .toList();

        for (String human : humans) {
            System.out.println(human);
        }

        System.out.println("humans.size() = " + humans.size());
    }
}
