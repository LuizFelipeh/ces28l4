package invoice;


import taxes.Taxable;
import taxes.TributaryCategory;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Item implements Taxable {
    private ItemInfo _info;

    public Item(ItemInfo itemInfo) {
    }

    @Override
    public float getQuantity() {
        return 0f;
    }

    @Override
    public float getPrice() {
        return 0;
    }

    @Override
    public TributaryCategory getCategory() {
        return null;
    }

}
