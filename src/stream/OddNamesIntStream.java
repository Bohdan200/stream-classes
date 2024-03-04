package stream;

import generator.Human;
import generator.HumanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddNamesIntStream {
    public static void main(String[] args) {

        List<String> names = new HumanGenerator()
                .generate(10)
                .stream()
                .map(Human::name)
                .filter(name -> !name.isEmpty())
                .toList();

        String oddNames = IntStream.range(0, names.size())
                .mapToObj(x -> x % 2 != 0 ? x + ". " + names.get(x) + ", " : "")
                .collect(Collectors.joining());

        System.out.println("oddNames = " + oddNames);
    }
}
