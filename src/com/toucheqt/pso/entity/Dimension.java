package com.toucheqt.pso.entity;

/**
 * 
 * Entity represents dimensional location in 2D field and point's velocity.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class Dimension {

    private Double x;
    private Double y;

    private Double velocityX;
    private Double velocityY;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }


    public Double getVelocityX() {
        return velocityX;
    }


    public void setVelocityX(Double velocityX) {
        this.velocityX = velocityX;
    }


    public Double getVelocityY() {
        return velocityY;
    }


    public void setVelocityY(Double velocityY) {
        this.velocityY = velocityY;
    }

}
