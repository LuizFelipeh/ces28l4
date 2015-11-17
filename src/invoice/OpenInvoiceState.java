package invoice;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class OpenInvoiceState implements InvoiceState {

    @Override
    public long validate(InvoiceValidator invoiceValidator, Invoice invoice) throws InvalidInvoiceException, ImmutableObjectException {
        return invoiceValidator.validate(invoice);
    }

    @Override
    public void addItem(List<Item> itemList, ItemInfo... itemInfo) {
        for (ItemInfo info : itemInfo) {
            Item item = new Item(info);
            itemList.add(item);
        }
    }

    @Override
    public void modifyItemQuantity(List<Item> itemList, int index, float newQuantity) throws InvalidParameterException {
        checkIndex(itemList, index);
        Item item = itemList.get(index);
        item.setQuantity(newQuantity);
    }

    @Override
    public void removeItem(List<Item> itemList, int index) throws InvalidParameterException {
        checkIndex(itemList, index);
        itemList.remove(index);
    }

    private void checkIndex(List<Item> itemList, int index) {
        if (index >= itemList.size())
            throw new InvalidParameterException();
    }

    @Override
    public void applyTax(Map<String, Float> taxations, String taxName, float taxPrice) {
        taxations.put(taxName, taxPrice);
    }

    @Override
    public float getTaxation(Map<String, Float> taxations) throws InvalidInvoiceException {
        throw new InvalidInvoiceException("Invoice was not taxed yet!");
    }
}
