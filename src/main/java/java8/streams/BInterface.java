package java8.streams;

@FunctionalInterface
public interface BInterface extends FInterface{
    default void abd(){
        System.out.println("BInterface");
    }
}
