# BubbleBobble
A game based on javaFx

# Background

This is the coursework of DMS, original codes from the module conveners, refactor by Xueshan Chen.

# Usage

Download the project, build it and run the main function in `App.java` to start playing the game. You can use the "video" as an instruction.

# Structure

Following the MVC design pattern.

- `main.java.com.cw`

  - `controller`

    Contains all pages corresponding to the controller, linking `View` and `Model`.

  - `model`

    The underlying logic is implemented without direct contact with the page.

  - `utility`

    Tool classes, which can be reused in many classes.

  - `view`

    Calling static resources and generating pages.

  - `App.java`

  - `main.java`

- `main.test.java`

  test the java codes

  - `controllerTest`

    Test the controllers.

  - `modelTest`

    Test the model, the data flow.

  - `utilityTest`

    Test the utilities, play sound or store images.

  - `viewTest`

    Test the initial of the views.

# Refactor

- Using Maven in this project.
  - Easy management of extensions and dependencies
- Converting Swing project to JavaFX project.

## Design Patterns

- **Singleton pattern**: implemented in `Director.java`, this class has the only responsibility, which is to generate pages, the principle of single responsibility is followed.
- **Factory method pattern**: used when creating objects in the game, through `GameStore` to create the factories of each object. More classes, but easier to extend.
- **Strategy pattern**: used when the image of the object need to be redirected, using the enum `Direction`reduces conditional statements and facilitates extension and maintenance.
- **Observer pattern**: Observe all objects in the game in the class `GameObjectObserver`, listen and modify them. Reduce the coupling between classes.
- **Composite Pattern**: `InteractableWold` accesses instances of `GameObject`, and in combination with the Factory Method and Observer patterns, `GameObject` treats all similar objects in the game as one object, making high-level module calls simple.
- **MVC**: The whole project follows. Make the structure of the document clear and separate from each other.

## Code Smells

- Reconfiguration of the overlength methods.
- Use getters and setters to ensure encapsulation.
- No meaningless numbers are used rather static variables.

## Test 

Tests were designed for more than half of the classes, especially for the `utility` classes, and TDD was partially used during development to catch problems such as static resource path errors in a timely manner.



# Features

- The user can choose from three levels, from simple, medium and complex.
- Users can enter their username to get a feel for the game experience
- Users can choose from 4 different game characters
- Users can choose from 4 different game scenarios
- The user has 3 chances to die in each game
- Upgraded scoring system
- Upgraded front-end design to match user behaviours.

# Git

- master

- Design

- dev_v0.1

- refactor

  The refactoring process is mainly carried out on the refactor branch, followed by subsequent development on the design branch, and then merged to the main branch when all the refactoring is almost complete.

# Technology

- Maven
- JavaFX

### References

- https://www.geeksforgeeks.org/composite-design-pattern/



