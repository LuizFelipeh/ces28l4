package sellables;

/**
 * Created by Felipeh on 11/11/2015.
 */
public interface SellableDatabase {
    SellableInfo getByID(long id);
    void save(SellableInfo info);
}
