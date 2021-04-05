package SOLIDPrinciples.openclose.correctDesign;

public class ObjectManager {

    private PersistenceToDB db;
    private PersistenceInvoiceToFile file;

    ObjectManager(PersistenceToDB db , PersistenceInvoiceToFile file){
        this.db = db;
        this.file = file;
    }
}
