package com.toucheqt.pso.utils;

import java.util.Random;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.settings.PSOConst;

/**
 * 
 * Utility class for generating random numbers and coefs.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class RandomUtils {

    private static final double UNIFORM_MIN_VALUE = 0.0;
    private static final double UNIFORM_MAX_VALUE = 1.0;

    private static Random random = new Random();

    /**
     * Creates dimension for particle with random position and velocity;
     * 
     * @return {@link Dimension}
     */
    public static Dimension getRandomDimension() {
        Dimension dimension = new Dimension();
        dimension.setX(PSOConst.MIN_X_COORD + (Math.random() * ((PSOConst.MAX_X_COORD - PSOConst.MIN_X_COORD) + 1)));
        dimension.setY(PSOConst.MIN_Y_COORD + (Math.random() * ((PSOConst.MAX_Y_COORD - PSOConst.MIN_Y_COORD) + 1)));
        dimension.setVelocityX(PSOConst.MIN_X_VELOCITY + (Math.random() * ((PSOConst.MAX_X_VELOCITY - PSOConst.MIN_X_VELOCITY) + 1)));
        dimension.setVelocityY(PSOConst.MIN_Y_VELOCITY + (Math.random() * ((PSOConst.MAX_Y_VELOCITY - PSOConst.MIN_Y_VELOCITY) + 1)));

        return dimension;
    }


    /**
     * Returns random number from uniform distribution
     */
    public static Double getUniformRandom() {
        return UNIFORM_MIN_VALUE + Math.random() * ((UNIFORM_MAX_VALUE - UNIFORM_MIN_VALUE) + 1);
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static double getRandomVelocity() {
        return PSOConst.MIN_X_VELOCITY + (Math.random() * ((PSOConst.MAX_X_VELOCITY - PSOConst.MIN_X_VELOCITY)));
    }

}
