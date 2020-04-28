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
    boolean isQueen;
    boolean isMoving;
    boolean isVisible;
    boolean isColonyEntrance;
    LinkedList<Ant> antList;
    LinkedList<Ant> addToList;
    LinkedList<Ant> removeFromList;

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
        isQueen = false;
    }

    public void setFood(int unitOfFood) {
        food = unitOfFood;
    }


    public int getFood() {
        return food;
    }

    public int getPheremone() {
        return pheremone;
    }

    public void setPheremone(int pheremone) {
        this.pheremone = pheremone;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Colony getColony() {
        return colony;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }

    public void updateNodeView() {

    }
}