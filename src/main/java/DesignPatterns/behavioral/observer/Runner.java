package DesignPatterns.behavioral.observer;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        Observer user = new UserConsumer();
        Observer seller = new SellerConsumer();

        DeliveryDataTopic topic = new DeliveryDataTopic();
        topic.register(user);
        topic.register(seller);

        runner.productDeliveryStatus(topic);

        topic.deRegister(seller);
        runner.productDeliveryStatus(topic);


    }

    public void productDeliveryStatus(DeliveryDataTopic topic) {
        int i = 1;
        while (i <= 6) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (i) {
                case 1: {
                    topic.notification = "Order has been Confirmed";
                    topic.notification();
                    break;
                }
                case 2: {
                    topic.notification = "Order shipped";
                    topic.notification();
                    break;
                }
                case 3: {
                    topic.notification = "Order In transit";
                    topic.notification();
                    break;
                }
                case 4: {
                    topic.notification = "out for delivery";
                    topic.notification();
                    break;
                }
                case 5: {
                    topic.notification = "Product Delivered";
                    topic.notification();
                    break;
                }
                default:{
                    topic.notification = "Thanks..";
                    topic.notification();
                }
            }
            i++;
        }
    }


}
