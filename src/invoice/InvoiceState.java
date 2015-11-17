package invoice;

import taxes.TaxData;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
interface InvoiceState {

    boolean validate(TaxData taxData, InvoiceValidator invoiceValidator);

    void addItem(List<Item> itemList, ItemInfo... iteminfo);

    void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException;

    void removeItem(List<Item> itemList, int index) throws InvalidParameterException;

    void applyTax(Map<String, Float> taxations, String taxName, float taxPrice);
}
