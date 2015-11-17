package invoice;

import taxes.Tax;
import taxes.TaxData;
import taxes.TaxHistoryObject;
import taxes.Taxable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class InvoiceValidator {
    private List<Tax> _taxes;
    private InvoiceDatabaseSaver _databaseSaver;
    private InvoiceDatabaseHistory _databaseHistory;

    public InvoiceValidator(InvoiceDatabaseSaver _databaseSaver, InvoiceDatabaseHistory _databaseHistory) {
        this._databaseHistory = _databaseHistory;
        this._databaseSaver = _databaseSaver;
        _taxes = new ArrayList<>();
    }

    public long validate(Invoice invoice) throws InvalidInvoiceException, ImmutableObjectException {
        List<TaxHistoryObject> history = _databaseHistory.getHistory();
        List<Taxable> taxables = invoice.getTaxableList();
        TaxData taxData = new TaxData(taxables, history);
        for (Tax tax : _taxes) {
            float taxation = tax.calculate(taxData);
            invoice.applyTax(tax.getTaxName(), taxation);
        }
        return _databaseSaver.save(invoice);
    }

    public void addTaxes(Tax... taxes) {
        _taxes.addAll(Arrays.asList(taxes));
    }

}
