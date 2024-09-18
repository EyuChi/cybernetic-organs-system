package OrganSimulation;

import java.util.Random;

public class RNG {
    private Random rand;

    public RNG()
    {
        this.rand = new Random();
    }

    //method with a 10% to heal or damage a random organ
    public void RNGesus(Heart heart, Lung lung, Brain brain)
    {
        if (rand.nextInt(10)==0)
        {
            //Select one of the three organs from a switch case
            int organSelect = rand.nextInt(3);
            //Deals +10 to -10 points, Pray for a natural 20
            int healthChange = rand.nextInt(21)-10;

            //Switch Cases
            switch (organSelect)
            {
                case 0:
                    heart.changeHealth(healthChange);
                    System.out.println("EVENT: Heart's Health has changed by " + healthChange + "%!");
                    break;

                case 1:
                    brain.changeBHealth(healthChange);
                    System.out.println("EVENT: Brain's Health has changed by " + healthChange + "% !");
                    break;

                case 2:
                    lung.changeLHealth(healthChange);
                    System.out.println("EVENT: Lung's Health has changed by " + healthChange + "% !");
                    break;
            }
        }
    }

}
