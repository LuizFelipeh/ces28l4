package taxes;

import taxes.TributaryCategory;

/**
 * Created by Felipeh on 12/11/2015.
 */
public interface Taxable {
    float getQuantity();

    float getPrice();

    TributaryCategory getCategory();
}
