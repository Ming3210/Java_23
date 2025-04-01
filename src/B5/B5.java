package B5;

public class B5 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource("aaabbb");

        Writer writer = new Writer(sharedResource);
        Reader reader = new Reader(sharedResource);

        writer.start();
        reader.start();

    }
}