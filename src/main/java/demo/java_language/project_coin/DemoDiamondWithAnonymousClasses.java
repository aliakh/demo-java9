package demo.java_language.project_coin;

public class DemoDiamondWithAnonymousClasses {

    public static void main(String[] args) {
        DemoClass<Integer> class1 = new DemoClass<>(1) { // anonymous inner class
        };

        DemoClass<? extends Integer> class2 = new DemoClass<>(1) { // anonymous inner class
        };

        DemoClass<?> class3 = new DemoClass<>(1) { // anonymous inner class
        };
    }

    public static class DemoClass<T> {

        private final int i;

        public DemoClass(int i) {
            this.i = i;
        }
    }
}
