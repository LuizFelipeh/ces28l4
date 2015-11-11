package invoice;

/**
 * Created by Felipeh on 11/11/2015.
 */
public interface InvoiceState {
    void addItem(Invoice invoice, ItemInfo... iteminfo);

    void validate(Invoice invoice);
}
