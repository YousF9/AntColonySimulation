import java.util.LinkedList;
import java.util.Random;

public class Queen extends Ant {
    int nextId;
    private static final int DEFAULT_LIFE_SPAN = 365;
    LinkedList<Ant> antList;

    public Queen(LinkedList<Ant> antList, Node node) {
        super(0, 7300, node);
        this.antList = antList;
        nextId = 1;
    }

    public void newTurn(int currentTurn) {
        if (currentTurn % 10 == 0) {
            age();
            hatch();
        }

        eat();
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

    public void eat() {
        int food = node.getFood();
        if (food > 0) {
            food--;
            node.setFood(food);
        } else {
            die();
        }

    }

    public void die() {
        alive = false;
        throw new DeadQueenException();
    }

    public void age() {
        lifeSpan--;

        if (lifeSpan == 0) {
            die();
        }
    }

    public void createScout() {
        Scout scout = new Scout(nextId++, DEFAULT_LIFE_SPAN, node);
        node.addScoutAnt(scout);
        antList.add(scout);
    }

    public void createSoldier() {
        Soldier soldier = new Soldier(nextId++, DEFAULT_LIFE_SPAN, node);
        node.addSoldierAnt(soldier);
        antList.add(soldier);
    }

    public void createForager() {
        Forager forager = new Forager(nextId++, DEFAULT_LIFE_SPAN, node);
        node.addForagerAnt(forager);
        antList.add(forager);
    }

    public void createBala(Node node) {
        Bala bala = new Bala(nextId++, DEFAULT_LIFE_SPAN, node);
        node.addBalaAnt(bala);
        antList.add(bala);
    }

}
