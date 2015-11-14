package invoice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Invoice {
    private List<Item> _items;
    private InvoiceState _state;
    private long _id;
    private InvoiceValidator _validator;

    public Invoice(InvoiceValidator validator, ItemInfo... itemInfos) throws InvalidParameterException {
        _state = new OpenInvoiceState();
        _items = new ArrayList<Item>();
        addItem(itemInfos);
    }

    public void addItem(ItemInfo... itemInfo) {
        _state.addItem(_items, itemInfo);
    }

    public boolean validate() {
        throw new NotImplementedException();
    }

    public String toString() {
        throw new NotImplementedException();
    }

    public void modifyItem(int index, ItemInfo itemInfo) throws InvalidParameterException {
        _state.modifyItem(_items, index, itemInfo);
    }

    public void removeItem(int index) throws InvalidParameterException {
        _state.removeItem(_items, index);
    }
}
