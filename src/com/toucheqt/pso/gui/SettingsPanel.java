package com.toucheqt.pso.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toucheqt.pso.algorithm.ParticleSwarmOptimalizationTask;
import com.toucheqt.pso.settings.PSOConst;
import com.toucheqt.pso.utils.RandomUtils;

/**
 * Main panel in this application
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
@SuppressWarnings("serial")
public class SettingsPanel extends JPanel {

    public static final String RATING_COMPONENT = "rating";
    public static final String BOARD_COMPONENT = "board";

    private ParticleSwarmOptimalizationTask task;

    private JTextField swarmSizeField = new JTextField(String.valueOf(PSOConst.SWARM_SIZE_PROPERTY));
    private JTextField inertiaField = new JTextField(String.valueOf(PSOConst.INERTIA_PROPERTY));
    private JTextField cognitiveCoefField = new JTextField(String.valueOf(PSOConst.COGNITIVE_COEF_PROPERTY));
    private JTextField socialCoefField = new JTextField(String.valueOf(PSOConst.SOCIAL_COEF_PROPERTY));

    private Integer swarmSizeValue = null;
    private Double inertiaValue = null;
    private Double cognitiveCoefValue = null;
    private Double socialCoefValue = null;

    private JLabel ratingLabel = new JLabel("-");

    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");

    // board layout component
    private Board board;

    public SettingsPanel() {
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

        // algorithm info
        rightLayout.add(new JLabel("Current best rating: "));
        rightLayout.add(ratingLabel);

        startButton.addActionListener(createStartButtonListener());
        stopButton.addActionListener(createStopButtonListener());
        enableComponents(true);

        rightLayout.add(startButton);
        rightLayout.add(stopButton);

        return rightLayout;
    }
    private ActionListener createStartButtonListener() {
        return (event) -> {
            enableComponents(false);

            // validate input
            try {
                swarmSizeValue = Integer.valueOf(swarmSizeField.getText());
                inertiaValue = Double.valueOf(inertiaField.getText());
                cognitiveCoefValue = Double.valueOf(cognitiveCoefField.getText());
                socialCoefValue = Double.valueOf(socialCoefField.getText());
            } catch (NullPointerException | NumberFormatException e) {
                if (swarmSizeValue == null) {
                    swarmSizeValue = PSOConst.SWARM_SIZE_PROPERTY;
                    swarmSizeField.setText(String.valueOf(PSOConst.SWARM_SIZE_PROPERTY));
                }

                if (inertiaValue == null) {
                    inertiaValue = PSOConst.INERTIA_PROPERTY;
                    inertiaField.setText(String.valueOf(PSOConst.INERTIA_PROPERTY));
                }

                if (cognitiveCoefValue == null) {
                    cognitiveCoefValue = PSOConst.COGNITIVE_COEF_PROPERTY;
                    cognitiveCoefField.setText(String.valueOf(PSOConst.COGNITIVE_COEF_PROPERTY));
                }

                if (socialCoefValue == null) {
                    socialCoefValue = PSOConst.SOCIAL_COEF_PROPERTY;
                    socialCoefField.setText(String.valueOf(PSOConst.SOCIAL_COEF_PROPERTY));
                }
            }

            task = new ParticleSwarmOptimalizationTask(RandomUtils.getRandomDimension(), swarmSizeValue, inertiaValue, cognitiveCoefValue,
                    socialCoefValue, createEditableComponentsMap());
            task.execute();
        };
    }

    private ActionListener createStopButtonListener() {
        return (event) -> {
            enableComponents(true);
            task.cancel(true);
            task = null;
        };
    }

    /**
     * Enables/disables GUI components. When stop button is enabled, all other components are disabled and vice versa.
     * 
     * @param enabled
     */
    private void enableComponents(boolean enabled) {
        startButton.setEnabled(enabled);
        swarmSizeField.setEnabled(enabled);
        inertiaField.setEnabled(enabled);
        cognitiveCoefField.setEnabled(enabled);
        socialCoefField.setEnabled(enabled);
        stopButton.setEnabled(!enabled);
    }

    private Map<String, JComponent> createEditableComponentsMap() {
        Map<String, JComponent> components = new HashMap<String, JComponent>();
        components.put(RATING_COMPONENT, ratingLabel);
        components.put(BOARD_COMPONENT, board);

        return components;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
