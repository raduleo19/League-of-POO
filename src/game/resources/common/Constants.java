/*
 * Copyright (c) 2019 Rica Radu-Leonard
 */

package game.resources.common;

public final class Constants {

    // STATE CONSTANTS
    public static final String DEAD = "dead";

    // HEROES CONSTANTS
    public static final String KNIGHT = "K";
    public static final String PYROMANCER = "P";
    public static final String ROGUE = "R";
    public static final String WIZARD = "W";

    // ANGELS CONSTANTS
    public static final String DAMAGE_ANGEL = "DamageAngel";
    public static final String DARK_ANGEL = "DarkAngel";
    public static final String DRACULA = "Dracula";
    public static final String GOOD_BOY = "GoodBoy";
    public static final String LEVEL_UP_ANGEL = "LevelUpAngel";
    public static final String LIFE_GIVER = "LifeGiver";
    public static final String SMALL_ANGEL = "SmallAngel";
    public static final String SPAWNER = "Spawner";
    public static final String THE_DOOMER = "TheDoomer";
    public static final String XP_ANGEL = "XPAngel";

    // DIRECTION CONSTANTS
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';

    // PREFERRED LAND CONSTANTS
    public static final char KNIGHT_PREFERRED_LAND = 'L';
    public static final char PYROMANCER_PREFERRED_LAND = 'V';
    public static final char ROGUE_PREFERRED_LAND = 'W';
    public static final char WIZARD_PREFERRED_LAND = 'D';

    // LAND MODIFIERS
    public static final float KNIGHT_LAND_MODIFIER = 1.15f;
    public static final float PYROMANCER_LAND_MODIFIER = 1.25f;
    public static final float ROGUE_LAND_MODIFIER = 1.15f;
    public static final float WIZARD_LAND_MODIFIER = 1.10f;
    public static final float DEFAULT_LAND_MODIFIER = 1.0f;

    // HP CONSTANTS
    public static final int INITIAL_KNIGHT_HP = 900;
    public static final int INITIAL_PYROMANCER_HP = 500;
    public static final int INITIAL_ROGUE_HP = 600;
    public static final int INITIAL_WIZARD_HP = 400;
    public static final int BONUS_KNIGHT_HP = 80;
    public static final int BONUS_PYROMANCER_HP = 50;
    public static final int BONUS_ROGUE_HP = 40;
    public static final int BONUS_WIZARD_HP = 30;

    // EXPERIENCE CONSTANTS
    public static final int BASE_EXPERIENCE = 250;
    public static final int EXPERIENCE_MULTIPLIER = 50;
    public static final int BASE_GAIN_EXPERIENCE = 200;
    public static final int GAIN_EXPERIENCE_MULTIPLIER = 40;
    public static final int PERCENT_BASE = 100;

    // BACKSTAB CONSTANTS
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_LEVEL_MULTIPLIER = 20;
    public static final float BACKSTAB_ROGUE_MODIFIER = 1.2f;
    public static final float BACKSTAB_KNIGHT_MODIFIER = 0.9f;
    public static final float BACKSTAB_PYROMANCER_MODIFIER = 1.25f;
    public static final float BACKSTAB_WIZARD_MODIFIER = 1.25f;
    public static final float BACKSTAB_BONUS_MULTIPLIER = 1.5f;
    public static final int BACKSTAB_BONUS_ROUNDS = 3;

    // DEFLECT CONSTANTS
    public static final int DEFLECT_DEFLECTION_BASE_DAMAGE = 35;
    public static final int DEFLECT_DEFLECTION_LEVEL_MULTIPLIER = 2;
    public static final int DEFLECT_DEFLECTION_LIMIT = 70;
    public static final float DEFLECT_ROGUE_MODIFIER = 1.2f;
    public static final float DEFLECT_KNIGHT_MODIFIER = 1.4f;
    public static final float DEFLECT_PYROMANCER_MODIFIER = 1.3f;
    public static final float DEFLECT_WIZARD_MODIFIER = 0;

    // DRAIN CONSTANTS
    public static final int DRAIN_BASE_DAMAGE = 20;
    public static final int DRAIN_LEVEL_MULTIPLIER = 5;
    public static final float DRAIN_ROGUE_MODIFIER = 0.8f;
    public static final float DRAIN_KNIGHT_MODIFIER = 1.2f;
    public static final float DRAIN_PYROMANCER_MODIFIER = 0.9f;
    public static final float DRAIN_WIZARD_MODIFIER = 1.05f;
    public static final float DRAIN_HP_LIMIT = 0.3f;

    // EXECUTE CONSTANTS
    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int EXECUTE_LEVEL_MULTIPLIER = 30;
    public static final int EXECUTE_BASE_HP_LIMIT = 20;
    public static final int EXECUTE_LEVEL_MULTIPLIER_HP_LIMIT = 1;
    public static final float EXECUTE_ROGUE_MODIFIER = 1.15f;
    public static final float EXECUTE_KNIGHT_MODIFIER = 1f;
    public static final float EXECUTE_PYROMANCER_MODIFIER = 1.1f;
    public static final float EXECUTE_WIZARD_MODIFIER = 0.8f;
    public static final int EXECUTE_HP_LIMIT = 40;

    // FIREBLAST CONSTANTS
    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_LEVEL_MULTIPLIER = 50;
    public static final float FIREBLAST_ROGUE_MODIFIER = 0.8f;
    public static final float FIREBLAST_KNIGHT_MODIFIER = 1.2f;
    public static final float FIREBLAST_PYROMANCER_MODIFIER = 0.9f;
    public static final float FIREBLAST_WIZARD_MODIFIER = 1.05f;

    // IGNITE CONSTANTS
    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_LEVEL_MULTIPLIER = 20;
    public static final int IGNITE_DOT_BASE_DAMAGE = 50;
    public static final int IGNITE_DOT_LEVEL_MULTIPLIER = 30;
    public static final float IGNITE_ROGUE_MODIFIER = 0.8f;
    public static final float IGNITE_KNIGHT_MODIFIER = 1.2f;
    public static final float IGNITE_PYROMANCER_MODIFIER = 0.9f;
    public static final float IGNITE_WIZARD_MODIFIER = 1.05f;

    // PARALYSIS CONSTANTS
    public static final int PARALYSIS_DOT_BASE_DAMAGE = 40;
    public static final int PARALYSIS_DOT_LEVEL_MULTIPLIER = 10;
    public static final float PARALYSIS_ROGUE_MODIFIER = 0.9f;
    public static final float PARALYSIS_KNIGHT_MODIFIER = 0.8f;
    public static final float PARALYSIS_PYROMANCER_MODIFIER = 1.2f;
    public static final float PARALYSIS_WIZARD_MODIFIER = 1.25f;
    public static final int PARALYSIS_STANDARD_DURATION = 3;
    public static final int PARALYSIS_CRITICAL_DURATION = 6;

    // SLAM CONSTANTS
    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_LEVEL_MULTIPLIER = 40;
    public static final float SLAM_ROGUE_MODIFIER = 0.8f;
    public static final float SLAM_KNIGHT_MODIFIER = 1.2f;
    public static final float SLAM_PYROMANCER_MODIFIER = 0.9f;
    public static final float SLAM_WIZARD_MODIFIER = 1.05f;

    // LIFE GIVER CONSTANTS
    public static final int LIFE_GIVER_HP_BONUS_KNIGHT = 100;
    public static final int LIFE_GIVER_HP_BONUS_PYROMANCER = 80;
    public static final int LIFE_GIVER_HP_BONUS_ROGUE = 90;
    public static final int LIFE_GIVER_HP_BONUS_WIZARD = 120;

    // DAMAGE ANGEL CONSTANTS
    public static final float DAMAGE_ANGEL_DAMAGE_BONUS_KNIGHT = 0.15f;
    public static final float DAMAGE_ANGEL_DAMAGE_BONUS_PYROMANCER = 0.2f;
    public static final float DAMAGE_ANGEL_DAMAGE_BONUS_ROGUE = 0.3f;
    public static final float DAMAGE_ANGEL_DAMAGE_BONUS_WIZARD = 0.4f;

    // DARK ANGEL CONSTANTS
    public static final int DARK_ANGEL_HP_LOSS_KNIGHT = 40;
    public static final int DARK_ANGEL_HP_LOSS_PYROMANCER = 30;
    public static final int DARK_ANGEL_HP_LOSS_ROGUE = 10;
    public static final int DARK_ANGEL_HP_LOSS_WIZARD = 20;

    // DRACULA CONSTANTS
    public static final int DRACULA_HP_BONUS_KNIGHT = 60;
    public static final int DRACULA_HP_BONUS_PYROMANCER = 40;
    public static final int DRACULA_HP_BONUS_ROGUE = 35;
    public static final int DRACULA_HP_BONUS_WIZARD = 20;
    public static final float DRACULA_DAMAGE_BONUS_KNIGHT = 0.2f;
    public static final float DRACULA_DAMAGE_BONUS_PYROMANCER = 0.3f;
    public static final float DRACULA_DAMAGE_BONUS_ROGUE = 0.1f;
    public static final float DRACULA_DAMAGE_BONUS_WIZARD = 0.4f;

    // GOOD BOY CONSTANTS
    public static final int GOOD_BOY_HP_BONUS_KNIGHT = 20;
    public static final int GOOD_BOY_HP_BONUS_PYROMANCER = 30;
    public static final int GOOD_BOY_HP_BONUS_ROGUE = 40;
    public static final int GOOD_BOY_HP_BONUS_WIZARD = 50;
    public static final float GOOD_BOY_DAMAGE_BONUS_KNIGHT = 0.4f;
    public static final float GOOD_BOY_DAMAGE_BONUS_PYROMANCER = 0.5f;
    public static final float GOOD_BOY_DAMAGE_BONUS_ROGUE = 0.4f;
    public static final float GOOD_BOY_DAMAGE_BONUS_WIZARD = 0.3f;

    // LEVEL UP ANGEL CONSTANTS
    public static final float LEVEL_UP_ANGEL_DAMAGE_BONUS_KNIGHT = 0.1f;
    public static final float LEVEL_UP_ANGEL_DAMAGE_BONUS_PYROMANCER = 0.2f;
    public static final float LEVEL_UP_ANGEL_DAMAGE_BONUS_ROGUE = 0.15f;
    public static final float LEVEL_UP_ANGEL_DAMAGE_BONUS_WIZARD = 0.25f;

    // SPAWNER CONSTANTS
    public static final int SPAWNER_HP_KNIGHT = 200;
    public static final int SPAWNER_HP_PYROMANCER = 150;
    public static final int SPAWNER_HP_ROGUE = 180;
    public static final int SPAWNER_HP_WIZARD = 120;

    // SMALL ANGEL CONSTANTS
    public static final int SMALL_ANGEL_HP_BONUS_KNIGHT = 10;
    public static final int SMALL_ANGEL_HP_BONUS_PYROMANCER = 15;
    public static final int SMALL_ANGEL_HP_BONUS_ROGUE = 20;
    public static final int SMALL_ANGEL_HP_BONUS_WIZARD = 25;
    public static final float SMALL_ANGEL_DAMAGE_BONUS_KNIGHT = 0.1f;
    public static final float SMALL_ANGEL_DAMAGE_BONUS_PYROMANCER = 0.15f;
    public static final float SMALL_ANGEL_DAMAGE_BONUS_ROGUE = 0.05f;
    public static final float SMALL_ANGEL_DAMAGE_BONUS_WIZARD = 0.1f;

    // XP ANGEL CONSTANTS
    public static final int XP_ANGEL_BONUS_XP_KNIGHT = 45;
    public static final int XP_ANGEL_BONUS_XP_PYROMANCER = 50;
    public static final int XP_ANGEL_BONUS_XP_ROGUE = 40;
    public static final int XP_ANGEL_BONUS_XP_WIZARD = 60;

    private Constants() {
    }
}
