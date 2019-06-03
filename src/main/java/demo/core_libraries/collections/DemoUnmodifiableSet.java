package demo.core_libraries.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DemoUnmodifiableSet {

    public static void main(String[] args) {
        unmodifiableSetJava8();
        unmodifiableSetJava9();
    }

    private static void unmodifiableSetJava8() {
        Set<String> unmodifiableEmptySet = Collections.unmodifiableSet(new HashSet<>());

        Set<String> nonEmptySet = new HashSet<>();
        nonEmptySet.add("one");
        nonEmptySet.add("two");
        nonEmptySet.add("three");
        Set<String> unmodifiableNonEmptySet = Collections.unmodifiableSet(nonEmptySet);
    }

    private static void unmodifiableSetJava9() {
        Set<String> unmodifiableEmptySet = Set.of();

        Set<String> unmodifiableNonEmptySet = Set.of("one", "two", "three");
    }
}
