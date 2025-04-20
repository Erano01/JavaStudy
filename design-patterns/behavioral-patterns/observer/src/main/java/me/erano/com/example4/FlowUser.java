package me.erano.com.example4;

import java.util.concurrent.Flow;

public class FlowUser implements Flow.Subscriber<String> {
    private String name;

    public FlowUser(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("(Flow) " + name + ", kanala abone oldu ");
    }

    @Override
    public void onNext(String item) {
        System.out.println("(Flow) " + name + ", yeni video yüklendi: " + item);
    }

    @Override
    public void onError(Throwable throwable) {}

    @Override
    public void onComplete() {}
}
