package demo.java_language.project_coin;

public class DemoTryWithResources {

    private void tryWithResourcesJava7() {
        final DemoResource resource1 = new DemoResource();
        DemoResource resource2 = new DemoResource();
        try (DemoResource r1 = resource1;
             DemoResource r2 = resource2) {
        }
    }

    private void tryWithResourcesJava9() {
        final DemoResource resource1 = new DemoResource();
        DemoResource resource2 = new DemoResource();
        try (resource1;
             resource2) {
        }
    }

    public static class DemoResource implements AutoCloseable {

        @Override
        public void close() {
        }
    }
}
