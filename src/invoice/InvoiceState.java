package invoice;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
interface InvoiceState {

    long validate(InvoiceValidator invoiceValidator, Invoice invoice) throws InvalidInvoiceException;

    void addItem(List<Item> itemList, ItemInfo... itemInfo) throws ImmutableObjectException;

    void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException, ImmutableObjectException;

    void removeItem(List<Item> itemList, int index) throws InvalidParameterException, ImmutableObjectException;

    void applyTax(Map<String, Float> taxations, String taxName, float taxPrice) throws ImmutableObjectException;
}
