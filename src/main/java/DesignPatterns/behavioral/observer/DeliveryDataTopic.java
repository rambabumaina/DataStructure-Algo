package DesignPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class DeliveryDataTopic implements Subject {

    List<Observer> observerList;
    String notification;

    public DeliveryDataTopic() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void deRegister(Observer observer) {
        System.out.println("Topic unsubscribed  by "+ observer.getClass().getName());
        this.observerList.remove(observer);
    }

    @Override
    public void notification() {

        for (Observer observer : observerList) {
           observer.update(this.notification);
        }
    }
}

