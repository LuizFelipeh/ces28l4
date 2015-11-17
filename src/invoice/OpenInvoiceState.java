package invoice;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class OpenInvoiceState implements InvoiceState {

    @Override
    public long validate(InvoiceValidator invoiceValidator, Invoice invoice) throws InvalidInvoiceException {
        long id = invoiceValidator.validate(invoice);
        return id;
    }

    @Override
    public void addItem(List<Item> itemList, ItemInfo... itemInfo) {
        for (ItemInfo info : itemInfo) {
            Item item = new Item(info);
            itemList.add(item);
        }
    }

    @Override
    public void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException {
        checkIndex(itemList, index);
        Item item = new Item(itemInfo);
        itemList.set(index, item);
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
}
