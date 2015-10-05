package edu.kvcc.cis298.cis298assignment2;

// A class used to convert a temperature from one type to another
public class Converter {

    public static double convert(double temperature, TempType fromType,
                                 TempType toType) {
        double result = 0;

        // Do a conversion depending on the first type
        switch (fromType) {
            case CELSIUS:
                switch (toType) {
                    case CELSIUS:
                        // Was the same
                        result = temperature;
                        break;
                    case FAHRENHEIT:
                        result = temperature * 9 / 5 + 32;
                        break;
                    case KELVIN:
                        result = temperature + 273.15;
                        break;
                    case RANKIN:
                        result = (temperature + 273.15) * 9/5;
                        break;
                }
                break;
            case FAHRENHEIT:
                switch (toType) {
                    case CELSIUS:
                        result = (temperature - 32) * 5/9;
                        break;
                    case FAHRENHEIT:
                        // WAS THE SAME
                        result = temperature;
                        break;
                    case KELVIN:
                        result = (temperature + 459.67) * 5/9;
                        break;
                    case RANKIN:
                        result = temperature + 459.67;
                        break;
                }
                break;
            case KELVIN:
                switch (toType) {
                    case CELSIUS:
                        result = temperature - 273.15;
                        break;
                    case FAHRENHEIT:
                        result = temperature * 9 / 5 - 459.67;
                        break;
                    case KELVIN:
                        result = temperature;
                        break;
                    case RANKIN:
                        result = temperature * 9 / 5;
                        break;
                }
                break;
            case RANKIN:
                switch (toType) {
                    case CELSIUS:
                        result = (temperature - 491.67) * 5 / 9;
                        break;
                    case FAHRENHEIT:
                        result = temperature - 459.67;
                        break;
                    case KELVIN:
                        result = temperature * 5 / 9;
                        break;
                    case RANKIN:
                        result = temperature;
                        break;
                }
                break;
        }

        return result;

    }

    public static String getTemperatureSuffix(TempType tempType) {

        // The degree symbol
        String suffix = "\u00b0";

        // Concatenate a degree character depending on the temptype given
        switch(tempType) {
            case CELSIUS:
                suffix = suffix.concat("C");
                break;
            case FAHRENHEIT:
                suffix = suffix.concat("F");
                break;
            case KELVIN:
                suffix = suffix.concat("K");
                break;
            case RANKIN:
                suffix = suffix.concat("R");
                break;
        }

        // Return the suffix
        return suffix;
    }

    // Temperature types
    public enum TempType {
        CELSIUS, FAHRENHEIT, KELVIN, RANKIN
    }
}
