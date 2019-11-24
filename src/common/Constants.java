/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package common;

public class Constants {

    public static final String DEAD = "DEAD";

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

    public static final int BONUS_KNIGHT_HP = 900;
    public static final int BONUS_PYROMANCER_HP = 500;
    public static final int BONUS_ROGUE_HP = 600;
    public static final int BONUS_WIZARD_HP = 400;

    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_LEVEL_MULTIPLIER = 50;
    public static final float FIREBLAST_KNIGHT_MODIFIER = 0.8f;
    public static final float FIREBLAST_PYROMANCER_MODIFIER = 1.2f;
    public static final float FIREBLAST_ROGUE_MODIFIER = 0.9f;
    public static final float FIREBLAST_WIZARD_MODIFIER = 1.05f;

    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_LEVEL_MULTIPLIER = 20;
    public static final int IGNITE_OVERTIME_DAMAGE = 50;
    public static final int IGNITE_OVERTIME_LEVEL_MULTIPLIER = 30;
    public static final float IGNITE_KNIGHT_MODIFIER = 0.8f;
    public static final float IGNITE_PYROMANCER_MODIFIER = 1.2f;
    public static final float IGNITE_ROGUE_MODIFIER = 0.9f;
    public static final float IGNITE_WIZARD_MODIFIER = 1.05f;

    public static final int SLAM_BASE_DAMAGE = 350;
    public static final int SLAM_LEVEL_MULTIPLIER = 50;
    public static final float SLAM_KNIGHT_MODIFIER = 0.8f;
    public static final float SLAM_PYROMANCER_MODIFIER = 1.2f;
    public static final float SLAM_ROGUE_MODIFIER = 0.9f;
    public static final float SLAM_WIZARD_MODIFIER = 1.05f;
}
