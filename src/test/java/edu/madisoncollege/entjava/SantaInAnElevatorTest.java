package edu.madisoncollege.entjava;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnhanson on 9/11/16.
 */
public class SantaInAnElevatorTest {

    @Test
    public void getDestination() {
        SantaInAnElevator test = new SantaInAnElevator();
        test.logSantasDestination();
    }
}