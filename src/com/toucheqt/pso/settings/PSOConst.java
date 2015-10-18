package com.toucheqt.pso.settings;


/**
 * Contains all applet constants.
 * 
 * @author Ondøej Krpec, xkrpecqt@gmail.com
 *
 */
public class PSOConst {

    // applet settings
    public static final int APPLET_WIDTH = 800;
    public static final int APPLET_HEIGHT = 600;

    public static final int MIN_X_COORD = 10;
    public static final int MAX_X_COORD = 500;
    public static final int MIN_Y_COORD = 10;
    public static final int MAX_Y_COORD = 500;

    // algorithm settings
    public static final int SWARM_SIZE_PROPERTY = 50;
    public static final double INERTIA_PROPERTY = 0.6;
    public static final double COGNITIVE_COEF_PROPERTY = 2.05;
    public static final double SOCIAL_COEF_PROPERTY = 2.05;

    // FIXME refactor min&max to one property
    public static final double MIN_X_VELOCITY = 0.0;
    public static final double MAX_X_VELOCITY = 5.0;
    public static final double MIN_Y_VELOCITY = 0.0;
    public static final double MAX_Y_VELOCITY = 5.0;

    // maps
    public static final String LEVEL_ONE_KEY = "Simple deck";
    public static final String LEVEL_TWO_KEY = "Collision detection";
    public static final String LEVEL_THREE_KEY = "Maze Runner";

    public static final String[] getLevelValues() {
        return new String[] { LEVEL_ONE_KEY, LEVEL_TWO_KEY, LEVEL_THREE_KEY };
    }

}
