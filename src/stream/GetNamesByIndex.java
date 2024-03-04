package stream;

import generator.Human;
import generator.HumanGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class GetNamesByIndex {
    public static void main(String[] args) {
        System.out.println("getByIdx(3) = " + getByIdx(3));
    }

    public static String getByIdx(int findIndex) {
        List<String> names = new HumanGenerator()
                .generate(20)
                .stream()
                .map(Human::name)
                .toList();

        return names.stream()
                .map((el) -> names.indexOf(el) % findIndex == 0 ? names.indexOf(el) + ". " + el + ", " : "")
                .collect(Collectors.joining());
    }
}
