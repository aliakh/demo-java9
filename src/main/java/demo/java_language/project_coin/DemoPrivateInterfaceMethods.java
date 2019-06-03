package demo.java_language.project_coin;

public class DemoPrivateInterfaceMethods {

    public static void main(String[] args) {
        new DemoInterface() {
        }.run();
    }

    public interface DemoInterface {

        private static String staticPrivateMethod() {
            return "static private method";
        }

        private String instancePrivateMethod() {
            return "instance private method";
        }

        default void run() {
            System.out.println(staticPrivateMethod());
            DemoInterface demoInterface = new DemoInterface() {
            };
            System.out.println(demoInterface.instancePrivateMethod());
        }
    }
}
