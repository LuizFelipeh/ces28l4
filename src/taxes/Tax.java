package taxes;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Tax {
    private String _taxName;
    private List<TaxRule> _rules;
    private static TaxRule defaultTaxRule;
    private boolean _usingDefault = true;

    public Tax(String name)
    {
        defaultTaxRule = new DefaultTaxRule();
        _taxName = name;
        _rules = new ArrayList<>();
    }


    public void addRule(TaxRule rule) {
        _rules.add(rule);
    }

    public float calculate(TaxData taxData) {
        float taxValue = 0;
       for (TaxRule rule:_rules){
            taxValue += rule.calculate(taxData);
        }

        if(_usingDefault) taxValue += defaultTaxRule.calculate(taxData);
        return taxValue;
    }

    public void useDefault(boolean value) {
        _usingDefault = value;
    }

    public static void setDefault(TaxRule taxRule) {
        defaultTaxRule = taxRule;
    }

    public String getTaxName() {
        return _taxName;
    }

}
