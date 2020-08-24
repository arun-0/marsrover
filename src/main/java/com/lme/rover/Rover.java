package com.lme.rover;

/**
 * A generic Rover which can move by any amount (not just by a single unit) at any angle
 */
public abstract class Rover {
    private String name;
    private Coordinates coordinates;

    public Rover(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
    };

    public void move(int distance, double angle) {
        coordinates.addTheta(angle);

        double theta = coordinates.getTheta();
        coordinates.addX(distance * Math.cos(theta));
        coordinates.addY(distance * Math.sin(theta));
    }

    public double getX() {
        return coordinates.getX();
    }
    public double getY() {
        return coordinates.getY();
    }
    public double getTheta() {
        return coordinates.getTheta();
    }


}
