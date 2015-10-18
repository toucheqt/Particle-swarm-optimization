package com.toucheqt.pso.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.istack.internal.logging.Logger;
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

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(MainApplet.class).log(Level.WARNING, "Default system UI look was not loaded.", ex);
        }

        SwingUtilities.invokeLater(() -> {
            createMainLayout();
        });
    }

    private void createMainLayout() {
        SettingsPanel settingsPanel = new SettingsPanel();
        setLayout(new BorderLayout(5, 5));

        Board board = new Board();
        board.setBackground(Color.WHITE);

        settingsPanel.setBoard(board);

        add(board, BorderLayout.CENTER);
        add(settingsPanel, BorderLayout.LINE_END);
    }

}
