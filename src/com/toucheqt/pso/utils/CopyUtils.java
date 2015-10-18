package com.toucheqt.pso.utils;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.entity.Particle;

/**
 * Utility class for copying entities into new objects.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class CopyUtils {

    /**
     * Creates copy of given particle
     * 
     * @param particle
     * @return {@link Particle}
     */
    public static Particle copyParticle(Particle particle) {

        if (particle == null) {
            return null;
        }

        Particle copiedParticle = new Particle();
        Dimension dimension = new Dimension();
        dimension.setX(particle.getX());
        dimension.setY(particle.getY());
        dimension.setVelocityX(particle.getDimension().getVelocityX());
        dimension.setVelocityY(particle.getDimension().getVelocityY());
        copiedParticle.setDimension(dimension);
        copiedParticle.setRating(particle.getRating());

        return copiedParticle;
    }

}
