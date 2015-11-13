import sellables.SellableDatabase;
import sellables.SellableInfo;

/**
 * Created by Felipeh on 13/11/2015.
 */
public class MockSellableDB implements SellableDatabase {
    @Override
    public SellableInfo getByID(long id) {
        return new SellableInfo();
    }
}
