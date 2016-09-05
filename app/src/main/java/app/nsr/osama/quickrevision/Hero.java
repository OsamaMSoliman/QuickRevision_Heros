package app.nsr.osama.quickrevision;

/**
 * Created by OsamaNsr on 9/3/2016.
 */
public class Hero {

    private String heroName;
    private int id;

    public Hero(String heroName, int id) {
        this.heroName = heroName;
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroId() {
        return id;
    }

    @Override
    public String toString() {
        return getHeroName();
    }
}
