package demos;


import databases.MockSellableDB;
import sellables.Sellable;
import sellables.SellableDatabase;
import sellables.SellableFactory;

import java.util.NoSuchElementException;


/**
 * Created by gusta on 11/15/2015.
 */
public class SellableDemo {

    public static void main(String [] args) throws ClassNotFoundException {
        System.out.println("Sellable Demo");

        SellableDatabase database = MockSellableDB.getInstance();
        SellableFactory factory =  new SellableFactory(database);
        HelperMethods.CreateDemoSellableDB(database);

        // We know some IDs from our Sellable DB so we will be getting some of ther
        Sellable steak = factory.create(10);
        System.out.println(steak.getName() + ": " + steak.getPrice() + " reais");

        Sellable pizza = factory.create(11);
        System.out.println(pizza.getName() + ": " + pizza.getPrice() + " reais");

        Sellable delivery = factory.create(90);
        System.out.println(delivery.getName() + ": " + delivery.getPrice() + " reais");

        Sellable pizzaDelivery = factory.create(1000);
        System.out.println(pizzaDelivery.getName() + ": " + pizzaDelivery.getPrice() + " reais");

        Sellable playstation = factory.create(30);
        System.out.println(playstation.getName() + ": " + playstation.getPrice() + " reais");

        // Although it is not supposed to bew in the scope of this demo, we will also show that the DB throws an exeption
        // for invalid ID

        try {
            factory.create(Long.MAX_VALUE);
        }
        catch (NoSuchElementException e)
        {
            System.out.print("Seu banco de dados funcionando direito: Nao tem preco");
        }


    }



}
