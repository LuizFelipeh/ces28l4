package invoice;

import java.security.InvalidParameterException;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Invoice {
    private java.util.List<Item> _items;
    private InvoiceState _state;
    private long _id;
    private InvoiceValidator _validator;

    public Invoice(InvoiceValidator validator, ItemInfo... itemInfos) throws InvalidParameterException {
    }

    public void addItem(ItemInfo... itemInfo) {
    }

    public boolean validate() {
        return false;
    }

    public String toString() {
        return null;
    }
}
