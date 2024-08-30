# Mars Rover Project

## Overview

The Mars Rover project simulates the movement and navigation of rovers on a Martian plateau. The rovers can be positioned on a grid, turned, and moved forward based on a series of instructions. The simulation checks if the rover's new positions are within the boundaries of the plateau.

## Features

- Define a plateau with specific dimensions.
- Place rovers on the plateau with initial positions and orientations.
- Control rover movement using commands: Left (L), Right (R), and Move Forward (M).
- Ensure rovers do not move outside the plateau boundaries.
- Get the final position and orientation of the rovers after executing commands.

## Technologies Used

- **Java**: Programming language used for implementation.
- **JUnit**: Testing framework used for unit testing.

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/jeremiahhaastrup/Mars_Rover.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd Mars_Rover
   ```

3. **Build the project**:

   Ensure you have [Maven](https://maven.apache.org/) installed. Run the following command to build the project:

   ```bash
   mvn clean install
   ```

   Alternatively, if you're using Gradle, run:

   ```bash
   ./gradlew build
   ```

## Usage

1. **Run the application**:

   After building the project, you can run the application with:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

   Or if you're using Gradle:

   ```bash
   ./gradlew run
   ```

2. **Provide Input**:

   The application will prompt you for inputs such as the plateau size, rover names, initial positions, and movement instructions. Follow the instructions provided by the application.

   - **Plateau Size**: Enter the width and height of the plateau.
   - **Rover Initial Position**: Enter the starting coordinates and direction (North (N), East (E), South (S), West (W)).
   - **Movement Instructions**: Enter a string of movement instructions (L, R, M):
     
     - L: Spins the Rover 90 degrees Left without moving from the current coordinate point
     - R: Spins the Rover 90 degrees Right without moving from the current coordinate point
     - M: Moves the Rover forward by one grid point, maintaining the same heading/orientation

## Testing

To run the unit tests, use Maven or Gradle:

- **With Maven**:

  ```bash
  mvn test
  ```

- **With Gradle**:

  ```bash
  ./gradlew test
  ```

The tests will validate the functionality of the `Plateau`, `Rover`, and `MissionControl` classes.

## Project Structure

- **`src/main/java/org/example/logic/`**: Contains the main classes for the logic of the simulation.
  - `Plateau.java`: Defines the plateau and its boundaries.
  - `Rover.java`: Defines the rover, its movements, and compass orientation.
  - `MissionControl.java`: Manages rovers and their interactions.
- **`src/test/java/org/example/logic/`**: Contains unit tests for the classes.
  - `PlateauTest.java`: Tests for the `Plateau` class.
  - `RoverTest.java`: Tests for the `Rover` class.
  - `MissionControlTest.java`: Tests for the `MissionControl` class.
- **`src/main/java/org/example/input/`**: Contains the parsing classes for the input of the simulation.
  - `PlateauParser.java`: Defines the plateau parser to establish boundaries.
  - `CompassParser.java`: Defines the compass parser to establish compass orientation.
  - `InstructionParser.java`: Defines the instruction parser to establish rover rotation and movement.
- **`src/test/java/org/example/input/`**: Contains unit tests for the classes.
  - `PlateauParserTest.java`: Tests for the `PlateauParser` class.
  - `CompassParserTest.java`: Tests for the `CompassParser` class.
  - `InstructionParserTest.java`: Tests for the `InstructionParser` class.
- **`src/main/java/org/example/type/`**: Contains enums and types used in the project.
  - `Compass.java`: Enum for compass directions.
  - `Instruction.java`: Enum for rover movement instructions.
  - `PlateauSize.java`: Enum for plateau coordinates.
- **`src/main/java/org/example/`**: Contains the main entry point for the application.
  - `Main.java`: Main class to run the application.

## Contributing

If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes. Ensure that you include tests for any new functionality or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Special thanks to all contributors and open-source libraries used in this project.

---

Feel free to adjust the content, especially the repository URL, license, and contributing section, according to your project's specific details and guidelines.
