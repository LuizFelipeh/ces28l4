package sellables;

import taxes.TributaryCategory;

import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
class SellableInfo {
    private final long _id;
    private final TributaryCategory _tributaryCategory;
    private final float _price;
    private final String _name;
    private final SellableClass _sellableClass;
    private final Map<Integer, Float> _componentIdsMap;

    public SellableInfo(long id, TributaryCategory tributaryCategory, float price, String name, SellableClass sellableClass) {
        _id = id;
        _tributaryCategory = tributaryCategory;
        _price = price;
        _name = name;
        _sellableClass = sellableClass;
        _componentIdsMap = null;
    }

    public SellableInfo(long id, TributaryCategory tributaryCategory, float price, String name, SellableClass sellableClass, Map<Integer, Float> componentIds) {
        _id = id;
        _tributaryCategory = tributaryCategory;
        _price = price;
        _name = name;
        _sellableClass = sellableClass;
        _componentIdsMap = componentIds;
    }

    SellableClass getSellableClass() { return _sellableClass; }

    TributaryCategory getTributaryCategory() {
        return _tributaryCategory;
    }

    float getPrice() {
        return _price;
    }

    String getName() {
        return _name;
    }

    public long getId() {
        return _id;
    }

    Map<Integer, Float> getComponentIds() { return _componentIdsMap; }
}
