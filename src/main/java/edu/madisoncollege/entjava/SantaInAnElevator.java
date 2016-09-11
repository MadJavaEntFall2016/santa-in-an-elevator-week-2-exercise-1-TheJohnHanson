package edu.madisoncollege.entjava;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application, you will use only unit tests to find the answer.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {

    private final Logger logger = Logger.getLogger(this.getClass());

    public SantaInAnElevator() {

    }

    private List<String> getMapDirections() {

        List<String> mapDirections = new ArrayList<String>();

        try {

            ClassLoader loader = getClass().getClassLoader();
            File map = new File(loader.getResource("SantaUpDown.txt").getFile());
            BufferedReader mapReader = new BufferedReader( new FileReader(map));

            while (mapReader.ready()) {
                mapDirections = Arrays.asList(mapReader.readLine().split(""));
            }

            //logger.info("The String Array is: " + mapDirections);

        } catch (FileNotFoundException fileNotFound) {
            logger.info("The map file was not found");
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            logger.info("There was a problem reading the map");
            ioException.printStackTrace();
        }catch (Exception exception) {
            logger.info("Something went very wrong when trying to find the map.");
            exception.printStackTrace();
        }

        if (mapDirections.size() == 0) {
            logger.info("There were no directions to read.");
        }

        return mapDirections;

    }

    private int decipherFloorNumberFromMapDirections(List<String> mapDirectionsList) {

        int floorNumber = 0;

        for(String direction : mapDirectionsList) {

            if (direction.equals("(")) {
                floorNumber ++;
            } else {
                floorNumber --;
            }
        }

        return floorNumber;

    }


    public void logSantasDestination() {

        logger.info("Santa's destination is floor number: " + decipherFloorNumberFromMapDirections(getMapDirections()));
    }


}