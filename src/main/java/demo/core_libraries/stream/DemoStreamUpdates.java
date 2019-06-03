package demo.core_libraries.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStreamUpdates {

    public static void main(String[] args) {
        System.out.println("Stream.takeWhile");
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(x -> x < 5).forEach(System.out::println);

        System.out.println("Stream.dropWhile");
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).dropWhile(x -> x < 5).forEach(System.out::println);

        System.out.println("Stream.iterate");
        IntStream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::println);

        System.out.println("Stream.ofNullable");
        Stream.ofNullable(1).forEach(System.out::println);
        Stream.ofNullable(null).forEach(System.out::println);
    }
}
