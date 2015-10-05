package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TemperatureConverter extends AppCompatActivity {

    // Variables for holding view elements
    EditText convertEditText;
    RadioGroup firstRadioGroup;
    RadioGroup secondRadioGroup;
    Button convertButton;
    TextView convertResultTextView;

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



    }

    // Set first and second temp types according to what radio button was pressed.
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
            case R.id.rankin_1_radio_button;
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
            case R.id.rankin_2_radio_button;
                secondTempType = Converter.TempType.RANKIN;
                break;
        }
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
