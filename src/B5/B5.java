package B5;

class Writer extends Thread {
    private SharedResource sharedResource;

    public Writer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        String[] messages = sharedResource.getMessages();
        for (String msg : messages) {
            sharedResource.setMessage(msg);
            System.out.println("Writer gửi: " + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Reader extends Thread {
    private SharedResource sharedResource;

    public Reader(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        int messageCount = sharedResource.getMessageCount();
        for (int i = 0; i < messageCount; i++) {
            String message = sharedResource.getMessage();
            System.out.println("Reader nhận được: " + message);
        }
    }
}

public class B5 {
    public static void main(String[] args) {
        String[] messages = {"Hello", "Hi", "Abc", "Xyz"};
        SharedResource sharedResource = new SharedResource(messages);

        Writer writer = new Writer(sharedResource);
        Reader reader = new Reader(sharedResource);

        writer.start();
        reader.start();
    }
}