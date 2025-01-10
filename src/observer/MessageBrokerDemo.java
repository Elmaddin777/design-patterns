package observer;

import java.util.ArrayList;
import java.util.List;

interface KafkaTopicObserver {

    void listenToEvent(String message);

}

interface KafkaSubject {

    void registerObserver(KafkaTopicObserver observer);
    void removeObserver(KafkaTopicObserver observer);
    void notifyObservers();

}

class KafkaTemplate implements KafkaSubject {

    private List<KafkaTopicObserver> observers = new ArrayList<>();
    private String message;

    @Override
    public void registerObserver(KafkaTopicObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(KafkaTopicObserver observer) {
        this.observers.remove(observer);
    }

    public void produceMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(o -> o.listenToEvent(this.message));
    }

}

class KafkaTopic1 implements KafkaTopicObserver {

    @Override
    public void listenToEvent(String message) {
        System.out.println("KafkaTopic1 added " + message + " message to queue");
    }

}

class KafkaTopic2 implements KafkaTopicObserver {

    @Override
    public void listenToEvent(String message) {
        System.out.println("KafkaTopic2 added " + message + " message to queue");
    }

}

public class MessageBrokerDemo {

    public static void main(String[] args) {
        var topic1 = new KafkaTopic1();
        var topic2 = new KafkaTopic2();

        var kafkaTemplate = new KafkaTemplate();
        kafkaTemplate.registerObserver(topic1);
        kafkaTemplate.registerObserver(topic2);
        kafkaTemplate.produceMessage("some message");
    }

}
