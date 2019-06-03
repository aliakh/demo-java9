package demo.core_libraries.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DemoUnmodifiableMap {

    public static void main(String[] args) {
        unmodifiableMapJava8();

        unmodifiableMapJava9();
        unmodifiableMapEntryJava9();
    }

    private static void unmodifiableMapJava8() {
        Map<Integer, String> unmodifiableEmptyMap = Collections.unmodifiableMap(new HashMap<>());

        Map<Integer, String> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put(1, "one");
        nonEmptyMap.put(2, "two");
        nonEmptyMap.put(3, "three");
        Map<Integer, String> unmodifiableNonEmptyMap = Collections.unmodifiableMap(nonEmptyMap);
    }

    private static void unmodifiableMapJava9() {
        Map<Integer, String> unmodifiableEmptyMap = Map.of();

        Map<Integer, String> unmodifiableNonEmptyMap = Map.of(1, "one", 2, "two", 3, "three");
    }

    private static void unmodifiableMapEntryJava9() {
        Map<Integer, String> unmodifiableEmptyMap = Map.ofEntries();

        Map<Integer, String> unmodifiableNonEmptyMap = Map.ofEntries(Map.entry(1, "one"), Map.entry(2, "two"), Map.entry(3, "three"));
    }
}
