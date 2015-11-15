package sellables;

import taxes.TributaryCategory;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class SellableInfo {
    private final long _id;
    private final TributaryCategory _tributaryCategory;
    private final float _price;
    private final String _name;
    private final SellableClass _sellableClass;

    public SellableInfo(long id, TributaryCategory tributaryCategory, float price, String name, SellableClass sellableClass) {
        _id = id;
        _tributaryCategory = tributaryCategory;
        _price = price;
        _name = name;
        _sellableClass = sellableClass;
    }

    public SellableClass getSellableClass() {
        return _sellableClass;
    }

    public TributaryCategory getTributaryCategory() {
        return _tributaryCategory;
    }

    public float getPrice() {
        return _price;
    }

    public String getName() {
        return _name;
    }

    public long getId() {
        return _id;
    }
}
