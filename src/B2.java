

public class B2 {
    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        Thread thread = new Thread(printer);
        thread.start();
    }
}
