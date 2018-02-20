package erickhdez.com.currencyconverter.converters;

/**
 * Created by erickhdez on 20/2/18.
 */

public final class CToD implements IConverter {
    @Override
    public double convert(double amount) {
        return amount / EXCHANGE_RATE;
    }
}
