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

        Tax otherDemoTax = HelperMethods.createOtherDemoTax();
        validator.addTaxes(otherDemoTax);

        Tax goodDemoTax = HelperMethods.createGoodDemoTax();
        validator.addTaxes(goodDemoTax);


        // first Invoice
        Sellable steak, coke, water, partypizza;
        try {
            steak = sellableFactory.create(10);
            coke = sellableFactory.create(70);
            water = sellableFactory.create(71);
            partypizza = sellableFactory.create(1002);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Some products were not found");
            throw e;
        }

        Invoice invoice = new Invoice(validator, new ItemInfo(steak, 2), new ItemInfo(coke, 2), new ItemInfo(partypizza, 1));
        invoice.addItem(new ItemInfo(water, 1));

        invoice.modifyItemQuantity(1, 3);

        try {
            invoice.validate();
        }
        catch (InvalidInvoiceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------");
        System.out.println(invoice.toString());

        //Second Invoice

        Invoice invoice2 = new Invoice(validator, new ItemInfo(steak, 1), new ItemInfo(coke, 1), new ItemInfo(partypizza, 3));
        invoice2.addItem(new ItemInfo(water, 5));


        try {
            invoice2.validate();
        }
        catch (InvalidInvoiceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------");
        System.out.println(invoice2.toString());









    }
}
