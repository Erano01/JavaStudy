package me.erano.com.example4;
import java.util.concurrent.Flow.*;
import java.util.ArrayList;
import java.util.List;

public class FlowYoutubeChannel implements Publisher<String> {
    private String name;

    private final List<Subscriber<? super String>> subscribers = new ArrayList<>();

    public FlowYoutubeChannel(String str){
        this.name = str;
    }

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        subscribers.add(subscriber);
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) { /* basit örnek, boş */ }

            @Override
            public void cancel() {
                subscribers.remove(subscriber);
            }
        });
    }

    public void uploadVideo(String title) {
        for (Subscriber<? super String> sub : subscribers) {
            sub.onNext(title);
        }
    }
}
