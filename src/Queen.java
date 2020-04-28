public class Queen extends Ant {

    public Queen(Node node) {
        id = 0;
        lifeSpan = 365 * 20;
        nodeLocation = node;
    }

    public void hatch(Ant ant) {
        Ant hatchedAnt;
        hatchedAnt = new Scout(nodeLocation);
    }

    public void newTurn(int turn) {
        this.turn = turn;



    }

}
