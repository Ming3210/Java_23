package B5;

class Writer extends Thread {
    private final SharedResource sharedData;

    public Writer(SharedResource sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public synchronized void run() {
        this.sharedData.setMessage(sharedData.getMessage());
        notify();
    }
}
