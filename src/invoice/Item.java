package invoice;


import sellables.Sellable;
import taxes.Taxable;
import taxes.TributaryCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Item implements Taxable {
    private ItemInfo _info;

    public Item(ItemInfo itemInfo) {
        _info = itemInfo;
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

    public List<Taxable> getAll() {
        List<Taxable> result = new ArrayList<>();
        Map<Sellable, Float> children = _info.getChildComponents();
        for (Map.Entry<Sellable, Float> entry : children.entrySet()) {
            ItemInfo info = new ItemInfo(entry.getKey(), _info.getQuantity()*entry.getValue());
            Item item = new Item(info);
            result.add(item);
        }
        return result;
    }

    public Map<Sellable, Float> getComponents() {
        return _info.getComponents();
    }

    public String toString() {
        return String.format("%10d", _info.getId()) + "  |  " + _info.getQuantity() + " | "+ String.format("%-50s", _info.getName()) + "  |  " + "$" + String.format("%.2f", getPrice()) + "\n";
    }

    public void setQuantity(float newQuantity) {
        _info.setQuantity(newQuantity);
    }

    public Sellable getSellable() {
        return _info.getSellable();
    }

}
