package databases;

import sellables.SellableDatabase;

/**
 * Created by gusta on 11/15/2015.
 */
public class SellableDBLocator {
    public static SellableDatabase find() {
        return MockSellableDB.getInstance();
    }
}
