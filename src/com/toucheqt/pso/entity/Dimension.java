package com.toucheqt.pso.entity;

/**
 * 
 * Entity represents dimensional location in 2D field and point's velocity.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class Dimension {

    private double x;
    private double y;

    private double velocityX;
    private double velocityY;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getVelocityX() {
        return velocityX;
    }


    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }


    public double getVelocityY() {
        return velocityY;
    }


    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

}
