package invoice;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class ClosedInvoiceState implements InvoiceState {
    @Override
    public void addItem(List<Item> itemList, ItemInfo... iteminfo) {

    }

    @Override
    public void validate(Invoice invoice) {

    }

    @Override
    public void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException {

    }

    @Override
    public void removeItem(List<Item> itemList, int index) throws InvalidParameterException {

    }
}
