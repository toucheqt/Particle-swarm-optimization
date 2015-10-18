package com.toucheqt.pso.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;

import javax.swing.JApplet;
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

    private Thread thread;

    private SettingsPanel settingsPanel;
    private DeckPanel deckPanel;

    @Override
    public void init() {
        setSize(PSOConst.APPLET_WIDTH, PSOConst.APPLET_HEIGHT);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(MainApplet.class).log(Level.WARNING, "Default system UI look was not loaded.", ex);
        }

        createMainLayout();
    }

    private void createMainLayout() {
        settingsPanel = new SettingsPanel();
        setLayout(new BorderLayout(5, 5));

        deckPanel = new DeckPanel();
        deckPanel.setBackground(Color.WHITE);

        add(deckPanel, BorderLayout.CENTER);
        add(settingsPanel, BorderLayout.LINE_END);
    }

}
