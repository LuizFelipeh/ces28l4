package demos;

import taxes.TaxData;
import taxes.TaxHistoryObject;
import taxes.TaxRule;

import java.util.List;

/**
 * Created by Felipeh on 17/11/2015.
 */
public class HistoryDependantTaxRule implements TaxRule{
    @Override
    public float calculate(TaxData taxData) {
        List<TaxHistoryObject> history = taxData.getTaxHistory();
        //This rule is: If the consumer has paid more than 30 in taxes, he pays more 1000
        float taxValueHistory = 0;
        for (TaxHistoryObject h : history){
            taxValueHistory += h.getTaxValue();
        }
        if(taxValueHistory > 30) return 1000;
        else return 0;
    }
}
