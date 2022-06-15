package interview.algonomy;

public class TaskRunner {
    private static Integer number =0;
    private static boolean ready;
    private static class Tester extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Tester().start();
        number = 2;
//        number = 4001;
        ready = true;
    }
}
