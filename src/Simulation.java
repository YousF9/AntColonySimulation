import javax.swing.*;

public class Simulation implements SimulationEventListener {

    AntSimGUI antSimGui;
    Colony colonySimulator;
    boolean isQueenAlive;
    int currentTurn = 0;
    int day = 0;
    String time = "";
    Thread thread;

    //Simulation Constructor
    Simulation(Colony colonySimulator, AntSimGUI antSimGUI) {
        this.colonySimulator = colonySimulator;
        this.antSimGui = antSimGUI;
        isQueenAlive = true;
    }

    @Override
    public void simulationEventOccurred(SimulationEvent simEvent) {

        if (simEvent.getEventType() == SimulationEvent.NORMAL_SETUP_EVENT) {
            colonySimulator.createColony();
            antSimGui.setTime(time);
        }

        if (simEvent.getEventType() == SimulationEvent.STEP_EVENT) {
            newTurn();
        }

        if (simEvent.getEventType() == SimulationEvent.RUN_EVENT) {

            thread = new Thread() {
                public void run() {
                    try {
                        while (true) {
                            newTurn();
                            Thread.sleep(50);
                        }
                    } catch (DeadQueenException e) {
                        System.out.println("The queen is dead.");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();
        }

    }

    public void newTurn() {
        time = " Day " + day + " Turn " + currentTurn;
        antSimGui.setTime(time);
        colonySimulator.newTurn(currentTurn);
        currentTurn++;

        //every 10 turns == 1 day
        if (currentTurn % 10 == 0) {
            day++;
        }
    }
}
