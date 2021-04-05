package SOLIDPrinciples.singleResponsibility.correctDesign;
// Any requirement change in the print method need not to touch the Invoice and PersistenceInvoice class
public class PrintInvoice {

    Invoice invoice;

    PrintInvoice(Invoice invoice){
        this.invoice = invoice;
    }

    // Print method can print the data of the class
    public void printBookDetails(){
        System.out.println(invoice.getBook().getName()+" "+ invoice.getTotal());
    }
}
