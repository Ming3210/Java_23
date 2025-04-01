package B5;

public class SharedResource {
    private String message;

    public SharedResource(String message) {
        this.message = message;
    }

    public SharedResource() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
