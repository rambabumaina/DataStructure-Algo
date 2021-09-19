package DesignPatterns.creational.factory;

public class WebPage implements Button{
    @Override
    public void display() {
        System.out.println("Web Button Displayed..");
    }

    @Override
    public void click() {
        System.out.println("Web Button clicked..");
    }
}
