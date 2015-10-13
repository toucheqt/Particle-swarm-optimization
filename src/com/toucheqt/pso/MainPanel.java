package com.toucheqt.pso;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toucheqt.pso.algorithm.ParticleSwarmOptimalization;
import com.toucheqt.pso.settings.PSOConst;

/**
 * Main panel in this application
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {

    private ParticleSwarmOptimalization algorithm;

    private JTextField swarmSizeField = new JTextField(String.valueOf(PSOConst.SWARM_SIZE_PROPERTY));
    private JTextField inertiaField = new JTextField(String.valueOf(PSOConst.INERTIA_PROPERTY));
    private JTextField cognitiveCoefField = new JTextField(String.valueOf(PSOConst.COGNITIVE_COEF_PROPERTY));
    private JTextField socialCoefField = new JTextField(String.valueOf(PSOConst.SOCIAL_COEF_PROPERTY));

    private JComboBox<String> levelComboBox = new JComboBox<String>(PSOConst.getLevelValues());

    private JLabel timerLabel = new JLabel("0.00s");
    private JLabel ratingLabel = new JLabel("-");

    public MainPanel() {
        createMainLayout();
    }

    private void createMainLayout() {
        setLayout(new BorderLayout(5, 5));

        JPanel compPanel = new JPanel();
        compPanel.add(createRightLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Algorithm settings"));

        add(topPanel, BorderLayout.PAGE_START);
        add(compPanel, BorderLayout.CENTER);
    }

    private JPanel createRightLayout() {
        JPanel rightLayout = new JPanel(new GridLayout(8, 2, 5, 5));

        rightLayout.add(new JLabel("Swarm size: "));
        rightLayout.add(swarmSizeField);

        rightLayout.add(new JLabel("Inertia: "));
        rightLayout.add(inertiaField);

        rightLayout.add(new JLabel("Cognitive coeficient: "));
        rightLayout.add(cognitiveCoefField);

        rightLayout.add(new JLabel("Social coeficient: "));
        rightLayout.add(socialCoefField);

        rightLayout.add(new JLabel("Level: "));
        rightLayout.add(levelComboBox);

        // algorithm info
        rightLayout.add(new JLabel("Time since start: "));
        rightLayout.add(timerLabel);

        rightLayout.add(new JLabel("Current best rating: "));
        rightLayout.add(ratingLabel);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(createStartButtonListener());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(createStopButtonListener());

        rightLayout.add(startButton);
        rightLayout.add(stopButton);

        return rightLayout;
    }
    private ActionListener createStartButtonListener() {
        return (event) -> {
            Integer swarmSize = null;
            Double inertia = null;
            Double cognitiveCoef = null;
            Double socialCoef = null;

            // validate input
            try {
                swarmSize = Integer.valueOf(swarmSizeField.getText());
                inertia = Double.valueOf(inertiaField.getText());
                cognitiveCoef = Double.valueOf(cognitiveCoefField.getText());
                socialCoef = Double.valueOf(socialCoefField.getText());
            } catch (NullPointerException | NumberFormatException e) {
                if (swarmSize == null) {
                    swarmSize = PSOConst.SWARM_SIZE_PROPERTY;
                    swarmSizeField.setText(String.valueOf(PSOConst.SWARM_SIZE_PROPERTY));
                }

                if (inertia == null) {
                    inertia = PSOConst.INERTIA_PROPERTY;
                    inertiaField.setText(String.valueOf(PSOConst.INERTIA_PROPERTY));
                }

                if (cognitiveCoef == null) {
                    cognitiveCoef = PSOConst.COGNITIVE_COEF_PROPERTY;
                    cognitiveCoefField.setText(String.valueOf(PSOConst.COGNITIVE_COEF_PROPERTY));
                }

                if (socialCoef == null) {
                    socialCoef = PSOConst.SOCIAL_COEF_PROPERTY;
                    socialCoefField.setText(String.valueOf(PSOConst.SOCIAL_COEF_PROPERTY));
                }
            }

            // TODO fix goal
            algorithm = new ParticleSwarmOptimalization(swarmSize, inertia, cognitiveCoef, socialCoef, null);
            Thread thread = new Thread(algorithm);
            thread.start();
        };
    }


    private ActionListener createStopButtonListener() {
        return (event) -> {
            if (algorithm != null && algorithm.isAlive()) {
                algorithm.shutdown();
            }
        };
    }
}
