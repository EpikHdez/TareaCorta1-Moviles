package erickhdez.com.currencyconverter.converters;

/**
 * Created by erickhdez on 20/2/18.
 */

public interface IConverter {
    double EXCHANGE_RATE = 580;

    double convert(double amount);
}
