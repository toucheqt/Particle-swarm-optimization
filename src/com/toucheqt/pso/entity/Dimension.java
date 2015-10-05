package com.toucheqt.pso.entity;

/**
 * 
 * Entity represents dimensional location in 2D field and point's velocity.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class Dimension {

    private Integer x;
    private Integer y;

    private Double velocityX;
    private Double velocityY;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
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
