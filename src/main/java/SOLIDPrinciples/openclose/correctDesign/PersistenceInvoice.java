package SOLIDPrinciples.openclose.correctDesign;

import SOLIDPrinciples.singleResponsibility.worngDesign.Invoice;

//Writing Abstract class/ Interface is the right design


//Tomorrow if requirement change and we have to store invoice in some other Db,
// We have to create on class and implement save method
public interface PersistenceInvoice {
    void save(Invoice invoice);
}
