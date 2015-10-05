package com.toucheqt.pso.utils;

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
        copiedParticle.setDimension(particle.getDimension());
        copiedParticle.setRating(particle.getRating());
        copiedParticle.setBestRating(particle.getBestRating());
        copiedParticle.setBestSoloResult(particle.getBestSoloResult());
        copiedParticle.setBestGroupResult(particle.getBestGroupResult());

        return copiedParticle;
    }

}
