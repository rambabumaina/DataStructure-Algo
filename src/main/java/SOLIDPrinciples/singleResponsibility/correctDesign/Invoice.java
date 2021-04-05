package SOLIDPrinciples.singleResponsibility.correctDesign;


/**
 * Now we follow Single responsibility, design principal,
 * Invoice Class will have calculate method
 */
public class Invoice {
    private Book book;
    private int total;
    private double discount;
    private double tax;

    public Invoice(Book book, int total, double discount, double tax) {
        this.book = book;
        this.total = total;
        this.discount = discount;
        this.tax = tax;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    //Calculate function will calculate the price of the book with tax and discount
    public double CalculatePrice(){
        double price = book.getPrice() -discount;
        double princeWithTax = price + tax;
        return princeWithTax;
    }
}
