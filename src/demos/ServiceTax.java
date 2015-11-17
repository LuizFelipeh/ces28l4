package demos;

import taxes.TaxData;
import taxes.TaxRule;
import taxes.Taxable;
import taxes.TributaryCategory;

import java.util.List;

/**
 * Created by Felipeh on 17/11/2015.
 */
public class ServiceTax implements TaxRule {
    @Override
    public float calculate(TaxData taxData) {
        List<Taxable> items = taxData.getTaxableList();
        float taxValue = 0;

        for (Taxable taxable : items) {
            if (taxable.getCategory() == TributaryCategory.service){
                float price = taxable.getPrice();
                float quantity = taxable.getQuantity();

                taxValue += quantity*(price/20);
            }
        }
        return taxValue;
    }
}
