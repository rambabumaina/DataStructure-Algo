package SOLIDPrinciples.LSP.correctDesign;

public interface IEmployee {
    void calculateSalary();
}

interface IBonus extends IEmployee{
    void calculateBonus();
}

class PermanentEmployee implements IBonus {

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

//IEmployee has only Calculate salary method and we will implements IEmployee not IBonus
class TemporaryEmployee implements IEmployee{
    @Override
    public void calculateSalary() {
        //Here is the logic to calculate salary of Temporary Employee
        System.out.println("Permanent Employee salary is 500");
    }
}

class Test{
    public static void main(String[] args) {
        IBonus b = new PermanentEmployee();
        b.calculateSalary();
        b.calculateBonus();

        IEmployee e = new PermanentEmployee();
        e.calculateSalary();
//        e.calculateBonus(); //it will through compilation since it is not there in interfaces
    }
}