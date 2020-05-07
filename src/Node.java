import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Node implements Comparable {

    private int food;
    private Integer pheromone;
    boolean open;
    ColonyNodeView nodeView;
    Queen queen;
    LinkedList<Scout> scoutList;
    LinkedList<Soldier> soldierList;
    LinkedList<Forager> foragerList;
    LinkedList<Bala> balaList;
    List<Node> adjacentNodes;

    Node(ColonyNodeView nodeView) {
        Random random = new Random();
        if (random.nextInt(4) == 0) {
            food = random.nextInt(501) + 500;
        } else {
            food = 0;
        }
        nodeView.setFoodAmount(food);
        this.nodeView = nodeView;
        this.open = false;
        scoutList = new LinkedList<>();
        soldierList = new LinkedList<>();
        foragerList = new LinkedList<>();
        balaList = new LinkedList<>();
        pheromone = 0;
        nodeView.setPheromoneLevel(pheromone);
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
        nodeView.setQueen(true);
        nodeView.showQueenIcon();
    }

    public void addSoldierAnt(Soldier ant) {
        soldierList.add(ant);
        nodeView.setSoldierCount(soldierList.size());
        nodeView.showSoldierIcon();
    }

    public void addScoutAnt(Scout ant) {
        scoutList.add(ant);
        nodeView.setScoutCount(scoutList.size());
        nodeView.showScoutIcon();
    }

    public void addForagerAnt(Forager ant) {
        foragerList.add(ant);
        nodeView.setForagerCount(foragerList.size());
        nodeView.showForagerIcon();
    }

    public void addBalaAnt(Bala ant) {
        balaList.add(ant);
        nodeView.setBalaCount(balaList.size());
        nodeView.showBalaIcon();
    }

    public void setFood(int unitOfFood) {
        food = unitOfFood;
        nodeView.setFoodAmount(food);
    }

    public int getFood() {
        return food;
    }

    public void addPheromone(int pheromone) {

        if (this.pheromone < 1000) {
            this.pheromone += pheromone;
            nodeView.setPheromoneLevel(this.pheromone);
        }
    }

    public Integer getPheromone() {
        return pheromone;
    }

    public void setPheromone(int pheromone) {
        this.pheromone = pheromone;
        nodeView.setPheromoneLevel(this.pheromone);
    }

    public void setOpen() {
        nodeView.showNode();
        open = true;
    }

    public boolean isOpen() {
        return open;
    }


    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public List<Node> getOpenAdjacentNodes() {
        List<Node> openNodes = new ArrayList<>();
        for (int i = 0; i < adjacentNodes.size(); i++) {
            Node node = adjacentNodes.get(i);
            if (node.isOpen()) {
                openNodes.add(node);
            }
        }
        return openNodes;
    }

    public void removeScout(Scout ant) {
        scoutList.remove(ant);

        if (scoutList.size() == 0) {
            nodeView.hideScoutIcon();
        }

        nodeView.setScoutCount(scoutList.size());
    }

    public void removeSoldier(Soldier ant) {
        soldierList.remove(ant);

        if (soldierList.size() == 0) {
            nodeView.hideSoldierIcon();
        }

        nodeView.setSoldierCount(soldierList.size());
    }

    public void removeForager(Forager ant) {
        foragerList.remove(ant);

        if (foragerList.size() == 0) {
            nodeView.hideForagerIcon();
        }

        nodeView.setForagerCount(foragerList.size());
    }

    public void removeBala(Bala ant) {
        balaList.remove(ant);

        if (balaList.size() == 0) {
            nodeView.hideBalaIcon();
        }

        nodeView.setBalaCount(balaList.size());
    }

    public List<Ant> getFriendlyAnts() {
        List<Ant> friendlyAnts = new ArrayList<>();

        friendlyAnts.addAll(scoutList);
        friendlyAnts.addAll(soldierList);
        friendlyAnts.addAll(foragerList);
        if (queen != null) {
            friendlyAnts.add(queen);
        }

        return friendlyAnts;
    }

    public List<Bala> getBalaAnts() {
        return balaList;
    }

    @Override
    public int compareTo(Object o) {
        return ((Node) o).getPheromone().compareTo(this.pheromone);
    }

}