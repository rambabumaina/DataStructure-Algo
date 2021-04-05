package SOLIDPrinciples.singleResponsibility.worngDesign;

//Book class which Contains only Books data
public class Book {
    private String name;
    private double price;
    private String authorName;
    private int year;

    public Book(String name, double price, String authorName, int year) {
        this.name = name;
        this.price = price;
        this.authorName = authorName;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
