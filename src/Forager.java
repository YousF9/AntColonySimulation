import java.util.*;

public class Forager extends Ant {

    boolean carryingFood;
    Stack<Node> movementHistory;
    Node queenNode;

    public Forager(int id, int lifeSpan, Node node) {
        super(id, lifeSpan, node);
        carryingFood = false;
        movementHistory = new Stack<>();
        this.queenNode = node;
    }

    public void newTurn(int currentTurn) {
        if (carryingFood) {
            returnToNest();
            if (node == queenNode) {
                dropFood();
                movementHistory.clear();
            }
        } else {
            move();
            pickUpFood();
        }

        if (currentTurn % 10 == 0) {
            age();
        }

    }

    public void move() {
        List<Node> openAdjacentNodes = node.getOpenAdjacentNodes();
        List<Node> eligibleNodes = new ArrayList<>();

        for (int i = 0; i < openAdjacentNodes.size(); i++) {
            Node node = openAdjacentNodes.get(i);
            if (!movementHistory.contains(node)) {
                eligibleNodes.add(node);
            }
        }

        if (eligibleNodes.isEmpty()) {
            eligibleNodes = openAdjacentNodes;
        }

        if (eligibleNodes.size() > 1 && movementHistory.size() > 0) {
            Node previousNode = movementHistory.peek();
            eligibleNodes.remove(previousNode);
        }

        Collections.sort(eligibleNodes);

        List<Node> equalPheromones = new ArrayList<>();

        for (int i = 0; i < eligibleNodes.size(); i++) {
            if (equalPheromones.isEmpty()) {
                equalPheromones.add(eligibleNodes.get(i));
            } else {
                if (equalPheromones.get(0).getPheromone().equals(eligibleNodes.get(i).getPheromone())) {
                    equalPheromones.add(eligibleNodes.get(i));
                }
            }
        }

        Random random = new Random();
        int nextNodeIndex = random.nextInt(equalPheromones.size());

        node.removeForager(this);
        movementHistory.push(node);
        node = equalPheromones.get(nextNodeIndex);
        node.addForagerAnt(this);
    }

    public void returnToNest() {
        node.addPheromone(10);
        node.removeForager(this);
        node = movementHistory.pop();
        node.addForagerAnt(this);
    }

    public void dropFood() {
        int food = node.getFood();
        node.setFood(++food);
        carryingFood = false;

    }

    public void pickUpFood() {
        int food = node.getFood();

        if (node != queenNode) {

            if (food > 0) {
                node.setFood(--food);
                carryingFood = true;
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
        if (carryingFood) {
            dropFood();
        }
        node.removeForager(this);
    }
}
