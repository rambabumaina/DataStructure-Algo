package SOLIDPrinciples.openclose.correctDesign;

import SOLIDPrinciples.singleResponsibility.worngDesign.Invoice;

//Here: you can save the invoice to the DB
public class PersistenceToDB implements PersistenceInvoice {
    @Override
    public void save(Invoice invoice) {
        System.out.println("Save invoice in DB....");
    }
}
