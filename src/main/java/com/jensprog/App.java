package com.jensprog;

import com.jensprog.formatter.UnitConversionQueryFormatter;
import com.jensprog.parser.UnitConversionQueryParser;
import com.jensprog.unitconverter.UnitConversionService;

public class App {
    public static void main(String[] args) {
        UnitConversionQueryParser parser = new UnitConversionQueryParser("10 centimeters to inches");
        double value = parser.getValue();
        String fromUnit = parser.getFromUnit();
        String toUnit = parser.getToUnit();

        UnitConversionService service = new UnitConversionService();
        double result = service.convert(value, fromUnit, toUnit);

        UnitConversionQueryFormatter formatter = new UnitConversionQueryFormatter(value, fromUnit, result, toUnit);
        System.out.println(formatter.format());
    }
}
