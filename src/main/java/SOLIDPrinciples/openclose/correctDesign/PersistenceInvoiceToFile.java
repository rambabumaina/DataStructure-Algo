package SOLIDPrinciples.openclose.correctDesign;

import SOLIDPrinciples.singleResponsibility.worngDesign.Invoice;

//Here: you can write in file
public class PersistenceInvoiceToFile implements PersistenceInvoice {
    @Override
    public void save(Invoice invoice) {
        System.out.println("save invoice in file....");
    }
}
