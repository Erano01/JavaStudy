package me.erano.com.example4;

import java.util.concurrent.Flow;

//subject, observable, publisher, event
public abstract class Event implements Flow.Publisher{

    public void attach(Listener listener){

    }

    public void detach(Listener listener){

    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {


    }

}
