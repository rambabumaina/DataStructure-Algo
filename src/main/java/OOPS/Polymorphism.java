package OOPS;

public class Polymorphism {

    //Prent reference --> call only prent method
    //child reference -> Parent method and child methods
    public static void main(String[] args) {
        //1 P-> P
        // Parent reference Parent object
        Parent p = new Parent();
        p.M1();   // M1 In Parent...
        p.M3();   // M3 In Parent...
        //p.M2();  // Compilation error Can't resolve method M2

        System.out.println();

        //2 P ->c Parent reference can hold child object
        // Parent reference child object
        Parent p1 = new Child();
        //If method is overridden from parent and child(M1 is in both classes), it will call child class method
        p1.M1(); // M1 In child...
        p1.M3(); //M3 In Parent...
        //p1.M2(); // Compilation error Can't resolve method M2

        System.out.println();

        //3 c->P
        // Child reference child object
        //With child reference and child object we can call aal methods including parent
        Child c = new Child();
        c.M1(); // M1 In child...
        c.M2(); // M2 In child...
        c.M3(); // M3 In Parent...

        //4 c->P : Child object can't not hold parent object
        // you will have to type cast to achieve this
        // Child c1 = new Parent();

    }
}

class Parent{
    public void M1(){
        System.out.println("M1 In Parent...");
    }
    public void M3(){
        System.out.println("M3 In Parent...");
    }
}

class Child extends Parent {
    public void M1(){
        System.out.println("M1 In child...");
    }
    public void M2(){
        System.out.println("M2 In child...");
    }
}



