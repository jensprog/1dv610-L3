# Chapter 2
## Use Intention-Revealing Names
I believe I have done a good job with the naming of both classes and methods. I have done a better job at it in L3 than in L2 in my opinion. Something that I've learned is that it is easier to name a class or method if you have a clear plan before on what the class responsibility is and what behaviour it should have. 
Overall this chapter have helped me a lot regarding pointing out the "why" to why I've always thought it has been hard to name things in my code. 
- **L3**: [Naming](images/ControllerAndMethodsNaming.png)

# Chapter 3
## Small!
I have not refactored any methods in this regard because of time contraint, but I think I have done an OK job with not having too large methods in both L2 and L3. L3 is implemented better in this regard in my opinion but the codebase is also smaller than in L2. 

## Use Descriptive Names
I have done a better job of this in L3 than in L2 in my opinion. Both laborations have OK naming (in regards to what the method is doing) but sometimes I've lost track and included validation inside a method. Have had classes with both a data structure to hold data and a behaviour. If I would really go through each method I have I would probably break this rule somehow, since everything can always be improved.
- **L3**: [MethodNames](images/DescripticNames.png)

# Chapter 4
## Informative Comments
I believe the comments I've used in L2 and L3 are informative, I have only used JavaDoc at the top of the class to give myself and other users a "smooth entrance" to the class.
I understand the concepts of the book regarading comments, they can lie and mislead you, which I've done countless of times during my education so far. So I have not used any line comments since I've been really bad in the past to update them whenever I've changed something in a class or method.
- **L2**: [ClassComment](images/CommentOfClass.png)

## TODO Comments
I liked the part where you (Daniel) told us about how you used them, which I thought was a clever way to know where you left off the last time. I have not used TODO comments that often so far, but I think I might do in the future. The only thing I would have to also practice is to actually remove comments when they're not useful anymore.

## Explain YourSelf In Code
I liked this part in the book, instead of explaining what the method below your comment is doing, spend those seconds on renaming the method instead so the method itself can explain what it does. Sometimes I feel like it helps me at the time writing a Javadoc or line comments, but the trade-offs might be worse in the long run when reading the book from a person with a lot of experience.

# Chapter 5
## Vertical Openness Between Concepts:
I always separate class declaration, constructor and methods with blank lines, formatting is really useful to increase readability of the code and I've never been afraid to use whitespaces.
The package and import formatting is based on checkstyles order which is alphabetic.
- **L2**: [VerticalFormatting](images/VerticalFormatting.png)

## Horizontal Formatting:
Since I use checkstyle, the limit is 100 as default (I changed to 120) characters.
One thing I do not mind personally is if prints are longer, I don't like when they break into another line, harder to read for me personally.
I have quite a large monitor, so naturally a longer horizontal line is not as problematic for me as for someone maybe using a 14" laptop.

# Chapter 6
## Hybrids
Before I read chapter 6 I had not thought of this concept, to not mix data structures and objects. In this case it is clear that the ConversionResult holds the output data from the conversion, and that's what it should do. Before I read the chapter I mixed the the class with calling the convert-method from the service class, which creates a hybrid class.

ConversionResult as a data structure, not mixed with behaviour like an object
- **L3**: [ConversionResult DTO](images/ConversionResult.png)

UnitTypeDetector is a validation class that has public methods since they're used in the UnitConversionService class. The validation was in the UnitConversionService class before.
- **L2**: [UnitTypeDetector](images/UnitTypeDetector.png)

## Data/Object Anti-Symmetry
UnitConversionService hides interal implementation through private fields and methods, only exposing the behaviour which is convert() for the public interface. Before I redesigned it, the service class contained the validation of each unit as well, which is now separated as stated before in the UnitTypeDetector class.
- **L2**: [UnitConversionService](images/UnitConversionService.png)

## Data Abstraction
I have used getters and setters everywhere, have not thought about it that much since I've always thought it was "standard". I'm thinking more in terms of "If I want to access this class private variables in another class, I need getters and setters, because otherwise I'm restricted." Probably just a beginner mindset, not having a good plan for the class in regards to which other class should have the rights to access it's private variables or should this class only expose it's behaviour.

# Chapter 7
## Provide Context With Exceptions
Could create a custom exception like "UnitConversionException" or something that has a more meaningful name than "IllegalArgumentException".
This exception is thrown in each unitconverter class inside L2, that's why I believe it would be more useful with a custom exception instead.
- **L2**: [Exception](images/IllegalArgumentException.png)

## Define Exception Classes In Terms Of A Caller's Needs
This points, I believe to the above principle, I want to throw an exception that is defined for what's it's actually throwing. Making it easier for other developers to understand the exact exception, instead of "IllegalArgumentException" for every exception in the project.

## Write Your Try-Catch-Finally Statement First
This seems interesting and I want to try that, I guess the next course is about TDD and I hope we can focus on trying to write code using that principle. So far I've just had manual unit tests and tried JUnit and Jest for automated unit tests. Would be interesting to create a smaller project creating the tests first then the production code. 

# Chapter 8
## Using Third-Party Code
I use multiple Maps in my L2 module, all of them are private which avoids misuse of the collections. Since the Map package from Java (which I did not know before) have methods like clear() or remove(), I don't want external classes to be able to call such methods on the collection, risking losing the stored data.
- **L2**: [PrivateMap](images/VolumeMap.png)

## Exploring and Learning Boundaries
I thought I learned a bit about Spring framework, how to create a Spring Boot App etc, but when looking further into it, those frameworks do a lot of things and I realized that I would need to learn a lot more to understand everything each package does. 
I was amazed with Jakartas validation annotations, that the framework can handle those validations like that. I created my own using Springs validator package, since I had not read up on that part of the Jakarta framework that much and I thought it became a bit "cluttery" adding those annotations above the instance variables.
- **L3**: [JakartaValidation](images/JakartaValidationAnnotations.png)
- **L3**: [CustomValidation](images/SpringValidation.png)

# Chapter 9
## One Assert Per Test:
I had multiple asserts per test before I read this chapter and adding this chapter + feedback regarding these tests, I've changed most of them (except parser and some token tests) to only have one assert and have given them better naming to mirror what the test is about. Maybe it defeats the purpose of writing automated unit tests first, then the production code, since I changed the tests and added new once with current production code, but I thought that change could be good in this case for learning purposes.
- **L2**: [OneAssertPerTest](images/OneAssertPerTest.png)
- **L2**: [RefactoredUnitTests](images/RefactoredUnitTests.png)

## F.I.R.S.T:
My automated unit tests follow this principle, they returned PASSED/FAILED and no raw values. 

# Chapter 10
## Class Organization
I don't follow this rule, I immediatly thought of my UnitConversionService.java class, I have variables, constructor, private methods then the public method. From my understanding I should've switched the private methods with the public method to more follow the "step down rule" which he covers in chapter 3. My thought process is that all the private methods come first, then last the public method is "collecting" all the methods above and uses them.
- **L2**: [StepDownRule](images/Stepdownrule.png)

## Classes Should Be Small!
I learned something new, before this chapter I thought I would "count lines" like how the book covers how small a function should be (around 120 lines is my largest class) but I never thought of it's size by **responsibility**. That makes a lot of sense because when my classes have/had too many, I get frustrated because it gets too complex for me sometimes to follow the responsibilities and dependencies. 

# Chapter 11
## Dependency Injection
I used Spring Frameworks @Configuration and @Bean annotation for DI, Spring can then manage my module as an object for me. Injected in my RecipeConversionService that depends on it.
What I should've done in L2 is to create an Abstract Factory Pattern for my converter classes, doing the same thing as the Spring framework does for me in L3, but manually by myself.
- **L3**: [UnitConversionConfig](images/ConfigAndBean.png)

## Scaling up
I have defined two DTO's in L3, ConversionRequest and ConversionResult. They are kinda redudant but I figured it separates them quite good and was easy to name since they only do 1 thing.
If I had not read the book I would probably just have 1 class, but when using both it's easier to understand that one is storing the users input, the other is storing the result of the conversion.
- **L3**: [ConversionRequest](images/ConversionRequestChap11.png)
- **L3**: [ConversionResult](images/ConversionResultChap11.png)

## References Used In L3
Web Framework:
- https://spring.io/quickstart 
- https://spring.io/guides/gs/spring-boot
- https://spring.io/guides/gs/accessing-data-jpa/
- https://spring.io/guides/gs/handling-form-submission/
- https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html
- https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b
- https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/sessionattributes.html
- https://www.geeksforgeeks.org/advance-java/spring-boot-session-management/
- https://docs.spring.io/spring-framework/reference/core/validation/validator.html
- https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

Deploy: 
- https://docs.railway.com/guides/spring-boot#deploy-from-a-github-repo

Thymeleaf template (Server-side HTML processing): 
- https://www.baeldung.com/thymeleaf-in-spring-mvc

Bootstrap (Responsive UI): 
- https://getbootstrap.com/