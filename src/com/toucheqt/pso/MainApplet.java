package com.toucheqt.pso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;

import javax.swing.JApplet;
import javax.swing.JPanel;
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

        createMainLayout();
    }
    private void createMainLayout() {
        setLayout(new BorderLayout(5, 5));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);

        add(centerPanel, BorderLayout.CENTER);
        add(new MainPanel(), BorderLayout.LINE_END);
    }

}
