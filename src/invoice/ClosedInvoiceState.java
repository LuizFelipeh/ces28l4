package invoice;

import taxes.TaxData;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class ClosedInvoiceState implements InvoiceState {

    @Override
    public boolean validate(TaxData taxData, InvoiceValidator invoiceValidator) {
        return false;
    }

    @Override
    public void addItem(List<Item> itemList, ItemInfo... iteminfo) {
        return;
    }


    @Override
    public void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException {
        return;
    }

    @Override
    public void removeItem(List<Item> itemList, int index) throws InvalidParameterException {
        return;
    }

    @Override
    public void applyTax(Map<String, Float> taxations, String taxName, float taxPrice) {
        return;
    }
}
