package databases;

import invoice.Invoice;
import invoice.InvoiceDatabaseHistory;
import invoice.InvoiceDatabaseSaver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.TaxHistoryObject;

import java.util.List;

/**
 * Created by lucasmullerm on 17/11/2015.
 */
public class MockInvoiceDatabase implements InvoiceDatabaseHistory, InvoiceDatabaseSaver {
    @Override
    public List<TaxHistoryObject> getHistory() {
        throw new NotImplementedException();
    }

    @Override
    public long save(Invoice invoice) {
        throw new NotImplementedException();
    }
}
