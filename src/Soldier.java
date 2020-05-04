import java.util.List;
import java.util.Random;

public class Soldier extends Ant {

    public Soldier(int id, int lifeSpan, Node node) {
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
        List<Node> openAdjacentNodes = node.getOpenAdjacentNodes();

        /** Attack mode **/
        for (int i = 0; i < openAdjacentNodes.size(); i++) {
            Node adjacentNode = openAdjacentNodes.get(i);
            if (adjacentNode.getBalaAnts().size() > 0) {
                node.removeSoldier(this);
                node = adjacentNode;
                node.addSoldierAnt(this);
                return;
            }
        }


        /** Scout mode **/
        Random random = new Random();
        int nextNodeIndex = random.nextInt(openAdjacentNodes.size());

        node.removeSoldier(this);
        node = openAdjacentNodes.get(nextNodeIndex);
        node.addSoldierAnt(this);

    }

    public void attack() {
        if (node.getBalaAnts().size() > 0) {
            Random random = new Random();
            if (random.nextBoolean()) {
                node.getBalaAnts().get(0).die();
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
        node.removeSoldier(this);
    }
}
