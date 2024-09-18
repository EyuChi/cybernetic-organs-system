package OrganSimulation;
import java.util.Random;

public class Heart
{
    private int pumpRate = 70;
    private int newPumpRate;
    private int Health = 100;
    private int newHealth;
    private Random rand = new Random();

    public int getHealth()
    {
        return Health;
    }

    public int getPumpRate()
    {
        return this.pumpRate;
    }

    // Update method based on the brain's control efficiency
    public void updatePumpRate(int conEff) {
        //The new pump rate based on the formula from sheet
        newPumpRate = this.pumpRate + (conEff / 10) - 5 + rand.nextInt(8) - 4;
        this.pumpRate = Math.min(newPumpRate, 100);
    }
    public void updateHealth(int oxygen)
    {
        newHealth = Health -1 + (oxygen/ 25) - 2;
        Health = Math.min(newHealth, 100);
    }
}
