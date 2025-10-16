# Chapter 4

# Chapter 5
## Vertical Openness Between Concepts:
- I always separate class declaration, constructor and methods with blank lines.
- The package and import formatting is based on checkstyles order which is alphabetic.

## Horizontal Formatting:
- Since I use checkstyle, the limit is 100 as default (I changed to 120) characters.
- One thing I do not mind personally is if prints are longer, I don't like when they break into another line, harder to read for me personally.

# Chapter 6
## Hybrids
Before I read chapter 6 I had not thought of this concept, to not mix data structures and objects. In this case it is clear that the ConversionResult holds the output data from the conversion, and that's what it should do. Before I read the chapter I mixed the the class with calling the convert-method from the service class, which creates a hybrid class.
- ConversionResult as a datastructure, not mixed with behaviour like an object
[ConversionResult DTO](images/ConversionResult.png)

- UnitTypeDetector is a validation class that has public methods since they're used in the UnitConversionService class. The validation was in the UnitConversionService class before.
[UnitTypeDetector](images/UnitTypeDetector.png)

## Data/Object Anti-Symmetry
- UnitConversionService hides interal implementation through private fields and methods, only exposing the behaviour which is convert() for the public interface.
[UnitConversionService](images/UnitConversionService.png)

## Data Abstraction
- I have used getters and setters everywhere, have not thought about it that much since I've always thought it was "standard". I'm thinking more in terms of "If I want to access this class private variables in another class, I need getters and setters, because otherwise I'm restricted." Probably just a beginner mindset, not having a good plan for the class in regards to which other class should have the rights to access it's private variables or should this class only expose it's behaviour.