public class Queen extends Ant {
    int nextId;
    int defaultLifeSpan = 365;

    public Queen() {
        super(0, 7300);
        nextId = 1;
    }

    public void newTurn() {

   }

   public Scout createScout() {

        return new Scout(nextId++, defaultLifeSpan);

   }

   public Soldier createSoldier() {
        return new Soldier(nextId++, defaultLifeSpan);
   }

    public Forager createForager() {
        return new Forager(nextId++, defaultLifeSpan);
    }

}
