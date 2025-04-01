package B5;

class Writer extends Thread {
    private final SharedResource sharedData;

    public Writer(SharedResource sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for(int i = 1; i < 5; i++) {
            synchronized(sharedData) {
                sharedData.setMessage(sharedData.getMessage());
                sharedData.notify();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
