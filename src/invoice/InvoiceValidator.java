package invoice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.Tax;
import taxes.TaxData;
import taxes.TaxHistoryObject;
import taxes.Taxable;

import java.lang.reflect.Constructor;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class InvoiceValidator {
    private List<Tax> _taxes;
    private InvoiceDatabaseSaver _databaseSaver;
    private InvoiceDatabaseHistory _databaseHistory;

    public InvoiceValidator(InvoiceDatabaseSaver _databaseSaver, InvoiceDatabaseHistory _databaseHistory) {
        this._databaseHistory = _databaseHistory;
        this._databaseSaver = _databaseSaver;
    }

    public long validate(Invoice invoice) throws InvalidInvoiceException {
        List<TaxHistoryObject> history = _databaseHistory.getHistory();
        List<Taxable> taxables = invoice.getTaxableList();
        TaxData taxData = new TaxData(taxables, history);
        for (Tax tax : _taxes) {
            float taxation = tax.calculate(taxData);
            invoice.applyTax(tax.getTaxName(), taxation);
        }
        long newID = _databaseSaver.save(invoice);
        return newID;
    }

    public void addTaxes(Tax... taxes) {
        _taxes.addAll(Arrays.asList(taxes));
    }
}
