package DesignPatterns.behavioral.observer;

public interface Subject {

    void register(Observer observer);
    void deRegister(Observer observer);
    void notification();
}
