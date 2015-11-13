package sellables;

/**
 * Created by Felipeh on 11/11/2015.
 */
public abstract class Sellable {
    private SellableInfo _sellableInfo;
    private java.util.Map<Sellable, float> _components;

    public Sellable(SellableInfo sellableInfo) {
    }

    public float getPrice() {
        return 0;
    }

    public void addComponent(Sellable sellable, float quantity) {
    }

    public void removeComponent(long id) {
    }
}
