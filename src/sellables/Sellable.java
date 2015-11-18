package sellables;

import taxes.TributaryCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
public abstract class Sellable {
    private SellableInfo _sellableInfo;
    private Map<Sellable, Float> _components;

    Sellable(SellableInfo sellableInfo) {

        _sellableInfo = sellableInfo;
        _components = new HashMap<>();
    }


    public float getPrice() {
        float totalPrice = _sellableInfo.getPrice();
        for (Map.Entry<Sellable, Float> entry : _components.entrySet()){
            Sellable component = entry.getKey();
            totalPrice += component.getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    public Map<Sellable, Float> getComponents(){
        return _components;
    }

    public Map<Sellable, Float> getChildComponents()
    {
        Map<Sellable, Float> retDict = new HashMap<>();
        if(!isComposite()){
            retDict.put(this, 1f);
        }
        for (Map.Entry<Sellable, Float> component : _components.entrySet())
        {
            Sellable componentSellable = component.getKey();
            Float componentQuant = component.getValue();

            // In case it is not a composite
            if(!componentSellable.isComposite())
            {
                Float oldValue = retDict.get(componentSellable);
                retDict.put(componentSellable, oldValue == null ? componentQuant : oldValue + componentQuant);
                continue;
            }

            // In case it is
            Map<Sellable, Float> childComponents = componentSellable.getChildComponents();;
            for (Map.Entry<Sellable, Float> childComponent : childComponents.entrySet())
            {
                Sellable childComponentSellable = childComponent.getKey();
                float childComponentQuant = childComponent.getValue() * componentQuant;
                Float oldValue = retDict.get(childComponentSellable);
                retDict.put(childComponentSellable, oldValue == null ? childComponentQuant : oldValue + childComponentQuant);
            }
        }
        return retDict;
    }

    private boolean isComposite()
    {
        return !_components.isEmpty();
    }

    public String getName() {
        return _sellableInfo.getName();
    }

    public long getId() {
        return _sellableInfo.getId();
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

    @Override
    public int hashCode()
    {
        return (int) _sellableInfo.getId();
    }

    public TributaryCategory getTributaryCategory() {
        return _sellableInfo.getTributaryCategory();
    }
}
