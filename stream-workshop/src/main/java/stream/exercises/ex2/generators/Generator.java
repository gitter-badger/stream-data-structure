package stream.exercises.ex2.generators;


import java.util.List;
import java.util.stream.Stream;

public class Generator {

    //TODO 1 - Write a function to get first n elements from stream
    public List<String> firsNEvents(int n, Stream<String> events) {
        throw new UnsupportedOperationException("Missing implementation");
    }

    //TODO 2 - Write a function which generates a stream containing infinitely many copies of the given element
    public Stream<String> nRepeat(String elem) {
        throw new UnsupportedOperationException("Missing implementation");
    }

    //TODO 3a - Write a function which generates a Stream of natural numbers
    public Stream<Integer> nNumbers() {
        throw new UnsupportedOperationException("Missing implementation");
    }

    //TODO 3b - Write a function which generates a Stream of Fibonacci numbers
    public Stream<Integer> fibNumbers() {
        throw new UnsupportedOperationException("Missing implementation");
    }

    //TODO 4 - Write a function which interleaves the elements from 2 Streams. You will wants Interleave to be lazy in its second parameter.
    public Stream<String> nInterleave(Stream<String> aStream, Stream<String> bStream) {
        throw new UnsupportedOperationException("Missing implementation");
        //create custom iterator and convert to stream with StreamSupport.stream(...)
    }
}
