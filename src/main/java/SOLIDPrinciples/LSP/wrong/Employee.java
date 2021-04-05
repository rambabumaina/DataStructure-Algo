package SOLIDPrinciples.LSP.wrong;


/**
 * LSP(Liskov Substitution Principle)
 *
 * What is the problem here?
 * Principle says, parent/Base class should be able to substitute their child/drive classes, What does this mean?
 * Prent class reference should able to call all their child class methods without fail.
 * Example:=
 * P p =new P();
 * P p = new C1();
 * P p = new C2();
 *
 * ** Most importantly, no child class method should through the exception when its methods called,
 *
 */
public interface Employee {

    void calculateSalary();
    void calculateBonus();
}


class PermanentEmployee implements Employee{

    @Override
    public void calculateSalary() {
        //Here is the logic to calculate salary of Permanent Employee
        System.out.println("Permanent Employee salary is 1000");
    }

    @Override
    public void calculateBonus() {
        //Here is the logic of calculate salary of Permanent Employee
        System.out.println("Permanent Employee Bonus is 10%");
    }
}

//Violates LPS :: Since CalculateBonus throws exception
class TemporaryEmployee implements Employee{
    @Override
    public void calculateSalary() {
        //Here is the logic to calculate salary of Temporary Employee
        System.out.println("Permanent Employee salary is 500");
    }


    @Override
    public void calculateBonus() {
        //Temporary Employee not eligible for bonus hence throws exception
        throw new RuntimeException("Temporary Employee not Eligible for bonus");
    }
}