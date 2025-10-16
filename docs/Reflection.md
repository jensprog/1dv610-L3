# Chapter 2
# Chapter 3
## Small!
I have not refactored any methods in this regard because of time contraint, but I think I have done an OK job with not having too large methods in both L2 and L3. L3 is implemented better in this regard in my opinion but the codebase is also smaller than L2. 

## Use Descriptive Names
I have done a better job of this in L3 than in L2 in my opinion. Both laborations have OK naming (in regards to what the method is doing) but sometimes I've lost track and included validation inside a method, been having both a data structure to hold data and a behaviour. If I would really go through each method I have I would probably break this rule somehow, since everything can always be improved. 

# Chapter 4
## Informative Comments
I believe the comments I've used in L2 are informative, I have only used JavaDoc at the top of the class to give myself and other users a "smooth entrance" to the class.
I understand the concepts of the book regarading comments, they can lie and mislead you, which I've done countless of times during my education so far. So I have not used any line comments since I've been really bad in the past to update them whenever I've changed something in a method.
[ClassComment](images/CommentOfClass.png)

## TODO Comments
I liked the part where you (Daniel) told us about how you used them, which I thought was a clever way to know where you left off the last time. I have not used TODO comments that often so far, but I think I might do in the future. 

## Explain YourSelf In Code
I liked this part in the book, instead of explaining what the method below your comment is doing, spend those seconds on renaming the method instead so the method itself can explain what it does.

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
- UnitConversionService hides interal implementation through private fields and methods, only exposing the behaviour which is convert() for the public interface. Before I redesigned it, the service class contained the validation of each unit as well, which is now separated as stated before in the UnitTypeDetector class.
[UnitConversionService](images/UnitConversionService.png)

## Data Abstraction
- I have used getters and setters everywhere, have not thought about it that much since I've always thought it was "standard". I'm thinking more in terms of "If I want to access this class private variables in another class, I need getters and setters, because otherwise I'm restricted." Probably just a beginner mindset, not having a good plan for the class in regards to which other class should have the rights to access it's private variables or should this class only expose it's behaviour.

# Chapter 7
## Provide Context With Exceptions
- I'm throwing exceptions in both L2 and L3, could possible name which operations that failed, and also add more exceptions since I don't use them everywhere (Tokenizer.java in L2).

## Define Exception Classes In Terms Of A Caller's Needs
- I have redudant exceptions in L2 for the "toUnit" and "fromUnit", should be changed to a single exceptions called in each converter instead.
- Should add exception handlers to L2 and L3.

## Write Your Try-Catch-Finally Statement First
- This seems interesting and I want to try that, I guess the next course is about TDD and I hope we can focus on trying to write code using that principle.

# Chapter 8
## Using Third-Party Code
- I use multiple Maps in my L2 module, all of them are private which avoids misuse of the list.

## Exploring and Learning Boundaries
- I thought I learned a bit about Spring framework, how to create a Spring Boot App etc, but when looking further into it, those frameworks do a lot of things and I realized that I would need to learn a lot more to understand everything each package does.

# Chapter 9
## One Assert Per Test:
- I had multiple asserts per test before I read this chapter and adding this chapter + feedback regarding these tests, I've changed most of them (except parser and some token tests) to only have one assert and have given them better naming to mirror what the test is about. Maybe it defeats the purpose of writing automated unit tests first, then the production code, since I changed the tests and added new once with current production code, but I thought that change could be good in this case for learning purposes.
[OneAssertPerTest](images/OneAssertPerTest.png)
[RefactoredUnitTestsBefore](images/RefactoredUnitTests.png)

## F.I.R.S.T:
- My automated unit tests follow this principle, they returned PASSED/FAILED and no raw values. 

# Chapter 10