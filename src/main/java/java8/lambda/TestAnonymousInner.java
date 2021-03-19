package java8.lambda;

abstract class Person{
    abstract void eat();
}

public class TestAnonymousInner{
    public static void main(String args[]){
        Person p=new Person(){
            void eat(){System.out.println("nice fruits");}
        };
        p.eat();

        Person p2=new Person(){
            void eat(){System.out.println("nice fruits");}
        };
        p2.eat();
        System.out.println("hello");
    }
}
