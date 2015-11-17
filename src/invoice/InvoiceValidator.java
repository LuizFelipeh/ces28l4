package invoice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.Tax;
import taxes.TaxData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
class InvoiceValidator {
    private List<Tax> _taxes;
    private InvoiceDatabaseSaver _database;

    public boolean validate(TaxData taxData) {


        throw new NotImplementedException();
    }

    public void addTaxes(Tax... taxes) {
        _taxes.addAll(Arrays.asList(taxes));
    }
}
