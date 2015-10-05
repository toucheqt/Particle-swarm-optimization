package com.toucheqt.pso.entity;

import com.toucheqt.pso.utils.RandomUtils;

/**
 * Represents particle from particle swarm optimalization algorithm.
 * 
 * @see https://en.wikipedia.org/wiki/Particle_swarm_optimization
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class Particle {

    private Dimension dimension;
    private Integer stationaryTime = Integer.valueOf(0);

    private Double rating;
    private Double bestRating = Double.MAX_VALUE;

    private Particle bestSoloResult;
    private Particle bestGroupResult;

    public Particle() {}

    public Particle(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Evaluates fitness function of current particle. The fitness function is a variation of the classic Cartesian distance from two points
     * in a 3D space. The first two coordinates are related to the 2D Cartesian space and the third is a function of how long a particle
     * remained stationary.
     * 
     * @param goal
     */
    public void evaluate(Dimension goal) {
        double firstPart = Math.pow(goal.getX() - dimension.getX(), 2);
        double secondPart = Math.pow(goal.getY() - dimension.getY(), 2);
        double thirdPart = Math.pow(stationaryTime, 2);

        rating = Math.sqrt(firstPart + secondPart + thirdPart);

        if (bestRating > rating) {
            bestRating = rating;
        }
    }


    /**
     * Computes new iteration (position and velocity) of current particle.
     * 
     * @param inertia
     * @param cognitiveCoef
     * @param socialCoef
     */
    public void iterate(Double inertia, Double cognitiveCoef, Double socialCoef) {
        Double tmpResult = 0.0;
        Double velocityX = 0.0;
        Double velocityY = 0.0;

        velocityX = inertia * dimension.getVelocityX();

        tmpResult = cognitiveCoef * RandomUtils.getUniformRandom()
                * (bestSoloResult.getDimension().getVelocityX() - dimension.getVelocityX());
        velocityX += tmpResult;

        tmpResult = socialCoef * RandomUtils.getUniformRandom() * (bestSoloResult.getDimension().getVelocityY() - dimension.getVelocityY());
        velocityX += tmpResult;


        velocityY = inertia * dimension.getVelocityY();

        tmpResult = cognitiveCoef * RandomUtils.getUniformRandom()
                * (bestSoloResult.getDimension().getVelocityY() - dimension.getVelocityY());
        velocityY += tmpResult;

        tmpResult = socialCoef * RandomUtils.getUniformRandom() * (bestSoloResult.getDimension().getVelocityY() - dimension.getVelocityY());
        velocityY += tmpResult;


        dimension.setVelocityX(velocityX);
        dimension.setX(dimension.getX() + velocityX);
        dimension.setVelocityY(velocityY);
        dimension.setY(dimension.getY() + velocityY);
    }


    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    public Double getBestRating() {
        return bestRating;
    }


    public void setBestRating(Double bestRating) {
        this.bestRating = bestRating;
    }

    public Particle getBestSoloResult() {
        return bestSoloResult;
    }

    public void setBestSoloResult(Particle bestSoloResult) {
        this.bestSoloResult = bestSoloResult;
    }

    public Particle getBestGroupResult() {
        return bestGroupResult;
    }

    public void setBestGroupResult(Particle bestGroupResult) {
        this.bestGroupResult = bestGroupResult;
    }

}
