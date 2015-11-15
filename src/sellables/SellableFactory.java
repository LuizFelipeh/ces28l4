package sellables;

import databases.SellableDBLocator;

import java.util.Map;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class SellableFactory {
    private SellableDatabase _database = SellableDBLocator.find();

    public Sellable create(long id) throws ClassNotFoundException{
        SellableInfo info = _database.getByID(id);
        Map<Integer, Float> componentIds = info.getComponentIds();
        if(info.getSellableClass() == SellableClass.product)
        {
            Product product = new Product(info);
            fillComponents(componentIds, product);
            return product;
        }

        else if(info.getSellableClass() == SellableClass.service)
        {
            Service service = new Service(info);
            fillComponents(componentIds, service);
            return service;
        }

        throw new ClassNotFoundException();
    }

    private void fillComponents(Map<Integer, Float> componentIds, Sellable sellable) throws ClassNotFoundException {
        for ( Map.Entry<Integer, Float> entry : componentIds.entrySet()){
            sellable.addComponent(create(entry.getKey()), entry.getValue());
        }
    }

}
