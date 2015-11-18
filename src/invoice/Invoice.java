package invoice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import taxes.Taxable;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Invoice {
    private List<Item> _items;
    private InvoiceState _state;
    private long _id = -1;
    private InvoiceValidator _validator;
    private Map<String, Float> _taxations;
    private Date _date;

    public Invoice(InvoiceValidator validator, ItemInfo... itemInfos) throws InvalidParameterException, ImmutableObjectException {
        _state = new OpenInvoiceState();
        _items = new ArrayList<>();
        _taxations = new TreeMap<>();
        _validator = validator;
        if(itemInfos==null || itemInfos.length == 0){
            throw new InvalidParameterException("No items.");
        }
        addItem(itemInfos);
    }

    public void addItem(ItemInfo... itemInfo) throws ImmutableObjectException {
        _state.addItem(_items, itemInfo);
    }

    public long validate() throws InvalidInvoiceException, ImmutableObjectException {
        _id = _state.validate(_validator, this);
        _date = new Date();
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
        StringBuilder sb = new StringBuilder();
        sb.append(_state.toString());
        if(_id != -1)
        {
            sb.append("Invoice ID Number " + _id + "\n");
            sb.append("Emited at: " + getDate() + "\n\n");
        }
        for (Item item : _items) {
            sb.append(item.toString());
        }
        sb.append("    |  " + "       Partial Value  |  " + "$").append(String.format("%.2f", getTotal())).append("\n");

        sb.append("\nTaxes:\n");
        for (Map.Entry<String, Float> entry : _taxations.entrySet()) {
            sb.append(String.format("   %20s", entry.getKey()));
            sb.append(" |  ");
            sb.append(String.format("$%.2f\n", entry.getValue()));
        }

        float taxation;
        try {
             taxation = getTaxation();
            sb.append("    |  " + "           Tax Value  |  " + "$").append(String.format("%.2f", taxation)).append("\n");

            sb.append("    |  " + "         Total Value  |  " + "$").append(String.format("%.2f", getTotal() + taxation)).append("\n");
        } catch (InvalidInvoiceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void modifyItemQuantity(int index, float newQuantity) throws InvalidParameterException, ImmutableObjectException {
        _state.modifyItemQuantity(_items, index, newQuantity);
    }

    public void removeItem(int index) throws InvalidParameterException, ImmutableObjectException {
        _state.removeItem(_items, index);
    }

    public float getTotal() {
        float total = 0;
        for (Item item : _items) {
            total += item.getPrice();
        }
        return total;
    }

    public float getTaxation() throws InvalidInvoiceException {
        return _state.getTaxation(_taxations);
    }

    public Date getDate() {
        return _date;
    }
}
