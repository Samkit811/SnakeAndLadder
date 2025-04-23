import java.util.Random;

public class Dice {
    private int noOfDice;
    private Random random;

    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
        this.random = new Random();
    }

    public int diceThrow(){
        return  this.random.nextInt(6 * this.noOfDice) + 1;
    }
}
