# Drawing App

### Usage
Since this is Maven base application, before run this application, please correctly setup 
the maven settings file and repo urls. JAVA SDK version should be above version 15.
* Use IDE to import the project, and then run the main class.
* How to package as java jar to run.
  - Run `mvn package` to build the jar in CLI(Need to comment out some maven plugins in pom.xml).
  - Run `java -jar target/drawingApp-0.0.1-SNAPSHOT.jar` to run this app, or import into IDE to run it if there is any issue with jar.
  - Run `mvn test` to get the jacoco code coverage. The report is `target/site/jacoco/index.html`.
* When prompts, please enter `C 20 4` to draw the Canvas.
* Enter `L 1 2 6 2` to draw the horizontal line.
* Enter `L 6 3 6 4` to draw the vertical line.
* Enter `R 16 1 20 3` to draw the rectangle.
* Enter `Q` to quit the app.

### Design
* Design the domain class like **Canvas, Line, Rectangle** to represent the draw components.
* Design the reusable **drawLine(Canvas canvas, char horizontalSep, char verticalSep, ShapeArgument... plist)** in **Shape** abstract class, all drawing components will reuse this API to draw shapes.
* One unified drawing interfaces **void draw(ShapeArgument... plist)** in **ShapeInterface** are defined for drawing API for clients.
* The **OutputWriter** is responsible for outputing the data to console and string.
* Internally use **char[][]** as actual data.
* Design **ValidationStep** as validation chain to validate important cases in chain. 
* Three exception type **NoCanvasException,NotSupportedException,OutOfCanvasException** are defined to handle the user exceptions.
* Units test cases are based on **Junit5** framework, including positive and negative test cases.



