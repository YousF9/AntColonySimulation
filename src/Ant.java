public abstract class Ant {

    int id;
    int lifeSpan;
    boolean alive;
    Node node;

    public Ant(int id, int lifeSpan, Node node) {
        this.id = id;
        this.lifeSpan = lifeSpan;
        alive = true;
        this.node = node;
    }


    public int getId() {
        return id;
    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void die();

    public abstract void newTurn(int currentTurn);


}
