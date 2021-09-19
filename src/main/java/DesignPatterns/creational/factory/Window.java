package DesignPatterns.creational.factory;

public class Window implements Button{
    @Override
    public void display() {
        System.out.println("Window Button Displayed");
    }

    @Override
    public void click() {
        System.out.println("Window Button clicked");
    }
}
