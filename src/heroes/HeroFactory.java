package heroes;

public class HeroFactory {
    private static HeroFactory instance = new HeroFactory();

    private HeroFactory() {

    }

    public static HeroFactory getInstance() {
        return instance;
    }

    public Hero getHero(final String type, final int x, final int y) {
        if (type.equals("K")) {
            return new Knight(x, y);
        } else if (type.equals("P")) {
            return new Pyromancer(x, y);
        } else if (type.equals("R")) {
            return new Rogue(x, y);
        } else if (type.equals("W")) {
            return new Wizard(x, y);
        }
        return null;
    }
}
