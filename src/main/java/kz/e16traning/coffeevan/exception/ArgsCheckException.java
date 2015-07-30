package kz.e16traning.coffeevan.exception;

/**
 * Ошибка при вводе данных
 */
public class ArgsCheckException extends Exception {
    public ArgsCheckException() {
        super("use: coffeevan-v1 volume " +
                "cost sort(volume/cost/wrap/type/condition)" +
                " found(volume/cost) startValue endValue");
    }
}
