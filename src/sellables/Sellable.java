package sellables;

import taxes.TributaryCategory;

import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
public abstract class Sellable {
    private SellableInfo _sellableInfo;
    private Map<Sellable, Float> _components;

    public Sellable(SellableInfo sellableInfo) {
        _sellableInfo = sellableInfo;
    }


    public float getPrice() {

        return _sellableInfo.getPrice();
    }

    public void addComponent(Sellable sellable, float quantity) {
        Float oldValue = _components.get(sellable);
        _components.put(sellable, oldValue == null ? quantity : oldValue + quantity);
    }

    public void removeComponent(Sellable sellable) {
        _components.remove(sellable);
    }

    @Override
    public boolean equals(Object other)
    {
        if(other.getClass() != getClass()) return false;
        return ((Sellable) other)._sellableInfo.getId() == _sellableInfo.getId();
    }

    public TributaryCategory getTributaryCategory() {
        return _sellableInfo.getTributaryCategory();
    }
}
