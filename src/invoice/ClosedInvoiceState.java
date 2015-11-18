package invoice;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class ClosedInvoiceState implements InvoiceState {

    @Override
    public long validate(InvoiceValidator invoiceValidator, Invoice invoice) throws InvalidInvoiceException {
        throw new InvalidInvoiceException("ID already exists");
    }

    @Override
    public void addItem(List<Item> itemList, ItemInfo... iteminfo) throws ImmutableObjectException {
        throw new ImmutableObjectException();
    }


    @Override
    public void modifyItemQuantity(List<Item> itemList, int index, float newQuantity) throws InvalidParameterException, ImmutableObjectException {
        throw new ImmutableObjectException();
    }

    @Override
    public void removeItem(List<Item> itemList, int index) throws InvalidParameterException, ImmutableObjectException {
        throw new ImmutableObjectException();
    }

    @Override
    public void applyTax(Map<String, Float> taxations, String taxName, float taxPrice) throws ImmutableObjectException {
        throw new ImmutableObjectException();
    }

    @Override
    public float getTaxation(Map<String, Float> taxations) {
        float taxation = 0;
        for (Map.Entry<String, Float> entry : taxations.entrySet()) {
            taxation += entry.getValue();
        }
        return  taxation;
    }

    public String toString(){
        return("Invoice currently closed for modification.\n");
    }

}
