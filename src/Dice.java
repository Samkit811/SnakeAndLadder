import java.util.Random;

public class Dice {
    private int noOfDice;
    private Random random;

    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
        this.random = new Random();
    }

    public int diceThrow(){
        int diceValue = this.random.nextInt(6 * this.noOfDice) + 1;
        System.out.println("Dice value for this round is: " + diceValue);
        return  diceValue;
    }
}
