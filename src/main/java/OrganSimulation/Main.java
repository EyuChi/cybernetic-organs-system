package OrganSimulation;

public class Main {

    //intialize vars
    private int timeStep;
    private RNG rng;

    //sets up for new simulation each time
    public Main() {
        this.timeStep = 0;
        this.rng = new RNG();
    }

    public static void main(String[] args) {
        Heart heart = new Heart();
        Lung lung = new Lung();
        Brain brain = new Brain();
        Main main = new Main();
        main.start(heart, lung, brain);
    }

    //Starts all the Organ classes to do their thing
    public void start(Heart heart, Lung lung, Brain brain) {
        //Recursion via while loop until tiemstep reaches a 100, the rest of the conditions break the loop
        while (timeStep < 100 && heart.getHealth() > 0 && heart.getPumpRate() > 40 && lung.getLHealth() > 0 && lung.getOxygen() > 70 && brain.getBHealth() > 0 && brain.getConEff() > 50) {
            // 1.Print out the current stats of each organ per timestep
            System.out.println("\nTime Step: " + timeStep);
            System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
            System.out.println("Lung Health: " + lung.getLHealth() + " | Oxygen Level: " + lung.getOxygen());
            System.out.println("Brain Health: " + brain.getBHealth() + " | Control Efficiency: " + brain.getConEff());

            //2. Roll for damage
            rng.RNGesus(heart, lung, brain);

            //3. Update each organ
            heart.updatePumpRate(brain.getConEff());
            heart.updateHealth(lung.getOxygen());
            lung.update(heart.getPumpRate());
            brain.update(lung.getOxygen());

            //4. Increment the time step
            timeStep++;

            //5. Double Check if any organ has failed and print corresponding message

            //status of the heart
            if (heart.getHealth() <= 0)
                {
                    System.out.println("Simulation Ended: Heart failed! Condition of Heart is bad!");
                    break;
                }
            if (heart.getHealth() <= 25)
            {
                    System.out.println("ALERT at " + timeStep + ": Heart Critical! Heart's health at" + heart.getHealth() + "!");
                    break;
            }
            if (heart.getPumpRate() <= 40)
                {
                    System.out.println("Simulation Ended: Heart failed! Not enough blood pumping!");
                    break;
                }

                //status of the lungs
            if (lung.getLHealth() <= 0)
                {
                    System.out.println("Simulation Ended: Lung failed! Condition of Lung is bad!");
                    break;
                }
            if (lung.getLHealth() <= 25)
                {
                    System.out.println("ALERT at " + timeStep + ": Lungs Critical! Lung's health at" + lung.getLHealth() + "!");
                    break;
                }
            if (lung.getOxygen() <= 70)
                {
                    System.out.println("Simulation Ended: Lung failed! Not enough blood oxygen!");
                    break;
                }

                //status of the brain
            if (brain.getBHealth() <= 0)
                {
                    System.out.println("Simulation Ended: Brain failed! Condition of Brain is bad!");
                    break;
                }
            if (brain.getBHealth() <= 25)
                {
                    System.out.println("ALERT at " + timeStep + ": Brain Critical! Brain's health at" + brain.getBHealth() + "!");
                    break;
                }
            if (brain.getConEff() <= 50)
                {
                    System.out.println("Simulation Ended: Control Efficiency failed! Brain has a low EEG!");
                    break;
                }
            }//Then repeat until TimeStep = 100

            // Print final state
            printFinalState(heart, lung, brain);
        }

        private void printFinalState (Heart heart, Lung lung, Brain brain){
            System.out.println("\nFinal States:");
            System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
            System.out.println("Lung Health: " + lung.getLHealth() + " | Oxygen Level: " + lung.getOxygen());
            System.out.println("Brain Health: " + brain.getBHealth() + " | Control Efficiency: " + brain.getConEff());
        }
    }