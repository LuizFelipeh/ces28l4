package sellables;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class SellableFactory {
    private SellableDatabase _database;

    public Sellable create(long id) throws ClassNotFoundException{
        SellableInfo info = _database.getByID(id);
        if(info.getSellableClass() == SellableClass.product)
            return new Product(info);
        else if(info.getSellableClass() == SellableClass.service)
            return new Service(info);
        throw new ClassNotFoundException();
    }

}
