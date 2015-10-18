package com.toucheqt.pso.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.entity.Particle;
import com.toucheqt.pso.gui.SettingsPanel;
import com.toucheqt.pso.utils.CopyUtils;

/**
 * Task for solving the algorithm of particle swarm optimalization as a background task and update the gui with its results.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class ParticleSwarmOptimalizationTask extends SwingWorker<Void, Void> {

    private List<Particle> particles = new ArrayList<Particle>();
    private Particle bestResult;

    private Dimension goal;

    private int swarmSize;
    private double inertia;
    private double cognitiveCoef;
    private double socialCoef;

    private Map<String, JComponent> components;

    public ParticleSwarmOptimalizationTask(Dimension goal, int swarmSize, double inertia, double cognitiveCoef, double socialCoef,
            Map<String, JComponent> components) {
        this.goal = goal;
        this.swarmSize = swarmSize;
        this.inertia = inertia;
        this.cognitiveCoef = cognitiveCoef;
        this.socialCoef = socialCoef;
        this.components = components;
    }

    @Override
    protected Void doInBackground() throws Exception {

        for (int i = 0; i < swarmSize; i++) {
            Particle particle = new Particle();
            particle.setRating(particle.evaluate(goal));
            particle.setBestSoloResult(CopyUtils.copyParticle(particle));
            particles.add(particle);

            if (bestResult == null || bestResult.getRating() > particle.getRating()) {
                bestResult = CopyUtils.copyParticle(particle);
            }
        }

        while (!isCancelled()) {
            // can execute this in parallel
            particles.forEach((particle) -> {
                particle.setRating(particle.evaluate(goal));
                if (particle.getRating() < particle.getBestSoloResult().getRating()) {
                    particle.setBestSoloResult(CopyUtils.copyParticle(particle));
                }

                if (bestResult == null || particle.getRating() < bestResult.getRating()) {
                    bestResult = CopyUtils.copyParticle(particle);
                }

                particle.iterate(inertia, cognitiveCoef, socialCoef, bestResult);
            });

            // delay algorithm a bit to demonstrate its functionality
            Thread.sleep(100);

            publish();
        }

        return null;
    }

    @Override
    protected void process(List<Void> voidList) {
        if (components.get(SettingsPanel.RATING_COMPONENT) != null) {
            ((JLabel)components.get(SettingsPanel.RATING_COMPONENT)).setText(String.valueOf(bestResult.getRating()));
        }
    }
}
