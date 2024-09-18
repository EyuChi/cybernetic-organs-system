package OrganSimulation;

public class Main {
    private int timeStep;

    public Main() {
        this.timeStep = 0;
    }

    public static void main(String[] args) {
        Heart heart = new Heart();
        Lung lung = new Lung();
        Brain brain = new Brain();
        Main main = new Main();
        main.start(heart, lung, brain);
    }

    public void start(Heart heart, Lung lung, Brain brain) {
        while (timeStep < 100 && heart.getHealth() > 0 && lung.getLHealth() > 0 && brain.getBHealth() > 0) {
            // Print out the current stats of each organ per timestep
            System.out.println("Time Step: " + timeStep);
            System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
            System.out.println("Lung Health: " + lung.getLHealth() + " | Oxygen Level: " + lung.getOxygen());
            System.out.println("Brain Health: " + brain.getBHealth() + " | Control Efficiency: " + brain.getConEff());

            // Update each organ
            heart.updatePumpRate(brain.getConEff());
            heart.updateHealth(lung.getOxygen());
            lung.update(heart.getPumpRate());
            brain.update(lung.getOxygen());

            // Increment the time step
            timeStep++;

            // Check if any organ has failed and print message if necessary
            if (heart.getHealth() <= 0) {
                System.out.println("Simulation Ended: Heart failed!");
                break;
            }
            if (lung.getLHealth() <= 0) {
                System.out.println("Simulation Ended: Lung failed!");
                break;
            }
            if (brain.getBHealth() <= 0) {
                System.out.println("Simulation Ended: Brain failed!");
                break;
            }
        }

        // Print final state
        printFinalState(heart, lung, brain);
    }

    private void printFinalState(Heart heart, Lung lung, Brain brain) {
        System.out.println("Final States:");
        System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
        System.out.println("Lung Health: " + lung.getLHealth() + " | Oxygen Level: " + lung.getOxygen());
        System.out.println("Brain Health: " + brain.getBHealth() + " | Control Efficiency: " + brain.getConEff());
    }
}