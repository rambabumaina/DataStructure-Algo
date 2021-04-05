package SOLIDPrinciples.singleResponsibility.worngDesign;

//Invoice class which contains Book invoice
public class Invoice {

    Book book;
    int total;

    public Invoice(Book book, int total, double discount, double tax) {
        this.book = book;
        this.total = total;
        this.discount = discount;
        this.tax = tax;
    }

    double discount;
    double tax;

    //Calculate function will calculate the price of the book with tax and discount
    public double CalculatePrice(){
        double price = book.getPrice() -discount;
        double princeWithTax = price + tax;
        return princeWithTax;
    }

    //printBookDetails function will will print the book details
    public void printBookDetails(){
        System.out.println(book.getName() + " " + book.getPrice());
        System.out.println(book.getName() + " " + total);
    }

    //Calculate function which will calculate the price of the book with tax and discount
    public void saveToFile(){
        System.out.println(book.getName() + " " + book.getPrice());
        System.out.println(book.getName() + " " + total);
    }
}

/* The Single Responsibility Principle
Q? what is wrong here?
Ans: Single responsibility says the class should have only one reason to change but here we can see three reasons
where class can be modified, one is CalculatePrice,printBookDetails,saveToFile.

We should have all the functions in separate class in case any requirement change in print method or save or calculate method ,
we should not change in the class, so what we will do here , calculate we will keep in the same class(Invoice).
We will create to classes to print and save  methods
 */