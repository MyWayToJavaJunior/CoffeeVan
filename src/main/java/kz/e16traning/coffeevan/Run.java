package kz.e16traning.coffeevan;

import kz.e16traning.coffeevan.exception.ArgsCheckException;
import kz.e16traning.coffeevan.goods.coffee.Coffee;
import kz.e16traning.coffeevan.storage.action.*;
import kz.e16traning.coffeevan.storage.Van;

/**
 * Точка входа
 */
public class Run {
    public static void main(String[] args) {
        ArgsChecker argsChecker = null;
        try {
            argsChecker = new ArgsChecker(args);
        } catch (ArgsCheckException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Van van = new Van(argsChecker.getVolumeOfVan());
        Loader loader = new Loader("random", van,
                argsChecker.getCostOfVan(),
                Coffee.class.getClass());
        loader.load();
        System.out.println(van);
        System.out.println("Total volume: " + van.getTotalVolume()
                + " / Used volume: " + van.getUsedVolume());
        System.out.println("Total money: " + loader.getTotalMoney()
                + " / Used money: " + loader.getUsedMoney());
        System.out.println("\nafter sort by "
                + argsChecker.getTypeOfSort() + ": ");
        Sorter sorter = new Sorter(argsChecker.getTypeOfSort(), van);
        sorter.sort();
        System.out.println(van);
        System.out.println("\nfound by " + argsChecker.getTypeOfFind()
                + ": [" + argsChecker.getStartOfFind() + " - "
                + argsChecker.getEndOfFind() + "]");
        Finder finder = new Finder(van, argsChecker.getTypeOfFind(),
                argsChecker.getStartOfFind(), argsChecker.getEndOfFind());
        System.out.println(finder.found());
    }
}
