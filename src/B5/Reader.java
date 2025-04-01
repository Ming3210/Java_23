package B5;

class Reader extends Thread {
    private SharedResource sharedData;

    public Reader(SharedResource sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public synchronized void run() {
        System.out.println("Read message: " + this.sharedData.getMessage());
        notify();
    }
}
