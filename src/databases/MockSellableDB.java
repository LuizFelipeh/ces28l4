package databases;

import sellables.SellableClass;
import sellables.SellableDatabase;
import sellables.SellableInfo;
import taxes.TributaryCategory;

import java.util.*;

/**
 * Created by Felipeh on 13/11/2015.
 */
public class MockSellableDB implements SellableDatabase {

    // Singleton
    private static MockSellableDB _instance = new MockSellableDB();

    public static MockSellableDB getInstance() { return _instance; }

    private MockSellableDB(){
    }

    private List<SellableInfo> databaseInfo = new ArrayList<SellableInfo>();

    @Override
    public SellableInfo getByID(long id) {
        for (SellableInfo info :
                databaseInfo) {
            if (info.getId() == id) return info;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void save(SellableInfo info) {
        databaseInfo.add(info);
    }
}
