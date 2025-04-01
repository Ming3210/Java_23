package B5;

class SharedResource {
    private String message;
    private boolean hasMessage = false;
    private String[] messages;

    public SharedResource(String[] messages) {
        this.messages = messages;
    }

    public int getMessageCount() {
        return messages.length;
    }

    public SharedResource(boolean hasMessage, String message, String[] messages) {
        this.hasMessage = hasMessage;
        this.message = message;
        this.messages = messages;
    }

    public SharedResource() {
    }

    public String[] getMessages() {
        return messages;
    }

    public synchronized void setMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        hasMessage = true;
        notify();
    }

    public synchronized String getMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasMessage = false;
        notify();
        return message;
    }
}
