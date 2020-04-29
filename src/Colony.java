public class Colony {

    private ColonyView colonyView;
    private ColonyNodeView colonyNodeView;

    public Colony(ColonyView colonyView) {
        this.colonyView = colonyView;
    }

    public void createColony() {

        //create 27x27 nodes
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ColonyNodeView colonyNodeView = new ColonyNodeView();
                colonyNodeView.setID(i + "," + j);
                colonyView.addColonyNodeView(colonyNodeView, i, j);
                Node node = new Node(colonyNodeView, i, j);

                //display queen-adjacent nodes for simulation start
                if ((i >= 12 && i <= 14) && (j >= 12 && j <= 14)) {
                    node.setOpen();
                }

                //create queen node
                if (i == 13 && j == 13 ) {
                    node.setFood(1000);
                    Queen queen = new Queen();
                    node.setQueen(queen);

                    //create 10 soldier ants
                    for (int k = 0; k < 10; k++) {
                        Soldier soldier = queen.createSoldier();
                        node.addSoldierAnt(soldier);
                    }
                    //create 4 scout ants
                    for (int k = 0; k < 4; k++){
                        Scout scout = queen.createScout();
                        node.addScoutAnt(scout);
                    }

                    //create 50 forager ants
                    for (int k = 0; k < 50; k++) {
                        Forager forager = queen.createForager();
                        node.addForagerAnt(forager);
                    }

                }

            }
        }

    }

    public void newTurn(int currentTurn) {
    }
}