package B5;

class Reader extends Thread {
    private SharedResource sharedData;

    public Reader(SharedResource sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public synchronized void run() {
        while(true) {
            synchronized(sharedData) {
                try {
                    System.out.println("Read message: " + sharedData.getMessage());
                    sharedData.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
