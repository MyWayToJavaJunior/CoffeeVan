package kz.e16traning.coffeevan;

import kz.e16traning.coffeevan.exception.ArgsCheckException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Чекер для входящих с
 * консоли параметров.
 *
 */
public class ArgsChecker {
    private int volumeOfVan;
    private double costOfVan;
    private String typeOfSort;
    private String typeOfFind;
    private double startOfFind;
    private double endOfFind;

    private boolean checkSort(String arg, String[] args) {
        Set<String> setOfSorts = new HashSet<>(
                Arrays.asList(args));
        return setOfSorts.contains(arg);
    }

    public int getVolumeOfVan() {
        return volumeOfVan;
    }

    public double getCostOfVan() {
        return costOfVan;
    }

    public String getTypeOfSort() {
        return typeOfSort;
    }

    public String getTypeOfFind() {
        return typeOfFind;
    }

    public double getStartOfFind() {
        return startOfFind;
    }

    public double getEndOfFind() {
        return endOfFind;
    }

    public ArgsChecker(String[] args) throws ArgsCheckException {
        if (args.length < 6 ||
                !checkSort(args[2], new String[]{
                        "volume", "cost", "wrap", "type", "condition"}) ||
                !checkSort(args[3], new String[]{
                        "volume", "cost"}))  {
            throw new ArgsCheckException();
        }
        try {
            volumeOfVan = Integer.valueOf(args[0]);
            costOfVan = Double.valueOf(args[1]);
            typeOfSort = args[2];
            typeOfFind = args[3];
            startOfFind = Double.valueOf(args[4]);
            endOfFind = Double.valueOf(args[5]);
        } catch (NumberFormatException e) {
            throw new ArgsCheckException();
        }
    }
}
