package invoice;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public interface InvoiceState {
    void addItem(List<Item> itemList, ItemInfo... iteminfo);

    void validate(Invoice invoice);

    void modifyItem(List<Item> itemList, int index, ItemInfo itemInfo) throws InvalidParameterException;

    void removeItem(List<Item> itemList, int index) throws InvalidParameterException;
}
