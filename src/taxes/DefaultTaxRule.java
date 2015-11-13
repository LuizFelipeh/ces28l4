package taxes;

/**
 * Created by Felipeh on 12/11/2015.
 */
class DefaultTaxRule implements TaxRule {
    @Override
    public float calculate(TaxData taxData) {
        return 0;
    }
}
