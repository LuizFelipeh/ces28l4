package invoice;

import sellables.Sellable;
import taxes.TributaryCategory;

import java.util.Map;

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

    public Map<Sellable, Float> getChildComponents() {
        return _sellable.getChildComponents();
    }

    public float getQuantity() {
        return _quantity;
    }

    public float getPrice() {
        return _sellable.getPrice();
    }

    public String getName() { return _sellable.getName(); }

    public long getId() { return _sellable.getId(); }

    public TributaryCategory getTributaryCategory() {
        return _sellable.getTributaryCategory();
    }

    public void setQuantity(float quantity) {
        this._quantity = quantity;
    }
}
