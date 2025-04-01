class PriorityThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread();
        PriorityThread t2 = new PriorityThread();
        PriorityThread t3 = new PriorityThread();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
        t1.start();
        t2.start();


        //Mức độ ưu tiên (priority) của các luồng không đảm bảo 100% thứ tự thực hiện giữa chúng.
        //
        //Lịch trình của bộ lập lịch JVM: Bộ lập lịch của JVM phụ thuộc vào hệ điều hành
        // và có thể không luôn thực thi luồng có mức ưu tiên cao trước.
        //
        //Preemptive & Time-Slicing Scheduling: Nhiều hệ điều hành sử dụng chiến
        // lược chia sẻ thời gian (time-slicing), nghĩa là mỗi luồng có thể được cấp phát CPU
        // trong một khoảng thời gian nhất định bất kể mức ưu tiên.
        //
        //Số lượng nhân CPU: Nếu hệ thống có nhiều lõi CPU, các luồng có thể chạy song song
        // thay vì luồng ưu tiên cao chạy trước.
    }
}
