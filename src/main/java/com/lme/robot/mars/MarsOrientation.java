package com.lme.robot.mars;

public enum MarsOrientation {
    E(0), N(90), W(180), S(270);

    private final double angle;

    MarsOrientation(double angle) {
        this.angle = angle;
    }

    public static MarsOrientation valueOf(double angle) {
        for (MarsOrientation b : MarsOrientation.values()) {
            if (b.angle == angle) {
                return b;
            }
        }
        return null;
    }

}
