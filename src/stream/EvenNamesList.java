package stream;

import generator.Human;
import generator.HumanGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenNamesList {
    public static void main(String[] args) {
        AtomicInteger order = new AtomicInteger(1);

        List<String> evenNames = new HumanGenerator()
                .generate(10)
                .stream()
                .map(Human::name)
                .map(name -> {
                    int acc = order.intValue();
                    order.set(acc + 1);
                    return acc % 2 == 0 ? acc + ". " + name : "";
                })
                .filter(name -> !name.isEmpty())
                .toList();

        for (String name : evenNames) {
            System.out.println(name);
        }

    }
}
