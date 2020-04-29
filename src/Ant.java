public abstract class Ant {

    int id;
    int lifeSpan;

    /*
    int turn;
    int age;
    Node nodeLocation;
    boolean alive;*/

    public Ant(int id, int lifeSpan) {
        this.id = id;
        this.lifeSpan = lifeSpan; 
    }

    public abstract void newTurn ();




}
