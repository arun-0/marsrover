package com.lme.robot.mars;

import com.lme.robot.Robot;
import com.lme.rover.Coordinates;

/**
 * MarsRover - a specific Rover which can only move by a single unit and
 * turn by only 90 degrees
 */
public class MarsRobot extends Robot {
    private final MarsGrid marsGrid;
    private boolean isLost = false;

    private MarsRobot(String name, Coordinates coordinates, MarsGrid marsGrid){
        super(name, coordinates);
        this.marsGrid = marsGrid;
    };

    public static MarsRobot init(String name, Coordinates coordinates, MarsGrid marsGrid) {
        return new MarsRobot(name, coordinates, marsGrid);
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

        if(!isLost) {
            int previousX = (int) getX();
            int previousY = (int) getY();

            super.move(distance);

            if(getX() > marsGrid.getMaxX() || getY() > marsGrid.getMaxY()) {
                marsGrid.addScentedGrid(previousX, previousY);
                isLost = true;
            }

        }

    }

    @Override
    public String tellCoordinates() {
        StringBuilder s = new StringBuilder();
        s.append((int)super.getX());
        s.append(" ");
        s.append((int)super.getY());
        s.append(" ");

        double theta = super.getTheta();
        if (theta < 0)
            theta = 360 + theta;

        MarsOrientation marsOrientation = MarsOrientation.valueOf(theta);
        if (marsOrientation == null) {
            s.append("Invalid Orientation");
        } else {
            s.append(marsOrientation);
        }

        if(isLost)
            s.append(" LOST");

        return s.toString();
    }

    public boolean isLost() {
        return this.isLost;
    }

}
