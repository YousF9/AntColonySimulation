import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Node {

    private int food;
    private int pheremone;
    private int xCoordinate;
    private int yCoordinate;
    private Colony colony;
    ColonyNodeView nodeView;
    boolean isMoving;
    boolean isVisible;
    Queen queen;
    LinkedList<Scout> scoutList;
    LinkedList<Soldier> soldierList;
    LinkedList<Forager> foragerList;

    Node(ColonyNodeView nodeView, int xCoordinate, int yCoordinate) {
        Random random = new Random();
        if (random.nextInt(4) == 0) {
            food = random.nextInt((1000 - 500) + 1) + 500;
        } else {
            food = 0;
        }

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.nodeView = nodeView;
        isVisible = false;
        scoutList = new LinkedList<>();
        soldierList = new LinkedList<>();
        foragerList = new LinkedList<>();
    }

    public void setQueen(Queen queen){
        this.queen = queen;
        nodeView.setQueen(true);
        nodeView.showQueenIcon();
    }

    public void addSoldierAnt(Soldier ant) {
        soldierList.add(ant);
        nodeView.setSoldierCount(soldierList.size());
        nodeView.showSoldierIcon();
    }

    public void addScoutAnt(Scout ant){
        scoutList.add(ant);
        nodeView.setScoutCount(scoutList.size());
        nodeView.showScoutIcon();
    }

    public void addForagerAnt(Forager ant) {
        foragerList.add(ant);
        nodeView.setForagerCount(foragerList.size());
        nodeView.showForagerIcon();
    }

    public void setFood(int unitOfFood) {
        food = unitOfFood;
        nodeView.setFoodAmount(food);
    }

    public void setOpen() {
        nodeView.showNode();

    }


}