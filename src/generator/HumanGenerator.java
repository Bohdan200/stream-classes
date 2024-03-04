package generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class HumanGenerator {
    public Collection<Human> humans = new ArrayList<>();

    public Collection<Human> generate(int count) {
        for (int i = 0; i < count; i++) {
            makeHuman();
        }

        return humans;
    }

    private void makeHuman() {
        Random random = new Random();
        String fullName = createHumanName();

        for (Human human : humans) {
            if (fullName.equals(human.getName())) {
                makeHuman();
                return;
            }
        }

        int salary = 2000 + random.nextInt(1001);
        humans.add(new Human(fullName, salary));
    }

    private String createHumanName() {
        Random random = new Random();

        List<String> firstNames = List.of("William", "Margaret", "Steve", "Emily", "Jeremy", "Barbara");
        List<String> lastNames = List.of("Smith", "Johnson", "Miller", "Wilson", "Brown", "Davis");

        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));

        return firstName + " " + lastName;
    }
}
