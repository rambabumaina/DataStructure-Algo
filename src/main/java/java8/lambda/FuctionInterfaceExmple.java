package java8.lambda;


public class FuctionInterfaceExmple {
    //1
//    void print();

//    //2
//    default void greet(){
//        System.out.println("Greet");
//    }
//    default void greet1(){
//        System.out.println("Greet");
//    }

    //3
    static void work(){
        System.out.println("WOrk Inteface");
    }

    static void work1(){
        System.out.println("WOrk");
    }

//    //4
//    @Override
//    public int hashCode();
//
//    @Override
//    public boolean equals(Object obj);
}

class Test extends FuctionInterfaceExmple{

//    @Override
//    public void print() {
//
//    }

    static void work(){
        System.out.println("WOrk Test");
    }

    public static void main(String[] args) {
        Test test = new Test();

        FuctionInterfaceExmple f =null;
         f = test;

        f.work();
    }
}



