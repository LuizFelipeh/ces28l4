package taxes;


import java.util.List;

/**
 * Created by Felipeh on 11/11/2015.
 */
public class Tax {
    private java.util.List<TaxRule> _rules;
    private static TaxRule defaultTaxRule;
    private boolean _usingDefault = true;

    public Tax()
    {
        defaultTaxRule = new DefaultTaxRule();
    }


    public void addRule(TaxRule rule) {
    }

    public float calculate(TaxData taxData) {
        return 0;
    }

    public void useDefault(boolean value) {
    }

    public static void setDefault(TaxRule taxRule) {
    }
}
