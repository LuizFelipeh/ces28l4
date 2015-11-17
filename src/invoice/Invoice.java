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

    public Invoice(InvoiceValidator validator, ItemInfo... itemInfos) throws InvalidParameterException {
        _state = new OpenInvoiceState();
        _items = new ArrayList<>();
        _taxations = new TreeMap<>();
        addItem(itemInfos);
    }

    public void addItem(ItemInfo... itemInfo) {
        _state.addItem(_items, itemInfo);
    }

    public boolean validate() {
        Map<Taxable, Float> taxableList = new TreeMap<>();
        for (Item item : _items) {

        }
        boolean validationOK = _state.validate(taxData, _validator);
        if (validationOK)
            _state = new ClosedInvoiceState();
        return validationOK;
    }

    void applyTax(String taxName, float taxPrice) {
        _state.applyTax(_taxations, taxName, taxPrice);
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
