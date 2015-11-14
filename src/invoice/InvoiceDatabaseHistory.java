package invoice;

import taxes.TaxHistoryObject;

import java.util.List;

/**
 * Created by Felipeh on 14/11/2015.
 */
public interface InvoiceDatabaseHistory {
    List<TaxHistoryObject> getHistory();
}
