package demo.core_libraries.optional;

import java.util.Optional;

public class DemoOptionalUpdates {

    public static void main(String[] args) {
        System.out.println("Optional.stream");
        Optional.of(1).stream().forEach(System.out::println);
        Optional.empty().stream().forEach(System.out::println);

        System.out.println("Optional.ifPresentOrElse");
        Optional.of(1).ifPresentOrElse(i -> System.out.println("found: " + i), () -> System.out.println("not found"));
        Optional.empty().ifPresentOrElse(i -> System.out.println("found: " + i), () -> System.out.println("not found"));

        System.out.println("Optional.or");
        System.out.println(Optional.empty().or(() -> Optional.of("empty")));
        System.out.println(Optional.of("value").or(() -> Optional.of("empty")));
    }
}
