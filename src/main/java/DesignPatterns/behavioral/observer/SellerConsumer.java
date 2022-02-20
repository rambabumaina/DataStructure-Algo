package DesignPatterns.behavioral.observer;

public class SellerConsumer implements Observer {

    private String oder_details;

    @Override
    public void update(String data) {
        this.oder_details = data;
        printOrderDetails();
    }

    private void printOrderDetails() {
        System.out.println("Seller :" + oder_details+"\n");
    }

}
