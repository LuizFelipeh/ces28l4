package databases;

import invoice.Invoice;
import invoice.InvoiceDatabaseHistory;
import invoice.InvoiceDatabaseSaver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.TaxHistoryObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lucasmullerm on 17/11/2015.
 */
public class MockInvoiceDatabase implements InvoiceDatabaseHistory, InvoiceDatabaseSaver {
    private long _currentID = 0;
    List<TaxHistoryObject> taxHistory = new ArrayList<TaxHistoryObject>();


    private static MockInvoiceDatabase _instance = new MockInvoiceDatabase();

    public static MockInvoiceDatabase getInstance() { return _instance; }

    private MockInvoiceDatabase(){
    }

    @Override
    public List<TaxHistoryObject> getHistory() {
        throw new NotImplementedException();
    }

    @Override
    public long save(Invoice invoice) {
        _currentID ++;
        TaxHistoryObject taxHistoryObject = new TaxHistoryObject(invoice.getTotal(), new Date(), invoice.getTaxation());
        taxHistory.add(taxHistoryObject);
        return _currentID;
    }

    public static MockInvoiceDatabase getInstance() {
        return null;
    }
}
