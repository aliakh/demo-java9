package demo.core_libraries.reactive_streams;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoSubscriber<T> implements Subscriber<T> {

    private final AtomicInteger howMuchMessagesToConsume;
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();

    public DemoSubscriber(Integer howMuchMessagesToConsume) {
        this.howMuchMessagesToConsume = new AtomicInteger(howMuchMessagesToConsume);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        howMuchMessagesToConsume.decrementAndGet();
        System.out.println("Got : " + item);
        consumedElements.add(item);
        if (howMuchMessagesToConsume.get() > 0) {
            subscription.request(1);
        }
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}