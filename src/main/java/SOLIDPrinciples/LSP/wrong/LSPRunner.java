package SOLIDPrinciples.LSP.wrong;

public class LSPRunner {
    public static void main(String[] args) {
        Employee e = new PermanentEmployee();
        e.calculateBonus();
        e.calculateSalary();

        e = new TemporaryEmployee();
        e.calculateBonus();//here this will violate the LSP throws exception
        e.calculateSalary();
    }
}
