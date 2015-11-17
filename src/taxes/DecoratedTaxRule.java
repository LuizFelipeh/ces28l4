package taxes;

/**
 * Created by Felipeh on 17/11/2015.
 */
public class DecoratedTaxRule implements TaxRule {
    @Override
    public float calculate(TaxData taxData) {
       return _decoratedTaxRule.calculate(taxData);
    }

    private TaxRule _decoratedTaxRule;

    public DecoratedTaxRule(TaxRule taxRule){
        _decoratedTaxRule = taxRule;
    }
}
