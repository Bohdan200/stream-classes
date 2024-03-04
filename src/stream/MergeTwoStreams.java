package stream;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class MergeTwoStreams {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("Alpha", "Beta", "Gamma", "Delta");
        Stream<String> streamB = Stream.of("1", "2", "3", "4", "5");

        Stream<String> result = zipIterators(streamA, streamB);

        System.out.println("result = " + result.toList());
    }

    public static <T> Stream<T> zipIterators(Stream<T> streamA, Stream<T> streamB) {
        List<T> resultList = new ArrayList<>();

        Iterator<T> iteratorA = streamA.iterator();
        Iterator<T> iteratorB = streamB.iterator();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            resultList.add(iteratorA.next());
            resultList.add(iteratorB.next());
        }

        return resultList.stream();
    }
}
