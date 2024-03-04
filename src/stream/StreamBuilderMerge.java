package stream;

import java.util.Iterator;
import java.util.stream.Stream;

public class StreamBuilderMerge {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("Alpha", "Beta", "Gamma", "Delta");
        Stream<String> streamB = Stream.of("1", "2", "3", "4", "5");
        Stream<String> streamC = Stream.of("I", "II", "III");

        Stream<String> result = zip(streamA, streamB, streamC);

        System.out.println("result = " + result.toList());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second, Stream<T> third) {
        Iterator<T> firstIter = first.iterator();
        Iterator<T> secondIter = second.iterator();
        Iterator<T> thirdIter = third.iterator();

        Stream.Builder<T> builder = Stream.builder();

        while (firstIter.hasNext() && secondIter.hasNext() && thirdIter.hasNext()) {
            builder.add(firstIter.next());
            builder.add(secondIter.next());
            builder.add(thirdIter.next());
        }

        return builder.build();
    }
}
