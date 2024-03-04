package stream;

import java.util.stream.Stream;

public class IterateRandomNumbers {
    public static void main(String[] args) {
        Stream<Long> result = infinityStream(25214903917L, 11, 2 ^ 48, 0);
        result.limit(20).toList().forEach(System.out::println);
    }

    public static Stream<Long> infinityStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, acc -> (a * acc + c) % m);
    }
}