package SOLIDPrinciples.openclose.wrongDesign;

import SOLIDPrinciples.singleResponsibility.correctDesign.Invoice;

/**
 * OPEN_CLOSE principle says class is open for enhancement but not for Modification
 * Modification: change in the existing working/tested code
 * Enhancement: adding new functionality
 * Suppose our boss came and Ask save the Invoice in Data base too. Oh now what we will do?
 * Don't worry we will connect to DB and write one method Save Invoice to DB
 *
 * Ask your self Is this right?
 * NO: you violate open close principle, because you are modified the class by adding the "saveTODB" method
 *
 * Then how you will add new addToDb method, without modifying ?
 * It is easy you can use interface
 */
public class PersistenceInvoice {
    Invoice invoice;

    PersistenceInvoice(Invoice invoice){
        this.invoice  = invoice;
    }

    //Method will save invoice to the file
    public void saveToFile(Invoice invoice){

    }

    //Method will save invoice to the file
    public void saveToDB(Invoice invoice){

    }
}
