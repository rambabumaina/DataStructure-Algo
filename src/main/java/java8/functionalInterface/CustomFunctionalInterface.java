package java8.functionalInterface;


public class CustomFunctionalInterface {
    public static void main(String[] args) {

        Devices device = ()-> System.out.println("All is well...");
        device.printDevices();
        device.getDevice();
        Devices.getTest();

    }
}

interface Devices{

    void printDevices();

    default void getDevice(){
        System.out.println("default test..");
    }

    static void getTest(){
        System.out.println("static test..");
    }


}