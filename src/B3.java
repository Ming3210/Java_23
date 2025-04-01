import java.util.List;



public class B3 {
    static class MyThread extends Thread{
        public MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            synchronized (SharedResource.class) {
                System.out.println("Luồng " + Thread.currentThread().getName() + ":");
                SharedResource.strings.forEach(s -> System.out.print(s + " "));
                System.out.println();
            }
        }
    }

     class SharedResource {
        static List<String> strings = List.of("A", "B", "C", "D", "E", "F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("1");
        MyThread thread2 = new MyThread("2");


            thread1.start();


            thread2.start();


    }
}
