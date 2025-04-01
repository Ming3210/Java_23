public class B1 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread đang chạy : "+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
    }

}
