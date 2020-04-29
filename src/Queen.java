import java.util.Random;

public class Queen extends Ant {
    int nextId;
    int defaultLifeSpan = 365;

    public Queen() {
        super(0, 7300);
        nextId = 1;
    }

    public void newTurn() {

    }

    public void hatch() {
        Random random = new Random();
        if (random.nextInt(4) == 0) {
            createScout();
        }

        else if (random.nextInt(4) == 1) {
            createSoldier();
        }

        else {
            createForager();
        }
    }

    public Scout createScout() {

        return new Scout(nextId++, defaultLifeSpan);

    }

    public Soldier createSoldier() {
        return new Soldier(nextId++, defaultLifeSpan);
    }

    public Forager createForager() {
        return new Forager(nextId++, defaultLifeSpan);
    }

    public Bala createBala() {
        return new Bala(nextId++, defaultLifeSpan);
    }

}
