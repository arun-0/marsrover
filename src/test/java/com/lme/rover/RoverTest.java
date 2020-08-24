package com.lme.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {
    @Test
    public void roverShouldMoveCorrectlyFromOrigin() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Rover rover = new Rover("Rover-A", coor) {};

        //turn 45 degree and move 4 units
        rover.turn(45);
        rover.move(4);

        Assertions.assertEquals(2.8284271247461903, rover.getX());
        Assertions.assertEquals(2.82842712474619, rover.getY());
        Assertions.assertEquals(0.7853981633974483, rover.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhere() {
        Coordinates coor = new Coordinates(3, 4, 0);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Rover rover = new Rover("Rover-A", coor) {};

        //turn 30 degree and move 5 units
        rover.turn(30);
        rover.move(5);


        System.out.println("rover = " + rover.getX() + " " + rover.getY() + " " + rover.getTheta());

        Assertions.assertEquals(7.330127018922194, rover.getX());
        Assertions.assertEquals(6.4999999999999996, rover.getY());
        Assertions.assertEquals(0.5235987755982988, rover.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhereFromAnyInitialAngle() {
        Coordinates coor = new Coordinates(3, 4, 30);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Rover rover = new Rover("Rover-A", coor) {};

        //turn 30 degree and move 5 units
        rover.turn(30);
        rover.move(5);

        System.out.println("rover = " + rover.getX() + " " + rover.getY() + " " + rover.getTheta());

        Assertions.assertEquals(5.5000000000000004, rover.getX());
        Assertions.assertEquals(8.330127018922193, rover.getY());
        Assertions.assertEquals(1.0471975511965976, rover.getTheta());
    }

}
