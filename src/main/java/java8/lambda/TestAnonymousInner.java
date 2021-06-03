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
        p.eat();
        System.out.println("hello");
    }
}
