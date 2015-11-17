package invoice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.Taxable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Invoice {
    private List<Item> _items;
    private InvoiceState _state;
    private long _id;
    private InvoiceValidator _validator;
    private Map<String, Float> _taxations;

    public Invoice(InvoiceValidator validator, ItemInfo... itemInfos) throws InvalidParameterException, ImmutableObjectException {
        _state = new OpenInvoiceState();
        _items = new ArrayList<>();
        _taxations = new TreeMap<>();
        addItem(itemInfos);
    }

    public void addItem(ItemInfo... itemInfo) throws ImmutableObjectException {
        _state.addItem(_items, itemInfo);
    }

    public long validate() throws InvalidInvoiceException {
        _id = _state.validate(_validator, this);
        _state = new ClosedInvoiceState();
        return _id;
    }

    public List<Taxable> getTaxableList() {
        List<Taxable> taxableList = new ArrayList<>();
        for (Item item : _items) {
            taxableList.addAll(item.getAll());
        }
        return taxableList;
    }

    void applyTax(String taxName, float taxPrice) throws ImmutableObjectException {
        _state.applyTax(_taxations, taxName, taxPrice);
    }

    public String toString() {
        throw new NotImplementedException();
    }

    public void modifyItem(int index, ItemInfo itemInfo) throws InvalidParameterException, ImmutableObjectException {
        _state.modifyItem(_items, index, itemInfo);
    }

    public void removeItem(int index) throws InvalidParameterException, ImmutableObjectException {
        _state.removeItem(_items, index);
    }
}
