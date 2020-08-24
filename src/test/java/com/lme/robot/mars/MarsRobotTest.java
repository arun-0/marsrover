package com.lme.robot.mars;

import com.lme.rover.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRobotTest {
    @Test
    public void roverShouldMoveCorrectlyFromOrigin() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor);

        //turn Left and move
        robot.turn(90);
        robot.move(1);

        Assertions.assertEquals("0 1 N", robot.tellCoordinates());
    }

}
