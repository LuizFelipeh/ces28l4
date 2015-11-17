package taxes;

import java.util.List;

/**
 * Created by Felipeh on 13/11/2015.
 */
public class TaxData {
    private List<Taxable> _taxableList;
    private List<TaxHistoryObject> _taxHistory;

    public List<Taxable> getTaxableList() {
        return _taxableList;
    }

    public List<TaxHistoryObject> getTaxHistory() {
        return _taxHistory;
    }

    public TaxData(List<Taxable> invoiceTaxableList, List<TaxHistoryObject> taxHistoryList){
        _taxableList = invoiceTaxableList;
        _taxHistory = taxHistoryList;
    }
}
