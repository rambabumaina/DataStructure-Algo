package SOLIDPrinciples.singleResponsibility.correctDesign;

// Any requirement change in the Persistence invoice class/method need not to touch the Invoice and PrintInvoice class
public class PersistenceInvoice {
    Invoice invoice;

    PersistenceInvoice(Invoice invoice){
        this.invoice  = invoice;
    }

    //Method will save invoice to the fil
    public void saveToFile(){

    }
}
