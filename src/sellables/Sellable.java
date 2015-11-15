package sellables;

import taxes.TributaryCategory;

import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
public abstract class Sellable {
    private SellableInfo _sellableInfo;
    private Map<Sellable, Float> _components;

    Sellable(SellableInfo sellableInfo) {
        _sellableInfo = sellableInfo;
    }


    public float getPrice() {
        float totalPrice = _sellableInfo.getPrice();
        for (Map.Entry<Sellable, Float> entry : _components.entrySet()){
            Sellable component = entry.getKey();
            totalPrice += component.getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    void addComponent(Sellable sellable, float quantity) {
        Float oldValue = _components.get(sellable);
        _components.put(sellable, oldValue == null ? quantity : oldValue + quantity);
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
