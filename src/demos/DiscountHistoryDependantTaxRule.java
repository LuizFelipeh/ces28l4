package demos;

import taxes.*;

import java.util.List;

/**
 * Created by Felipeh on 17/11/2015.
 */
public class DiscountHistoryDependantTaxRule implements TaxRule {
    @Override
    public float calculate(TaxData taxData) {
        List<TaxHistoryObject> history = taxData.getTaxHistory();
        //This rule is: If the consumer has paid more than 300 in raw price, he pays less 100
        float totalHistory = 0;
        for (TaxHistoryObject h : history) {
            totalHistory += h.getTotal();
        }
        if (totalHistory > 300) return -100;
        else return 0;
    }
}
