package kz.e16traning.coffeevan.exception;

/**
 * ������ ��� �������� ��� �� �����
 */
public class LoadPriceFromFileException extends Exception{
    public LoadPriceFromFileException() {
        super("Cant load price from file");
    }
}
