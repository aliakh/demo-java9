package demo.core_libraries.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoUnmodifiableList {

    public static void main(String[] args) {
        unmodifiableListJava8();
        unmodifiableListJava9();
    }

    private static void unmodifiableListJava8() {
        List<String> unmodifiableEmptyList = Collections.unmodifiableList(new ArrayList<>());

        List<String> nonEmptyList = new ArrayList<>();
        nonEmptyList.add("one");
        nonEmptyList.add("two");
        nonEmptyList.add("three");
        List<String> unmodifiableNonEmptyList = Collections.unmodifiableList(nonEmptyList);
    }

    private static void unmodifiableListJava9() {
        List<String> unmodifiableEmptyList = List.of();
        List<String> unmodifiableNonEmptyList = List.of("one", "two", "three");
    }
}
