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

        if(marsGrid.isScented((int)getX(), (int)getY(), getMarsOrientation()))
            return;

        if(!isLost) {
            int previousX = (int) getX();
            int previousY = (int) getY();

            super.move(distance);

            // if lost
            if(getX() > marsGrid.getMaxX()) {
                marsGrid.addScentedGrid(previousX, previousY, MarsOrientation.E);
                isLost = true;
            } else if(getX() < 0) {
                marsGrid.addScentedGrid(previousX, previousY, MarsOrientation.W);
                isLost = true;
            } else if(getY() > marsGrid.getMaxY()) {
                marsGrid.addScentedGrid(previousX, previousY, MarsOrientation.N);
                isLost = true;
            } else if(getY() < 0) {
                marsGrid.addScentedGrid(previousX, previousY, MarsOrientation.S);
                isLost = true;
            }

            if(isLost) {
                // reset coordinate to last seen position, for reporting
                super.move(-1 * distance);
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

        MarsOrientation marsOrientation = getMarsOrientation();
        if (marsOrientation == null) {
            s.append("Invalid Orientation");
        } else {
            s.append(marsOrientation);
        }

        if(isLost)
            s.append(" LOST");

        return s.toString();
    }

    // determine which direction robot is facing. note:- 360 degree turn equals one rotation
    private MarsOrientation getMarsOrientation() {
        double theta = super.getTheta();

        if (theta < 0)
            theta = 360 + theta;

        theta = theta % 360;

        return MarsOrientation.valueOf(theta);
    }

    public boolean isLost() {
        return this.isLost;
    }

}
