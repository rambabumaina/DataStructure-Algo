package DesignPatterns.behavioral.observer;

public class UserConsumer implements Observer{
    private String oder_details;

    @Override
    public void update(String data) {
        this.oder_details = data;
        printOrderDetails();
    }

    private void printOrderDetails() {
        System.out.println("User :" + oder_details);
    }
}
