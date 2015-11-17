package demos;

import databases.MockInvoiceDatabase;
import databases.MockSellableDB;
import invoice.*;
import sellables.Sellable;
import sellables.SellableFactory;
import taxes.Tax;
import java.util.List;

/**
 * Created by Lucas Muller on 17/11/2015.
 */
public class InvoiceDemo {
    public static void main(String[] args) throws ImmutableObjectException, ClassNotFoundException {
        // initialization
        MockSellableDB sellableDB = MockSellableDB.getInstance();
        HelperMethods.populateDemoSellableDB(sellableDB);
        SellableFactory sellableFactory = new SellableFactory(sellableDB);

        MockInvoiceDatabase invoiceDatabase = MockInvoiceDatabase.getInstance();
        InvoiceValidator validator = new InvoiceValidator(invoiceDatabase, invoiceDatabase);

        // add taxes to validator
        Tax demoTax = HelperMethods.createDemoTax();
        validator.addTaxes(demoTax);

        // first Invoice
        Sellable steak, coke, water;
        try {
            steak = sellableFactory.create(10);
            coke = sellableFactory.create(70);
            water = sellableFactory.create(71);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Some products were not found");
            throw e;
        }

        Invoice invoice = new Invoice(validator, new ItemInfo(steak, 2), new ItemInfo(coke, 2));
        invoice.addItem(new ItemInfo(water, 1));

        invoice.modifyItemQuantity(1, 2);

        try {
            invoice.validate();
        }
        catch (InvalidInvoiceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------");
        System.out.println(invoice.toString());









    }
}
