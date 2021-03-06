package demos;

import sellables.SellableClass;
import sellables.SellableDatabase;
import sellables.SellableInfo;
import taxes.Tax;
import taxes.TributaryCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gusta on 11/15/2015.
 */
public class HelperMethods {

    static void populateDemoSellableDB(SellableDatabase database) {
        //Add some info to DB
        database.save( new SellableInfo(10, TributaryCategory.food, 50, "Steak", SellableClass.product));
        database.save( new SellableInfo(11, TributaryCategory.food, 20, "Large Pizza", SellableClass.product));
        database.save( new SellableInfo(20, TributaryCategory.toys, 10, "Lego", SellableClass.product));
        database.save( new SellableInfo(21, TributaryCategory.toys, 2, "Playmobil", SellableClass.product));
        database.save( new SellableInfo(30, TributaryCategory.electronics, 2000, "Playstation", SellableClass.product));
        database.save( new SellableInfo(40, TributaryCategory.automobiles, 50000, "Toyota", SellableClass.product));
        database.save( new SellableInfo(50, TributaryCategory.clothes, 120, "Casaco Quicksilver", SellableClass.product));
        database.save( new SellableInfo(60, TributaryCategory.medicines, 20, "Tylenol 100mg", SellableClass.product));
        database.save( new SellableInfo(70, TributaryCategory.beverage, 6, "Coca Cola", SellableClass.product));
        database.save( new SellableInfo(71, TributaryCategory.beverage, 3, "Water", SellableClass.product));
        database.save( new SellableInfo(90, TributaryCategory.service, 5, "Delivery", SellableClass.service));

        //Adding a composite info with 0 base price and composition of other 2
        Map<Integer, Float> pizzaDeliveryMap = new HashMap<>();
        pizzaDeliveryMap.put(11, 1.0f);
        pizzaDeliveryMap.put(90, 1.0f);

        database.save(new SellableInfo(1000, TributaryCategory.service, 0, "One Large Pizza Delivery", SellableClass.service, pizzaDeliveryMap));

        // Creating a superb pizza delivery
        pizzaDeliveryMap = new HashMap<>();
        pizzaDeliveryMap.put(11, 5.0f);
        pizzaDeliveryMap.put(90, 1.0f);

        database.save(new SellableInfo(1001, TributaryCategory.service, 0, "Five Large Pizzas Delivery", SellableClass.service, pizzaDeliveryMap));

        pizzaDeliveryMap = new HashMap<>();
        pizzaDeliveryMap.put(1000, 5.0f);
        pizzaDeliveryMap.put(1001, 2.0f);

        database.save(new SellableInfo(1002, TributaryCategory.service, 0, "Party Pizza Delivery", SellableClass.service, pizzaDeliveryMap));



        //Adding a composite info (painting will have a base price plus the paint price plus the painters service price)
        int paintProductID = 70;
        int painterServiceID = 91;
        database.save(new SellableInfo(painterServiceID, TributaryCategory.service, 100, "Painter", SellableClass.service));
        database.save(new SellableInfo(painterServiceID, TributaryCategory.household, 30, "Paint", SellableClass.product));

        Map<Integer, Float> paintingServiceMap = new HashMap<>();
        paintingServiceMap.put(painterServiceID, 1.0f);
        paintingServiceMap.put(paintProductID, 2.5f);

        database.save(new SellableInfo(2001, TributaryCategory.service, 40, "Painting", SellableClass.service, paintingServiceMap));


    }

    static Tax createDemoTax (){
        Tax retTax = new Tax("Imposto Governo Malvado 1");
        System.out.println("Creating Tax");

        FoodTaxRule foodTax = new FoodTaxRule();
        retTax.addRule(foodTax);
        System.out.println("Creating FoodTaxRule and adding to the rules");

        ServiceTaxRule serviceTax = new ServiceTaxRule();
        retTax.addRule(serviceTax);
        System.out.println("Creating ServiceTaxRule and adding to the rules");


        return retTax;
    }

    static Tax createOtherDemoTax (){
        Tax retTax = new Tax("Imposto Governo Malvado 2");
        System.out.println("Creating Tax");

        HistoryDependantTaxRule historyTax = new HistoryDependantTaxRule();
        retTax.addRule(historyTax);
        System.out.println("Creating HistoryDependantTaxRule and adding to the rules");

        return retTax;
    }

    public static Tax createGoodDemoTax() {
        Tax retTax = new Tax("Imposto Governo Bonzinho 1");
        System.out.println("Creating Tax");

        DiscountHistoryDependantTaxRule discountTax = new DiscountHistoryDependantTaxRule();
        retTax.addRule(discountTax);
        System.out.println("Creating DiscountHistoryDependantTaxRule and adding to the rules");


        return retTax;
    }
}
