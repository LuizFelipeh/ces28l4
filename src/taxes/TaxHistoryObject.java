package taxes;

import java.util.Date;

/**
 * Created by Felipeh on 13/11/2015.
 */
public class TaxHistoryObject {
    private float _total;
    private Date _submissionDate;
    private float _taxValue;

    public float getTotal() {
        return _total;
    }

    public float getTaxValue() {
        return _taxValue;
    }

    public Date getSubmissionDate() {
        return _submissionDate;
    }

    public TaxHistoryObject(float total, Date submissionDate, float taxValue){
        _total = total;
        _submissionDate = submissionDate;
        _taxValue = taxValue;
    }
}
