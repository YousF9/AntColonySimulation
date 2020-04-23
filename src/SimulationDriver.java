public class SimulationDriver {
    public static void main(String[] args) {
        AntSimGUI antSimGUI = new AntSimGUI();
        antSimGUI.addSimulationEventListener(new Simulation(antSimGUI));
    }
}
