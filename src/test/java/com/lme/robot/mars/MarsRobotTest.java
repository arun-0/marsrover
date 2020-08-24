package com.lme.robot.mars;

import com.lme.rover.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRobotTest {
    @Test
    public void roverShouldTurnLeftFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor);

        //turn Left and move
        robot.turn(90);
        robot.move(1);

        Assertions.assertEquals("0 1 N", robot.tellCoordinates());
    }

    @Test
    public void roverShouldTurnRightFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor);

        //turn Left and move
        robot.turn(-90);
        robot.move(1);

        Assertions.assertEquals("0 -1 S", robot.tellCoordinates());
    }

    @Test
    public void roverShouldMoveForwardFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor);

        //turn Left and move
        robot.move(1);

        Assertions.assertEquals("1 0 E", robot.tellCoordinates());
    }

    @Test
    public void roverShouldMoveAndTurnCorrectly() {
        Coordinates coor = new Coordinates(3, 4, 90);

        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor);
        robot.move(1);
        Assertions.assertEquals("3 5 N", robot.tellCoordinates());

        // turn right and move
        robot.turn(-90);
        robot.move(1);
        Assertions.assertEquals("4 5 E", robot.tellCoordinates());

        // turn left and move
        robot.turn(90);
        robot.move(1);
        Assertions.assertEquals("4 6 N", robot.tellCoordinates());

    }

}
