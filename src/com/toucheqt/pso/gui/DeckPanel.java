package com.toucheqt.pso.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import com.toucheqt.pso.entity.Dimension;
import com.toucheqt.pso.entity.Particle;

/**
 * 
 * Class implementing custom JPanel for drawing the deck.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
@SuppressWarnings("serial")
public class DeckPanel extends JPanel {

    private volatile List<Particle> particles;
    private Dimension goal;

    private Graphics2D g;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = (Graphics2D)g;

        initDeck();
    }

    private void initDeck() {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(15.0f));
        g.drawRect(0, 0, getWidth(), getHeight());
    }

    public void paintParticles() {
        if (g == null) {
            g = (Graphics2D)getGraphics();
        }
        if (particles != null) {
            for (Particle particle : particles) {
                g.setColor(Color.RED);
                if (particle.getDimension() != null) {
                    // g.drawRect(particle.getX().intValue() - 2, particle.getY().intValue() - 2, particle.getX().intValue() + 2, particle
                    // .getY().intValue() + 2);
                }
            }
        }
    }
    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }

    public void setGoal(Dimension goal) {
        this.goal = goal;
    }
}
