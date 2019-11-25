package game.resources.heroes;

import game.resources.common.Constants;

public class HeroFactory {
    private static HeroFactory instance = new HeroFactory();

    private HeroFactory() {

    }

    public static HeroFactory getInstance() {
        return instance;
    }

    public Hero getHero(final String type, final int line, final int column) {
        if (type.equals(Constants.KNIGHT)) {
            return new Knight(line, column);
        } else if (type.equals(Constants.PYROMANCER)) {
            return new Pyromancer(line, column);
        } else if (type.equals(Constants.ROGUE)) {
            return new Rogue(line, column);
        } else if (type.equals(Constants.WIZARD)) {
            return new Wizard(line, column);
        }
        return null;
    }
}
