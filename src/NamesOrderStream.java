import generator.Human;
import generator.HumanGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NamesOrderStream {
    public static void main(String[] args) {
        AtomicInteger order = new AtomicInteger(1);

        List<String> humans = new HumanGenerator()
                .generate(10)
                .stream()
                .map(Human::getName)
                .map(name -> {
                    int acc = order.intValue();
                    order.set(acc + 1);
                    return acc % 2 != 0 ? acc + ". " + name : "";
                })
                .filter(name -> !name.isEmpty())
                .toList();

        for (String human : humans) {
            System.out.println(human);
        }

    }
}
