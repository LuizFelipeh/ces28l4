package invoice;

/**
 * Created by lucasmullerm on 17/11/2015.
 */
public class InvalidInvoiceException extends Exception {
    public InvalidInvoiceException() {
    }

    public InvalidInvoiceException(String message) {
        super(message);
    }
}
