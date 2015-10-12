package com.toucheqt.pso;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JPanel;

import com.toucheqt.pso.algorithm.ParticleSwarmOptimalization;
import com.toucheqt.pso.settings.PSOConst;


/**
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
@SuppressWarnings("serial")
public class MainApplet extends JApplet {

    @Override
    public void init() {
        setSize(PSOConst.APPLET_WIDTH, PSOConst.APPLET_HEIGHT);
        createMainLayout();
    }
    @Override
    public void start() {
        Thread algorithm = new Thread(new ParticleSwarmOptimalization());
        algorithm.start();
    }

    private void createMainLayout() {
        setLayout(new BorderLayout(5, 5));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);

        add(centerPanel, BorderLayout.CENTER);
        add(new MainPanel(), BorderLayout.LINE_END);
    }

}
