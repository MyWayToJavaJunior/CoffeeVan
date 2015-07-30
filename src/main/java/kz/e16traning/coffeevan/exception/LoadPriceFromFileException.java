package kz.e16traning.coffeevan.exception;

/**
 * Ошибка при загрузке цен из файла
 */
public class LoadPriceFromFileException extends Exception{
    public LoadPriceFromFileException() {
        super("Cant load price from file");
    }
}
