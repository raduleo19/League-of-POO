/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.common;

public class Constants {

    public static final String DEAD = "dead";

    public static final String KNIGHT = "K";
    public static final String PYROMANCER = "P";
    public static final String ROGUE = "R";
    public static final String WIZARD = "W";

    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';

    public static final char KNIGHT_PREFERED_LAND = 'L';
    public static final char PYROMANCER_PREFERED_LAND = 'V';
    public static final char ROGUE_PREFERED_LAND = 'W';
    public static final char WIZARD_PREFERED_LAND = 'D';

    public static final float KNIGHT_LAND_MODIFIER = 1.15f;
    public static final float PYROMANCER_LAND_MODIFIER = 1.25f;
    public static final float ROGUE_LAND_MODIFIER = 1.15f;
    public static final float WIZARD_LAND_MODIFIER = 1.10f;
    public static final float DEFAULT_LAND_MODIFIER = 1.0f;

    public static final int INITIAL_KNIGHT_HP = 900;
    public static final int INITIAL_PYROMANCER_HP = 500;
    public static final int INITIAL_ROGUE_HP = 600;
    public static final int INITIAL_WIZARD_HP = 400;

    public static final int BONUS_KNIGHT_HP = 80;
    public static final int BONUS_PYROMANCER_HP = 50;
    public static final int BONUS_ROGUE_HP = 40;
    public static final int BONUS_WIZARD_HP = 30;

    public static final int BASE_EXPERIENCE = 250;
    public static final int EXPERIENCE_MULTIPLIER = 50;

    public static final int BASE_GAIN_EXPERIENCE = 200;
    public static final int GAIN_EXPERIENCE_MULTIPLIER = 40;
}
