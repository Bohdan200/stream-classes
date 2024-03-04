import java.util.stream.Stream;

public class IterateNumbersStream {
    public static void main(String[] args) {
        Stream<Long> result = infinityStream(25214903917L, 11, 2 ^ 48, 0);
        System.out.println("result = " + result);
    }

    public static Stream<Long> infinityStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, acc -> (a * acc + c) % m);
    }
}