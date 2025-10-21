# Developer Guide

## Get Started

1. Fork the repository https://github.com/jensprog/1dv610-L3.git

2. Run the command below (insert your Github account name instead of "your-username") to your local machine so you can work on your own copy.

```bash
git clone https://github.com/your-username/1dv610-L3.git
```

3. Follow the steps below to install the necessary packages.

Developers need to install Java version 21.

```bash
# Ubuntu/Debian
sudo apt update && sudo apt install openjdk-21-jdk
```

```bash
# macOS (Homebrew)
brew install openjdk@21
```

```bash
# Windows
- Download from https://www.oracle.com/java/technologies/downloads/
# Or use Package Manager
choco install openjdk21
```

4. When you've done any changes and pushed them to your fork, you can create a Pull Request to my repository and then I'll look into it and either accept, decline or request changes.

## Dependencies

Check the **build.gradle** file for dependencies used. 

The application is using a module I created in another assignment in school, right now the application is only using the "UnitConversionService" for calculation. 
- [Module](https://github.com/jensprog/1dv610-L2)

## Run The App

The application is using Springs webstarter package, just type **./gradlew bootRun** in your terminal and it will run at localhost:8080.
To compile the source code and check for errors run **./gradlew build**.


## Core functionality

The application is a Recipe Converter (you can check the screenshots in the readme for example usage). The purpose is to convert different units between eachother if you're not familiar with the units on, for example, the cookbook you're using. It is then stored in the session so users can do multiple conversion to complete the whole recipe. 

### UnitConversionConfig
- Used for dependency injection in the RecipeConversionService class.

### HomeController
- Simple controller that returns the home page. 

### RecipeConverterController
- The controller with most flow control, it returns the converison form for the user when visiting /convert.
- Validates the user input
- It handles the POST-request and gets the list from the session, updates it with the new result, stores the updated list in the session and redirects to /convert.
- Handles exceptions for incompatible units, e.g. "Kilogram -> Gallon". 

### SessionController
- Handles GET-request to the /history URL where the stored conversion exists.
- Handles POST-requests for removing a specific conversion.
- Handles POST-requests for clearing the whole list of conversions.

### IncompatibleUnitException
- Extends the RuntimeException super class from the Java lang package.
- Custom exception to specify the exception that is thrown, easier for other devs to understand instead of the default "IllegalArgumentException". 

### ConversionRequest
- DTO for storing the users input, used to in the RecipeConversionService for calculation of the input.

### ConversionResult
- DTO for storing the output after RecipeConversionService have calculated the request.

### RecipeConversionService
- Using the module I created in the 1dv610-L2 project to calculate the conversion. 
- Returns a ConversionResult object which is handled in the RecipeConverterController.

### SessionStorageManagement
- Handles the list of ConversionResult to be stored in session storage.
- Checks if there's a conversion history or if it's empty.
- Logic for removing specific conversions.
- Logic for clearing the whole history of conversions.

### RequestValidator
- Implements the Validator package from the Spring framework.
- Custom validation class which is used in the RecipeConverterController to check if the user input is valid or not.

### HTML Templates
- index.html which is the view of the home page of the application.
- convert.html which is the view of the conversion form that users use for the input.
- history.html which is the view of the history of conversions made during the session.


## Future For The Application
- It's not a large application at the moment and it's not using the full potential of the module from the 1dv610-L2 project. Could be extended with the input parsing and formatting.
- Could have improved CSS for better and more visually pleasing UI. 
- The list stored in session storage should have different tables for different recipes.
- Should extend from session storage to a database (PostgreSQL for example) so users can actually close their browser without losing data.
- Should implement register and login forms and authentication for it, to be able to use a relational database. 

