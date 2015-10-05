package com.toucheqt.pso.entity;

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

    private Integer rating;

    private Particle bestSoloResult;
    private Particle bestGroupResult;

    public Particle() {}

    public Particle(Dimension dimension) {
        this.dimension = dimension;
    }

    public Integer evaluate(Dimension goal) {
        double firstPart;
        double secondPart;
        double thirdPart;
        
        firstPart = Math.pow(goal.getX() - dimension.getX(), 2);
        secondPart = Math.pow(goal.getY() - dimension.getY(), 2);
        thirdPart = Math.pow(goal., b)

        return null; // TODO fitness function
    }
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Integer getRating() {
        return rating;
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
