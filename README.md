# What is this project?
CRT Simulation
Given the length, plate separation, and potential difference across two horizontal parallel plates 
and the initial horizontal speed of an electron passing through the plates, calculate the electron's trajectory. 
Include calculations to verify that the electron's displacement is correct. 
What is the real-world relevance of such a calculation?
Assessment criteria: 
- Code is clear with comments and appropriate variable names
- Code can accept different inputs for given variables
- Output trajectory is clear and correct
- Calculations to verify the accuracy of the output are correct
- Identification of the real-world relevance is clear and correct

## How does this work / What is the structure for the program?
The project is started in main, which sets up the gui and contains Inputs and Animation
Inputs collects inputs from the user, and recalculates everything each time something new is entered by calling the Calculations file
Animation uses the data gathered from the user, and the calculations performed, and draws the motion of electron
All the data used throughout the program is stored in a file called GlobalVars

## What is the real world use of such a simulator?
While cathode ray tubes are rarely used today, they're an incredible invention that powered televisions 
and displays around the world. A simulator like this would be incredibly useful in finding the exact right specifications
to get an electron where it needs to be to display something accurately in a short amount of time.
This simulator is also an excellent tool to teach students (like myself) how electric fields interact with charges, and what
changing different variables will do to affect the final trajectory.

## Build and run the application
To build and run the development version of the desktop app, use the run configuration from the run widget
in your IDE’s toolbar or run it directly from the terminal:

- on macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```
*I recommended using java 21, other versions have not been tested