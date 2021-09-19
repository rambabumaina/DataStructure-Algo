package DesignPatterns.creational.factory;

public class FactoryRunner {
    public static void main(String[] args) {
        Button button = ButtonFactory.getInstance("");
        button.click();
        button.display();
    }
}
