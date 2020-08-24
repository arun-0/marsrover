package com.lme.robot;

import com.lme.robot.Robot;
import com.lme.rover.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    @Test
    public void roverShouldMoveCorrectlyFromOrigin() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {};

        //turn 45 degree and move 4 units
        robot.turn(45);
        robot.move(4);

        Assertions.assertEquals(2.8284271247461903, robot.getX());
        Assertions.assertEquals(2.82842712474619, robot.getY());
        Assertions.assertEquals(0.7853981633974483, robot.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhere() {
        Coordinates coor = new Coordinates(3, 4, 0);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {};

        //turn 30 degree and move 5 units
        robot.turn(30);
        robot.move(5);


        System.out.println("rover = " + robot.getX() + " " + robot.getY() + " " + robot.getTheta());

        Assertions.assertEquals(7.330127018922194, robot.getX());
        Assertions.assertEquals(6.4999999999999996, robot.getY());
        Assertions.assertEquals(0.5235987755982988, robot.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhereFromAnyInitialAngle() {
        Coordinates coor = new Coordinates(3, 4, 30);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {};

        //turn 30 degree and move 5 units
        robot.turn(30);
        robot.move(5);

        System.out.println("rover = " + robot.getX() + " " + robot.getY() + " " + robot.getTheta());

        Assertions.assertEquals(5.5000000000000004, robot.getX());
        Assertions.assertEquals(8.330127018922193, robot.getY());
        Assertions.assertEquals(1.0471975511965976, robot.getTheta());
    }

}
