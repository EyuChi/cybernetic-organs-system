package OrganSimulation;

import java.util.Random;

public class Brain
{
        //(conEff) Stands for ControlEfficency
        private int conEff = 90;
        private int newConEff;
        private int newBHealth;
        private int bHealth = 100;

        private Random rand = new Random();

        //getter methods
        public int getBHealth()
        {
            return bHealth;
        }

        public int getConEff()
        {
            return conEff;
        }

        //manual way to change health for RNG
        public void changeBHealth(int amount)
        {
            newBHealth = amount + bHealth;
            bHealth = Math.min(newBHealth, 100); //To prevent overheal
        }


        public void update(int oxygen)
        {
            newConEff = conEff + (oxygen/20)-3 + rand.nextInt(4)-2;
            conEff = Math.min(newConEff, 100);

            //Brain Health
            newBHealth = bHealth -1 + (oxygen/25)-2;
            bHealth = Math.min(newBHealth, 100);
        }
}


