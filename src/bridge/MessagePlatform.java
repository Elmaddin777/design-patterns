package bridge;

// Bridge
interface Platform {

    void sendMessage(String message);

}

class IosPlatform implements Platform {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message from IOS platform: " + message);
    }

}

class AndroidPlatform implements Platform {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message from Android platform: " + message);
    }

}

abstract class Message {

    protected Platform platform;

    public Message(Platform platform) {
        this.platform = platform;
    }

    abstract void sendMessage(String message);

}

class TextMessage extends Message {

    public TextMessage(Platform platform) {
        super(platform);
    }

    @Override
    void sendMessage(String message) {
        this.platform.sendMessage(message);
    }
}

class SmsMessage extends Message {

    public SmsMessage(Platform platform) {
        super(platform);
    }

    @Override
    void sendMessage(String message) {
        this.platform.sendMessage(message);
    }

}


public class MessagePlatform {

    public static void main(String[] args) {
        var androidPlatform = new AndroidPlatform();
        var iosPlatform = new IosPlatform();

        Message textMessage = new TextMessage(iosPlatform);
        Message smsMessage = new SmsMessage(androidPlatform);

        textMessage.sendMessage("Text message");
        smsMessage.sendMessage("SMS message");
    }

}
