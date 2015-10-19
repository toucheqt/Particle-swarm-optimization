package com.toucheqt.pso.entity;

import com.toucheqt.pso.settings.PSOConst;
import com.toucheqt.pso.utils.RandomUtils;

/**
 * Represents particle from particle swarm optimalization algorithm.
 * 
 * @see https://en.wikipedia.org/wiki/Particle_swarm_optimization
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class Particle {

    private double rating = Double.MAX_VALUE;

    private Dimension dimension;
    private Particle bestSoloResult;

    public Particle() {
        dimension = RandomUtils.getRandomDimension();
    }

    /**
     * Evaluates fitness function of current particle. The fitness function is a variation of the classic Cartesian distance from two points
     * in a 3D space. The first two coordinates are related to the 2D Cartesian space and the third is a function of how long a particle
     * remained stationary.
     * 
     * @param goal
     */
    public double evaluate(Dimension goal) {
        double firstPart = Math.pow(goal.getX() - dimension.getX(), 2);
        double secondPart = Math.pow(goal.getY() - dimension.getY(), 2);
        return Math.sqrt(firstPart + secondPart);
    }


    /**
     * Computes new iteration (position and velocity) of current particle.
     * 
     * @param inertia
     * @param cognitiveCoef
     * @param socialCoef
     */
    public void iterate(Double inertia, Double cognitiveCoef, Double socialCoef, Particle bestResult) {
        double velocityX = PSOConst.MIN_VELOCITY;
        double velocityY = PSOConst.MIN_VELOCITY;

        double rp = RandomUtils.getUniformRandom();
        double rg = RandomUtils.getUniformRandom();

        velocityX = inertia * dimension.getVelocityX();
        velocityX += cognitiveCoef * rp * (bestSoloResult.getDimension().getX() - dimension.getX());
        velocityX += socialCoef * rg * (bestResult.getDimension().getX() - dimension.getX());

        velocityY = inertia * dimension.getVelocityY();
        velocityY += cognitiveCoef * rp * (bestSoloResult.getDimension().getY() - dimension.getY());
        velocityY += socialCoef * rg * (bestResult.getDimension().getY() - dimension.getY());

        if (velocityX > PSOConst.MAX_VELOCITY || velocityX < -PSOConst.MAX_VELOCITY || velocityY > PSOConst.MAX_VELOCITY
                || velocityY < -PSOConst.MAX_VELOCITY) {
            double tmp = (Math.abs(velocityX) > Math.abs(velocityY)) ? velocityX / 2.0 : velocityY / 2.0;
            velocityY /= Math.abs(tmp);
            velocityX /= Math.abs(tmp);
        }

        if (velocityX + getX() < PSOConst.MIN_X_COORD || velocityX + getX() > PSOConst.MAX_X_COORD) {
            velocityX = PSOConst.MIN_VELOCITY;
        }

        if (velocityY + getY() < PSOConst.MIN_Y_COORD || velocityY + getY() > PSOConst.MAX_Y_COORD) {
            velocityY = PSOConst.MIN_VELOCITY;
        }

        dimension.setVelocityX(velocityX);
        dimension.setVelocityY(velocityY);

        dimension.setX(dimension.getX() + dimension.getVelocityX());
        dimension.setY(dimension.getY() + dimension.getVelocityY());

    }

    public double getX() {
        return dimension.getX();
    }

    public double getY() {
        return dimension.getY();
    }


    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public Particle getBestSoloResult() {
        return bestSoloResult;
    }

    public void setBestSoloResult(Particle bestSoloResult) {
        this.bestSoloResult = bestSoloResult;
    }

}
