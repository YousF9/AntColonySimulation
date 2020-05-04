import java.util.List;
import java.util.Random;

public class Scout extends Ant  {
    Scout(int id, int lifeSpan, Node node) {
        super(id, lifeSpan, node);
    }

    public void newTurn(int currentTurn) {
        move();

        if (currentTurn % 10 == 0) {
            age();
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
        node.removeScout(this);
    }

    public void move() {
        List<Node> adjacentNodes = node.getAdjacentNodes();
        Random random = new Random();
        int nextNodeIndex = random.nextInt(adjacentNodes.size());
        node.removeScout(this);
        node = adjacentNodes.get(nextNodeIndex);
        node.addScoutAnt(this);
        node.setOpen();
    }


}
