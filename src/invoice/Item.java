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
        return _info.getQuantity();
    }

    @Override
    public float getPrice() {
        return _info.getQuantity() * _info.getPrice();
    }

    @Override
    public TributaryCategory getCategory() {
        return _info.getTributaryCategory();
    }

}
