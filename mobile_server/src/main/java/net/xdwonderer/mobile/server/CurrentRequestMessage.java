package net.xdwonderer.mobile.server;

public class CurrentRequestMessage {
    private Object inputMessage;

    public Object getCurrentMessage() {
        return inputMessage;
    }
    public void setCurrentMessage(Object inputMessage) {
        this.inputMessage = inputMessage;
    }
}
