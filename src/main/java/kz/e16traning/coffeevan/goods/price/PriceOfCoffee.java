package kz.e16traning.coffeevan.goods.price;

import kz.e16traning.coffeevan.exception.LoadPriceFromFileException;
import kz.e16traning.coffeevan.goods.coffee.type.CoffeeType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Цены на грамм кофе.
 *
 */
public class PriceOfCoffee {
    private final Map<CoffeeType, Double> priceOfCoffee;


    public PriceOfCoffee() throws LoadPriceFromFileException {
        priceOfCoffee = new HashMap<>();
        try {
            priceOfCoffee.putAll(LoadFormFile.getPrice());
        } catch (IOException e) {
            throw new LoadPriceFromFileException();
        }
    }

    public Map<CoffeeType, Double> getPrice() {
        return this.priceOfCoffee;
    }

    private static class LoadFormFile {
        private static Map<CoffeeType, Double> getPrice() throws IOException {
            Map<CoffeeType, Double> priceFromFile = new HashMap<>();
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("price.txt");
            properties.load(fis);
            priceFromFile.put(CoffeeType.ARABICA, Double.valueOf(properties.getProperty(CoffeeType.ARABICA.name())));
            priceFromFile.put(CoffeeType.ROBUSTA, Double.valueOf(properties.getProperty(CoffeeType.ROBUSTA.name())));
            priceFromFile.put(CoffeeType.LIBERICA, Double.valueOf(properties.getProperty(CoffeeType.LIBERICA.name())));
            return priceFromFile;
        }
    }

}
