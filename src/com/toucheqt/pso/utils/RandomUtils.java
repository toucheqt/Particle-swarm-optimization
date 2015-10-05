package com.toucheqt.pso.utils;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.settings.PSOConst;

/**
 * 
 * Utility class for generating random numbers and coefs.
 * 
 * @author Ond�ej Krpec, xkrpecqt@gmail.com
 *
 */
public class RandomUtils {

    /**
     * Creates dimension for particle with random position and velocity;
     * 
     * @return {@link Dimension}
     */
    public static Dimension getRandomDimension() {
        Dimension dimension = new Dimension();
        dimension.setX(PSOConst.MIN_X_COORD + (int)(Math.random() * ((PSOConst.MAX_X_COORD - PSOConst.MIN_X_COORD) + 1)));
        dimension.setY(PSOConst.MIN_Y_COORD + (int)(Math.random() * ((PSOConst.MAX_Y_COORD - PSOConst.MIN_Y_COORD) + 1)));
        dimension.setVelocityX(PSOConst.MIN_X_VELOCITY + (Math.random() * ((PSOConst.MAX_X_VELOCITY - PSOConst.MIN_X_VELOCITY) + 1)));
        dimension.setVelocityY(PSOConst.MIN_Y_VELOCITY + (Math.random() * ((PSOConst.MAX_Y_VELOCITY - PSOConst.MIN_Y_VELOCITY) + 1)));

        return dimension;
    }

}
