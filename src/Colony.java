public class Colony {

    private ColonyView colonyView;
    private ColonyNodeView colonyNodeView;
    Node node;

    public Colony(ColonyView colonyView) {
        this.colonyView = colonyView;
    }

    public void createColony() {
        
        ColonyNodeView queenNode = new ColonyNodeView();
        colonyView.addColonyNodeView(queenNode, 13, 13);
        queenNode.showNode();
        queenNode.setQueen(true);
        queenNode.showQueenIcon();

        node = new Node(queenNode, 13, 13);
        node.setFood(1000);
        queenNode.setFoodAmount(1000);


        //create 27x27 nodes
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ColonyNodeView colonyNode = new ColonyNodeView();
                colonyView.addColonyNodeView(colonyNode, i, j);

                //display queen-adjacent nodes for simulation start
                if ((i >= 12 && i <= 14) && (j >= 12 && j <= 14)) {
                    colonyNode.showNode();
                    Queen queen = new Queen(node);

                    for (int scout = 0; scout < 4; scout++) {
                        queen.hatch(new Scout(node));
                    }

                }




            }
        }

    }

    public void newTurn(int currentTurn) {
    }
}