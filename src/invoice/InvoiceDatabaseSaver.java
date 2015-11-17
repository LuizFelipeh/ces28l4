package invoice;

import taxes.TaxHistoryObject;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public interface InvoiceDatabaseSaver {
    long save(Invoice invoice) throws InvalidInvoiceException;
}
