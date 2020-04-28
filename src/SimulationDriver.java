public class SimulationDriver {
    public static void main(String[] args) {
        AntSimGUI antSimGUI = new AntSimGUI();
        ColonyView colonyView = new ColonyView(27,27);
        antSimGUI.initGUI(colonyView);
        Colony colony = new Colony(colonyView);
        antSimGUI.addSimulationEventListener(new Simulation(colony, antSimGUI));


    }
}
