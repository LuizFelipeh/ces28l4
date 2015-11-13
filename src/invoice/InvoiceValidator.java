package invoice;

import taxes.Tax;

/**
 * Created by Felipeh on 11/11/2015.
 */
class InvoiceValidator {
    private java.util.List<Tax> _taxes;
    private InvoiceDatabaseSaver _database;

    public boolean validate(Invoice invoice) {
        return false;
    }

    public void addTaxes(Tax... tax) {
    }
}
