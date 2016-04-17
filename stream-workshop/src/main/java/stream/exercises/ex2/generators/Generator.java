package stream.exercises.ex2.generators;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Generator {

    //TODO 1 - Write a function to get first n elements from stream
    public List<String> firsNEvents(int n, Stream<String> events) {
        return events.limit(n).collect(Collectors.toList());
    }

    //TODO 2 - Write a function which generates a stream containing infinitely many copies of the given element
    public Stream<String> nRepeat(String elem) {
        return Stream.generate(() -> elem);
    }

    //TODO 3a - Write a function which generates a Stream of natural numbers
    public Stream<Integer> nNumbers() {
        return IntStream.iterate(0, i -> i + 1).boxed();
        //return IntStream.generate(new AtomicInteger() :: getAndIncrement).boxed();
    }

    //TODO 3b - Write a function which generates a Stream of Fibonacci numbers
    public Stream<Integer> fibNumbers() {
        return nNumbers().map(this::fib);
    }

    private Integer fib(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fib(i - 2) + fib(i - 1);
        }
    }

    //TODO 4 - Write a function which interleaves the elements from 2 Streams. You will wants Interleave to be lazy in its second parameter.
    public Stream<String> nInterleave(Stream<String> aStream, Stream<String> bStream) {
        Iterator<String> aIterator = aStream.iterator();
        Iterator<String> bIterator = bStream.iterator();

        final Iterator<String> mergeIterator = new Iterator<String>() {
            private boolean interleave = false;

            @Override
            public boolean hasNext() {
                return aIterator.hasNext() || bIterator.hasNext();
            }

            @Override
            public String next() {
                if (interleave) {
                    interleave = false;
                    return bIterator.next();
                } else {
                    interleave = true;
                    return aIterator.next();
                }
            }
        };

        final Iterable<String> iterable = () -> mergeIterator;
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
