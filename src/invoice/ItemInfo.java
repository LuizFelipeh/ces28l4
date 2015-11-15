package invoice;

import sellables.Sellable;
import taxes.TributaryCategory;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class ItemInfo {
    private Sellable _sellable;
    private float _quantity;

    public ItemInfo(Sellable sellable, float quantity) {
        _sellable = sellable;
        _quantity = quantity;
    }

    public float getQuantity() {
        return _quantity;
    }

    public float getPrice() {
        return _sellable.getPrice();
    }

    public TributaryCategory getTributaryCategory() {
        return _sellable.getTributaryCategory();
    }
}
