package stream.exercises.ex1.operations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .map(doubleValue())
                .filter(greaterThanThree())
                .limit(2).collect(Collectors.toList());
    }

    private static Predicate<Integer> greaterThanThree() {
        return num -> {
            System.out.println("check number " + num + " is greater than 3");
            return num > 3;
        };
    }

    private static Function<Integer, Integer> doubleValue() {
        return num -> {
            System.out.println("double value of " + num);
            return num * 2;
        };
    }
}
