package sellables;

import taxes.TributaryCategory;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class SellableInfo {
    private TributaryCategory _tributaryCategory;
    private float _price;
    private String _name;
    private SellableClass _sellableClass;

    public SellableClass getSellableClass() {
        return _sellableClass;
    }
}
