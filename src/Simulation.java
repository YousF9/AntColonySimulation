public class Simulation implements SimulationEventListener {

    Colony colonySimulator;
    AntSimGUI antSimGUI;
    boolean isQueenAlive;

    //Simulation Constructor
    Simulation(AntSimGUI antSimGUI) {
        this.antSimGUI = antSimGUI;
        isQueenAlive = true;
    }

    @Override
    public void simulationEventOccurred(SimulationEvent simEvent) {

    }
}
