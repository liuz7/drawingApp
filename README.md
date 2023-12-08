# Drawing App

### Usage
Since this is Maven base application, before run this application, please correctly setup 
the maven settings file and repo urls. JAVA SDK version should be above version 15.
* Run `mvn package` to build the jar in CLI.
* Run `java -jar target/drawingApp-0.0.1-SNAPSHOT.jar` to run this app.
* When prompts, please enter `C 20 4` to draw the Canvas.
* Enter `L 1 2 6 2` to draw the horizontal line.
* Enter `L 6 3 6 4` to draw the vertical line.
* Enter `R 16 1 20 3` to draw the rectangle.
* Enter `Q` to quit the app.

### Design
* Design the domain class like **Canvas, Line, Rectangle** to represent the draw components.
* Two drawing interfaces **CanvasInterface,ShapeInterface** are defined for drawing API.
* The **OutputWriter** is responsible for outputing the data to console and string.
* Internally use **char[][]** as actual data.
* Three exception type **NoCanvasException,NotSupportedException,OutOfCanvasException** are defined to handle the user exceptions.
* Units test cases are based on **Junit5** framework, including positive and negative test cases.



