package OrganSimulation;
import java.util.Random;

public class Lung
    {
        private int oxygen = 95;
        private int newOxygen;
        private int lHealth = 100;
        private int newLHealth;
        private Random rand = new Random();

        public int getLHealth()
        {
            return lHealth;
        }

        public int getOxygen()
        {
            return oxygen;
        }

        //Oxygen Level Update

        public void update(int pumpRate)
        {
            newOxygen = oxygen + (pumpRate / 20) - 3 + rand.nextInt(4)-2;
            oxygen = Math.min(newOxygen , 100);

            //LungHealth
            newLHealth = lHealth -1+ (pumpRate/25) -2;
            lHealth = Math.min(newLHealth , 100);

        }
    }


