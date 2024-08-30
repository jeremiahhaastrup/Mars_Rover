package org.example;

import org.example.input.CompassParser;
import org.example.input.InstructionParser;
import org.example.input.PlateauParser;
import org.example.logic.MissionControl;
import org.example.logic.Plateau;
import org.example.logic.Position;
import org.example.logic.Rover;
import org.example.type.Compass;
import org.example.type.Instruction;
import org.example.type.PlateauSize;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlateauParser plateauParser = new PlateauParser();
        CompassParser compassParser = new CompassParser();
        InstructionParser instructionParser = new InstructionParser();

        try {
            System.out.println("Enter the First Rovers Name:");
            String firstRover = scanner.nextLine();
            System.out.println("Rover " + firstRover + " has been added!🚙");

            Plateau plateau = null;
            while (plateau == null) {
                try {
                    Thread.sleep(300);

                    System.out.println("Enter The Plateau Size (e.g., '5 5'):");
                    System.out.println("First Integer: Width");
                    System.out.println("Second Integer: Height");
                    String plateauInput = scanner.nextLine();

                    String[] plateauSizeInput = plateauInput.trim().split("\\s+");
                    if (plateauSizeInput.length != 2 ||
                            Integer.parseInt(plateauSizeInput[0]) <= 2 || Integer.parseInt(plateauSizeInput[1]) <= 2) {
                        throw new InputMismatchException("Please Enter Exactly Two Integers Separated By A Space and More Than 2.");
                    }
                    HashMap<PlateauSize, Integer> plateauHashMapSize = plateauParser.plateauInput(plateauInput);
                    plateau = new Plateau(plateauHashMapSize.get(PlateauSize.X), plateauHashMapSize.get(PlateauSize.Y));
                } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Incorrect Format Houston! Try Again.");
                } catch (NoSuchElementException e) {
                    System.err.println("No Input Provided. Please Provide The Plateau Size With Two Integers " + e);
                }
            }

            MissionControl missionControl = new MissionControl(plateau);

            Rover rover1 = null;
            while (rover1 == null) {
                try {
                    Thread.sleep(300);

                    System.out.println("Enter Rover " + firstRover + "'s" + " starting position and direction");
                    System.out.println("This Is Represented By Two Integers (X and Y Coordinates) and a Direction For The Rovers Starting Position (E.g. '5 5 W'):");
                    System.out.println("Key:");
                    System.out.println("W -> West");
                    System.out.println("E -> East");
                    System.out.println("N -> North");
                    System.out.println("S -> South");
                    String roverOnePositionInput = scanner.nextLine();

                    String[] positionInput = roverOnePositionInput.trim().split("\\s+");
                    if (positionInput.length != 3) {
                        throw new InputMismatchException("Please Two Integers (X and Y Coordinates) and a Direction For The Rovers Separated By Spaces.");
                    }

                    char compass = positionInput[2].charAt(0);
                    if (compass != 'N' && compass != 'E' && compass != 'S' && compass != 'W') {
                        throw new InputMismatchException("Invalid direction. Please enter one of the following: N, E, S, W.");
                    }

                    HashMap<Compass, Position> roverOnePosition = compassParser.compassInput(roverOnePositionInput);
                    Position position = roverOnePosition.values().iterator().next();

                    if (position.getX() < 0 || position.getX() >= plateau.getWidth() - 1 ||
                            position.getY() < 0 || position.getY() >= plateau.getHeight() - 1) {
                        throw new InputMismatchException("Rover's Initial Position Must Be Greater Than 2 And Less Than Plateau Size Minus 1 For Each Coordinate.");
                    }
                    rover1 = new Rover(roverOnePosition.keySet().iterator().next());
                    missionControl.addRoverToPlateau(firstRover, rover1, position);
                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.err.println("Incorrect Format Houston! Try Again.");
                } catch (NoSuchElementException e) {
                    System.err.println("No Input Provided. Please Provide The Plateau Size With Two Integers " + e);
                }
            }

            List<Instruction> roverOneInstructions = null;
            while (roverOneInstructions == null) {
                try {
                    Thread.sleep(300);

                    System.out.println("Enter The Movement Instructions For Rover " + firstRover + "'s");
                    System.out.println("Key:");
                    System.out.println("L -> Spins the Rover 90 degrees Left without moving from the current coordinate point.");
                    System.out.println("R -> Spins the Rover 90 degrees Right without moving from the current coordinate point");
                    System.out.println("M -> Moves the Rover forward by one grid point, maintaining the same heading/orientation");
                    String roverOneInstructionsInput = scanner.nextLine();

                    roverOneInstructions = instructionParser.instructionInput(roverOneInstructionsInput);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid instruction format. Please enter again.");
                } catch (Exception e) {
                System.err.println("No Input Provided. Please Provide The Rover With Instructions.");
                }
            }

            System.out.println("Enter the Second Rover's Name:");
            String secondRover = scanner.nextLine();
            System.out.println("Rover " + secondRover + " has been added!🚙");

            Rover roverTwo = null;
            while (roverTwo == null) {
                try {
                    Thread.sleep(300);

                    System.out.println("Enter Rover " + secondRover + "'s" + " starting position and direction");
                    String roverTwoPositionInput = scanner.nextLine();

                    String[] positionInput = roverTwoPositionInput.trim().split("\\s+");
                    if (positionInput.length != 3) {
                        throw new InputMismatchException("Please Two Integers (X and Y Coordinates) and a Direction For The Rovers Separated By Spaces.");
                    }

                    char compass = positionInput[2].charAt(0);
                    if (compass != 'N' && compass != 'E' && compass != 'S' && compass != 'W') {
                        throw new InputMismatchException("Invalid direction. Please enter one of the following: N, E, S, W.");
                    }

                    HashMap<Compass, Position> roverTwoPosition = compassParser.compassInput(roverTwoPositionInput);
                    Position position = roverTwoPosition.values().iterator().next();

                    if (position.getX() < 0 || position.getX() >= plateau.getWidth() - 1 ||
                            position.getY() < 0 || position.getY() >= plateau.getHeight() - 1) {
                        throw new InputMismatchException("Rover's Initial Position Must Be Greater Than 2 And Less Than Plateau Size Minus 1 For Each Coordinate.");
                    }
                    roverTwo = new Rover(roverTwoPosition.keySet().iterator().next());
                    missionControl.addRoverToPlateau(secondRover, roverTwo, position);
                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.err.println(e.getMessage() + " Please enter again.");
                }
            }

            List<Instruction> roverTwoInstructions = null;
            while (roverTwoInstructions == null) {
                try {
                    Thread.sleep(300);

                    System.out.println("Enter The Movement Instructions For Rover " + secondRover + "'s");
                    String roverTwoInstructionsInput = scanner.nextLine();

                    roverTwoInstructions = instructionParser.instructionInput(roverTwoInstructionsInput);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid instruction format. Please enter again.");
                } catch (Exception e) {
                    System.err.println("No Input Provided. Please Provide The Rover With Instructions.");
                }
            }

            missionControl.executeCommandForRover(firstRover, new ArrayList<>(roverOneInstructions));
            missionControl.executeCommandForRover(secondRover, new ArrayList<>(roverTwoInstructions));

            Thread.sleep(1000);
            System.out.println("🚙💨💨💨💨");
            Thread.sleep(2000);

            System.out.println("Rover " + firstRover + " has landed at " + missionControl.getRoverPosition(firstRover));
            System.out.println("Rover " + secondRover + " has landed at " + missionControl.getRoverPosition(secondRover));

            Thread.sleep(300);

            System.out.println("Mission Complete Astronaut 🧑🏾‍🚀");

            Thread.sleep(300);

            System.out.println("To Infinity And BEYOND 🚀");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

