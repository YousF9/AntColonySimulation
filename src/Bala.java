import java.util.List;
import java.util.Random;

public class Bala extends Ant {

    public Bala(int id, int lifeSpan, Node node) {
        super(id, lifeSpan, node);
    }

    public void newTurn(int currentTurn) {
        move();
        attack();

        if (currentTurn % 10 == 0) {
            age();
        }
    }

    public void move() {
        List<Node> adjacentNodes = node.getAdjacentNodes();
        Random random = new Random();
        int nextNodeIndex = random.nextInt(adjacentNodes.size());
        node.removeBala(this);
        node = adjacentNodes.get(nextNodeIndex);
        node.addBalaAnt(this);
    }

    public void attack() {
        if (node.getFriendlyAnts().size() > 0) {
            Random random = new Random();
            if (random.nextBoolean()) {
                node.getFriendlyAnts().get(0).die();
            }
        }

    }

    public void age() {
        lifeSpan--;

        if (lifeSpan < 1) {
            die();
        }
    }

    public void die() {
        alive = false;
        node.removeBala(this);
    }
}
