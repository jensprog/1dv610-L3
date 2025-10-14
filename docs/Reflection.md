# Hybrids chapter 6
- ConversionResult as a datastructure, not mixed with behaviour like an object:
[ConversionResult DTO](images/ConversionResult.png)
- Moved the methods from the UnitConversionService class to a separate, service class only handles conversion now and no validation.
[UnitTypeDetector](images/UnitTypeDetector.png)