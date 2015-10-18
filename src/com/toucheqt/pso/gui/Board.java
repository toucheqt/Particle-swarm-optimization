package com.toucheqt.pso.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.List;

import javax.swing.JPanel;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.entity.Particle;
import com.toucheqt.pso.utils.RandomUtils;


public class Board extends JPanel {

    private static final int GOAL_SIZE = 10;
    private static final int CIRCLE_SHIFT = 7;

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
            graphics.fillOval((int)goal.getX() + CIRCLE_SHIFT, (int)goal.getY() + CIRCLE_SHIFT, GOAL_SIZE, GOAL_SIZE);
        }

        if (particles != null) {
            particles.forEach((particle) -> {
                if (RandomUtils.getRandomBoolean()) {
                    graphics.setColor(Color.RED);
                } else {
                    graphics.setColor(Color.ORANGE);
                }

                graphics.fillOval((int)particle.getX() + CIRCLE_SHIFT / 2, (int)particle.getY() + CIRCLE_SHIFT / 2, 5, 5);
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
