package taxes;
import invoice.Item;

import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public interface TaxRule {
    float calculate(TaxData taxData);
}
