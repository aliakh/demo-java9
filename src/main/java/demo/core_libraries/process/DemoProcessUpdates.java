package demo.core_libraries.process;

public class DemoProcessUpdates {

    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("current process id: " + currentProcess.pid());

        ProcessHandle.Info info = currentProcess.info();
        System.out.println("arguments: " + info.arguments());
        System.out.println("command line: " + info.commandLine());
        System.out.println("start time: " + info.startInstant());
        System.out.println("total CPU time: " + info.totalCpuDuration());
    }
}
