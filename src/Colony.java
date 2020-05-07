import java.util.*;

public class Colony {

    private ColonyView colonyView;
    private ColonyNodeView colonyNodeView;
    LinkedList<Ant> antList;
    Node[][] nodes;
    Queen queen;

    public Colony(ColonyView colonyView) {
        this.colonyView = colonyView;
        nodes = new Node[27][27];

    }

    public void createColony() {
        antList = new LinkedList<>();

        //create 27x27 nodes
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ColonyNodeView colonyNodeView = new ColonyNodeView();
                colonyNodeView.setID(i + "," + j);
                colonyView.addColonyNodeView(colonyNodeView, i, j);
                Node node = new Node(colonyNodeView);
                nodes[i][j] = node;

                //display queen-adjacent nodes for simulation start
                if ((i >= 12 && i <= 14) && (j >= 12 && j <= 14)) {
                    node.setFood(0);
                    node.setOpen();
                }

                //create queen node
                if (i == 13 && j == 13) {
                    node.setFood(1000);
                    queen = new Queen(antList, node);
                    node.setQueen(queen);
                    antList.add(queen);

                    //create 10 soldier ants
                    for (int k = 0; k < 10; k++) {
                        queen.createSoldier();
                    }
                    //create 4 scout ants
                    for (int k = 0; k < 4; k++) {
                        queen.createScout();
                    }

                    //create 50 forager ants
                    for (int k = 0; k < 50; k++) {
                        queen.createForager();
                    }

                }

            }
        }

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                Node currentNode = nodes[i][j];
                List<Node> adjacentNodes = new ArrayList<>();
                addAdjacentNode(i - 1,j - 1, adjacentNodes);
                addAdjacentNode(i - 1,j, adjacentNodes);
                addAdjacentNode(i - 1,j + 1, adjacentNodes);
                addAdjacentNode(i,j - 1, adjacentNodes);
                addAdjacentNode(i,j + 1, adjacentNodes);
                addAdjacentNode(i + 1,j - 1, adjacentNodes);
                addAdjacentNode(i + 1,j, adjacentNodes);
                addAdjacentNode(i + 1,j + 1, adjacentNodes);
                currentNode.setAdjacentNodes(adjacentNodes);
            }
        }

    }

    private void addAdjacentNode(int x, int y, List<Node> adjacentList) {
        try {
            Node node = nodes[x][y];
            adjacentList.add(node);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public void newTurn(int currentTurn) {
        //loop through main ant list to have each ant take its turn
        for (int i = 0; i < antList.size(); i++) {
            Ant ant = antList.get(i);
            if (ant.isAlive()) {
                ant.newTurn(currentTurn);
            }
        }

        Iterator<Ant> antIterator = antList.iterator();
        while (antIterator.hasNext()) {
            Ant ant = antIterator.next();

            if (!ant.isAlive()) {
                antIterator.remove();
            }
        }

        Random random = new Random();
        if (random.nextInt(100) < 3) {
            queen.createBala(nodes[0][0]);
        }

        if ((currentTurn % 10) == 0) {
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    int pheromoneLevel = nodes[i][j].getPheromone();
                    pheromoneLevel /= 2;
                    nodes[i][j].setPheromone(pheromoneLevel);
                }
            }
        }
    }
}