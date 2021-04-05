package SOLIDPrinciples.openclose.correctDesign;

public class PersistenceManager {

    PersistenceToDB persistenceToDB;
    PersistenceInvoiceToFile invoiceToFile;

    PersistenceManager(PersistenceToDB db, PersistenceInvoiceToFile file){
        persistenceToDB = db;
        invoiceToFile = file;
    }

    PersistenceManager(){}

    public PersistenceToDB getPersistenceToDB() {
        return persistenceToDB;
    }

    public void setPersistenceToDB(PersistenceToDB persistenceToDB) {
        this.persistenceToDB = persistenceToDB;
    }

    public PersistenceInvoiceToFile getInvoiceToFile() {
        return invoiceToFile;
    }

    public void setInvoiceToFile(PersistenceInvoiceToFile invoiceToFile) {
        this.invoiceToFile = invoiceToFile;
    }
}
