public class Ant {

    int id;
    int lifeSpan;
    int turn;
    int age;
    Node nodeLocation;
    boolean alive;

    public Ant(Node node) {
        id = 0;
        lifeSpan = 1;
        age = 0;
        alive = true;
        nodeLocation = node;

    }

    public Ant() {

    }

    public void newTurn (int turn) {

    }

    public void setAge(int turn) {
        age = turn;

    }

    public void setId(int id) {
        this.id = id;
    }


}
