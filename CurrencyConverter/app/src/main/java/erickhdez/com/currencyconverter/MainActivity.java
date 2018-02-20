package erickhdez.com.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import erickhdez.com.currencyconverter.converters.CToD;
import erickhdez.com.currencyconverter.converters.DToC;
import erickhdez.com.currencyconverter.converters.IConverter;

public class MainActivity extends AppCompatActivity {
    private IConverter converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        converter = new DToC();
    }

    public void radioRadiobuttonClicked(View view) {
        switch (view.getId()) {
            case R.id.radioDtoC:
                changeConverter("DToC");
                break;

            case R.id.radioCtoD:
                changeConverter("CToD");
                break;

            default:
                Toast.makeText(getApplicationContext(), R.string.noHandler, Toast.LENGTH_SHORT);
        }
    }

    private void changeConverter(String newConverter) {
        String packageName = IConverter.class.getPackage().getName();
        String converterName = packageName + "." + newConverter;

        try {
            IConverter temp = (IConverter) Class.forName(converterName).newInstance();
            converter = temp;
        } catch (Exception ex) {
            Log.d("InstanceException", ex.getMessage(), ex);
            Toast.makeText(getApplicationContext(), R.string.exchangeChangeError, Toast.LENGTH_SHORT);
        }
    }

    public void btnConvertClicked(View view) {
        EditText txtAmountInput = findViewById(R.id.txtAmountInput);
        TextView lblAmountConverted = findViewById(R.id.lblAmountConverted);

        String strAmount = txtAmountInput.getText().toString();
        double amount = Double.parseDouble(strAmount);
        double result = converter.convert(amount);
        String strResult = String.valueOf(result);

        lblAmountConverted.setText(strResult);
    }
}
