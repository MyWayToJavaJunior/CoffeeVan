package kz.e16traning.coffeevan.goods.price;

import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;

import java.util.HashMap;
import java.util.Map;

/**
 * Цены на грамм кофе.
 *
 */
public class PriceOfCoffee {
    private final Map<CoffeeType, Double> priceOfCoffee;


    public PriceOfCoffee() {
        priceOfCoffee = new HashMap<>();
        priceOfCoffee.put(CoffeeType.ARABICA, Double.valueOf(2));
        priceOfCoffee.put(CoffeeType.ROBUSTA, Double.valueOf(4));
        priceOfCoffee.put(CoffeeType.LIBERICA, Double.valueOf(8));
    }

    public Map<CoffeeType, Double> getPrice() {
        return this.priceOfCoffee;
    }

}
