import java.util.LinkedList;
import java.util.Random;

public class Queen extends Ant {
    int nextId;
    int defaultLifeSpan = 365;
    LinkedList<Ant> antList;

    public Queen(LinkedList<Ant> antList, Node node) {
        super(0, 7300);
        this.antList = antList;
        nextId = 1;
    }

    public void newTurn() {

    }

    /**
     * When the queen hatches an ant, there is a 50% chance it is a forager, 25% it's a scout, and 25% it's a soldier
     **/
    public void hatch() {
        Random random = new Random();
        if (random.nextInt(4) == 0) {
            createScout();
        } else if (random.nextInt(4) == 1) {
            createSoldier();
        } else {
            createForager();
        }

    }

    public Scout createScout() {
        Scout scout = new Scout(nextId, lifeSpan);
        antList.add(scout);
        return new Scout(nextId++, defaultLifeSpan);
    }

    public Soldier createSoldier() {
        Soldier soldier = new Soldier(nextId, lifeSpan);
        antList.add(soldier);
        return new Soldier(nextId++, defaultLifeSpan);
    }

    public Forager createForager() {
        Forager forager = new Forager(nextId, lifeSpan);
        antList.add(forager);
        return new Forager(nextId++, defaultLifeSpan);
    }

    public Bala createBala() {
        return new Bala(nextId++, defaultLifeSpan);
    }

}
