package com.toucheqt.pso.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.toucheqt.pso.entity.Particle;
import com.toucheqt.pso.settings.PSOConst;
import com.toucheqt.pso.utils.CopyUtils;
import com.toucheqt.pso.utils.RandomUtils;

/**
 * Implementation of particle swarm optimalization algorithm.
 * 
 * @see https://en.wikipedia.org/wiki/Particle_swarm_optimization
 * @author Ondøej Krpec
 *
 */
public class ParticleSwarmOptimalization implements Runnable {

    private Integer swarmSize = PSOConst.SWARM_SIZE_PROPERTY;

    private Double inertia = PSOConst.INERTIA_PROPERTY;
    private Double cognitiveCoef = PSOConst.COGNITIVE_COEF_PROPERTY;
    private Double socialCoef = PSOConst.SOCIAL_COEF_PROPERTY;

    private List<Particle> particles = new ArrayList<Particle>();

    public ParticleSwarmOptimalization() {
        init();
    }

    public ParticleSwarmOptimalization(Integer swarmSize, Double inertia, Double cognitiveCoef, Double socialCoef) {
        this();
        this.swarmSize = swarmSize;
        this.inertia = inertia;
        this.cognitiveCoef = cognitiveCoef;
        this.socialCoef = socialCoef;
    }


    public void init() {
        for (int i = 0; i < swarmSize; i++) {
            particles.add(new Particle());
        }
    }


    @Override
    public void run() {

    }


    /**
     * Initializes particles
     */
    private void processStepOne() {
        for (Particle particle : particles) {
            particle.setDimension(RandomUtils.getRandomDimension());
            particle.setBestSoloResult(CopyUtils.copyParticle(particle));
        }
    }
    public Integer getSwarmSize() {
        return swarmSize;
    }


    public void setSwarmSize(Integer swarmSize) {
        this.swarmSize = swarmSize;
    }


    public Double getInertia() {
        return inertia;
    }


    public void setInertia(Double inertia) {
        this.inertia = inertia;
    }


    public Double getCognitiveCoef() {
        return cognitiveCoef;
    }


    public void setCognitiveCoef(Double cognitiveCoef) {
        this.cognitiveCoef = cognitiveCoef;
    }


    public Double getSocialCoef() {
        return socialCoef;
    }


    public void setSocialCoef(Double socialCoef) {
        this.socialCoef = socialCoef;
    }


    public List<Particle> getParticles() {
        return particles;
    }


    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }


}
