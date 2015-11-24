package com.toucheqt.pso.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.List;

import javax.swing.JPanel;

import com.toucheqt.pso.algorithm.ParticleSwarmOptimalizationTask;
import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.entity.Particle;
import com.toucheqt.pso.settings.PSOConst;

/**
 * JPanel representing board for painting algorithm results.
 * 
 * @see {@link ParticleSwarmOptimalizationTask}
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
@SuppressWarnings("serial")
public class Board extends JPanel {

    private static final int GOAL_SIZE = 10;
    private static final int CIRCLE_SHIFT = 3;

    private Graphics2D graphics;

    private Dimension goal;
    private List<Particle> particles;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.graphics = (Graphics2D)g;

        Stroke defaultStroke = graphics.getStroke();

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(15.0f));
        graphics.drawRect(0, 0, getWidth(), getHeight());

        if (goal != null) {
            graphics.setStroke(defaultStroke);
            graphics.fillOval((int)goal.getX() - CIRCLE_SHIFT, (int)goal.getY() - CIRCLE_SHIFT, GOAL_SIZE, GOAL_SIZE);
        }

        if (particles != null) {
            particles.forEach((particle) -> {
                graphics.setColor(particle.getColor());
                graphics.fillRect((int)particle.getX(), (int)particle.getY(), PSOConst.PARTICLE_SIZE, PSOConst.PARTICLE_SIZE);
            });
        }
    }

    public void setGoal(Dimension goal) {
        this.goal = goal;
    }

    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }

}
