package hash;

import java.util.Objects;

public class EqualsAndHasCodeMethod {

    public static void main(String[] args) {

        Student s1= new Student("ram", 30);
        Student s2= new Student("ram", 30);

        // Because object class equals method doesn't check value but memory location
        //Object class doesn't know about the data that student class has
        System.out.println(s1.equals(s2)); //false
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }
}



class Student{
    private String name;
    private int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public boolean equals(Object o){
//
//        System.out.println(o);
//
//        if(o == this) return true;
//        //class and null equality
//        if(o == null || o.getClass() != getClass()) return false;
//
//        Student s = (Student)o;
//        return name.equals(s.getName()) && age == s.age;
//    }
//
//    public int hashCode(){
//        return Objects.hash(age);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}