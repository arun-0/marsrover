package com.lme.robot.mars;

import com.lme.robot.Robot;
import com.lme.rover.Coordinates;

/**
 * MarsRover - a specific Rover which can only move by a single unit and
 * turn by only 90 degrees
 */
public class MarsRobot extends Robot {

    private MarsRobot(String name, Coordinates coordinates){
        super(name, coordinates);
    };

    public static MarsRobot init(String name, Coordinates coordinates) {
        return new MarsRobot(name, coordinates);
    }

    @Override
    public void turn(double angle) {
        if( (angle == 90) || (angle == -90) )
            super.turn(angle);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void move(double distance) {
        if(distance != 1)
            throw new IllegalArgumentException();

        super.move(distance);
    }

    @Override
    public String tellCoordinates() {
        StringBuilder s = new StringBuilder();
        s.append((int)super.getX());
        s.append(" ");
        s.append((int)super.getY());
        s.append(" ");

        MarsOrientation marsOrientation = MarsOrientation.valueOf(super.getTheta());
        if (marsOrientation == null) {
            s.append("Invalid Orientation");
        } else {
            s.append(marsOrientation);
        }

        return s.toString();
    }

}
