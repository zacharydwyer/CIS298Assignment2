package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TemperatureConverter extends AppCompatActivity {

    // Variables for holding view elements
    EditText convertEditText;
    RadioGroup firstRadioGroup;
    RadioGroup secondRadioGroup;
    Button convertButton;
    TextView convertResultTextView;

    RadioButton celsius1RadioButton;
    RadioButton celsius2RadioButton;

    Converter.TempType firstTempType;
    Converter.TempType secondTempType;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        // Get references to view elements
        convertEditText = (EditText) findViewById(R.id.convert_edit_text);
        firstRadioGroup = (RadioGroup) findViewById(R.id.first_radio_group);
        secondRadioGroup = (RadioGroup) findViewById(R.id.second_radio_group);
        convertButton = (Button) findViewById(R.id.convert_button);
        convertResultTextView = (TextView) findViewById(R.id.convert_result_text_view);
        celsius1RadioButton = (RadioButton) findViewById(R.id.celsius_1_radio_button);
        celsius2RadioButton = (RadioButton) findViewById(R.id.celsius_2_radio_button);

        // Check the first radio buttons for default to avoid errors associated with no checked radio buttons
        celsius1RadioButton.toggle();
        celsius2RadioButton.toggle();

        // Handle what happens when the Convert button is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the number in the edittext field. It will definitely be a number, or be empty, since the inputType property is "number"
                Double valueInEditText = Double.parseDouble(convertEditText.getText().toString());

                // Is convertEditText empty?
                if (valueInEditText.toString().trim().equals("")) {

                    // Show error
                    Toast.makeText(TemperatureConverter.this, R.string.toast_error, Toast.LENGTH_SHORT).show();

                    // Reset the convertResultTextView to its default text
                    convertResultTextView.setText(R.string.convert_result_text_view_default_text);
                } else {

                    // There is a value in edittext. Set the from and to types by looking at the selected radio buttons.
                    getFromAndToTypes();

                    // Send over the value, as well as the from and to type, to the convert method in Converter, and hold onto it
                    Double conversionResult = Converter.convert(valueInEditText, firstTempType, secondTempType);

                    // Set text view to the converted result.
                    convertResultTextView.setText(buildResult(valueInEditText, conversionResult));
                }
            }
        });

    }

    // Set to and from temp types according to what radio button was pressed.
    private void getFromAndToTypes() {
        switch(firstRadioGroup.getCheckedRadioButtonId()) {
            case R.id.celsius_1_radio_button:
                firstTempType = Converter.TempType.CELSIUS;
                break;
            case R.id.fahrenheit_1_radio_button:
                firstTempType = Converter.TempType.FAHRENHEIT;
                break;
            case R.id.kelvin_1_radio_button:
                firstTempType = Converter.TempType.KELVIN;
                break;
            case R.id.rankin_1_radio_button:
                firstTempType = Converter.TempType.RANKIN;
                break;
        }
        switch (secondRadioGroup.getCheckedRadioButtonId()) {
            case R.id.celsius_2_radio_button:
                secondTempType = Converter.TempType.CELSIUS;
                break;
            case R.id.fahrenheit_2_radio_button:
                secondTempType = Converter.TempType.FAHRENHEIT;
                break;
            case R.id.kelvin_2_radio_button:
                secondTempType = Converter.TempType.KELVIN;
                break;
            case R.id.rankin_2_radio_button:
                secondTempType = Converter.TempType.RANKIN;
                break;
        }
    }

    // Creates a string depending on the values
    private String buildResult(Double firstValue, Double secondValue) {
        String result = "";

        // Create a new DecimalFormat to round the number to 1 decimal place
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        // Add first value
        result = result.concat(decimalFormat.format(firstValue));

        // Add first value's suffix dependent on the firstTempType set from radiobuttons
        result = result.concat(Converter.getTemperatureSuffix(firstTempType));

        // Add equal sign
        result = result.concat(" = ");

        // Add second value
        result = result.concat(decimalFormat.format(secondValue));

        // Add second value's suffix
        result = result.concat(Converter.getTemperatureSuffix(secondTempType));

        // Return the result
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
