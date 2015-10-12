package com.toucheqt.pso;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel extends JPanel {

    public MainPanel() {
        createMainLayout();
    }

    private void createMainLayout() {
        setLayout(new BorderLayout(5, 5));

        JPanel compPanel = new JPanel();
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        JPanel buttonPanel = new JPanel();

        panel.add(new JButton("Button ...... 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button ............ 3"));
        panel.add(new JLabel("Label"));
        panel.add(new JTextField());

        compPanel.add(panel);

        buttonPanel.add(new JButton("Button 4"));

        add(compPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

}
