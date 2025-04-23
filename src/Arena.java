import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena {
    private boolean isGameFinished = false;
    private int winningDestination;
    private int startingPosition;
    private List<Player> players;
    private Dice dice;
    private Ladder ladder;
    private Snake snake;

    public Arena(int winningDestination, int startingPosition, Dice dice, Ladder ladder, Snake snake){
        this.winningDestination = winningDestination;
        this.players = new ArrayList<>();
        this.dice = dice;
        this.startingPosition = startingPosition;
        this.ladder = ladder;
        this.snake = snake;
    }

    public void addPlayer(Player player){
        System.out.println("Adding the player: " + player);
        players.add(player);
        player.setCurrentPositionOnBoard(this.startingPosition);
    }

    public void startGame(int startingPersonId){
        System.out.println("Starting the Game");
        this.playGame(startingPersonId);
    }

    private void playGame(Integer startingPersonId){
        boolean isFirstRoundOver = false;
        while(!this.isGameFinished){
            Iterator<Player> iterator = this.players.iterator();
            if(!isFirstRoundOver){
                while(iterator.hasNext()){
                    Player player = iterator.next();
                    if(player.getId() == startingPersonId){
                        this.personTurn(player);
                        this.checkGameIsFinished(player);
                        if(this.isGameFinished){
                            break;
                        }
                    }
                }
                isFirstRoundOver = true;
            } else {
                while (iterator.hasNext()){
                    Player player = iterator.next();
                    this.personTurn(player);
                    this.checkGameIsFinished(player);
                    if(this.isGameFinished){
                        break;
                    }
                }
            }
        }
    }

    private void personTurn(Player player){
        int diceValue = this.dice.diceThrow();
        int nextPosition = player.getCurrentPositionOnBoard() + diceValue;
        this.checkPosition(nextPosition, player);
    }

    private void checkPosition(int position, Player player){
        if(position > this.winningDestination){
            System.out.println("Player can not reach Beyond the winning Destination  - " + this.winningDestination);
            return;
        }
        boolean isCellSpecial = false;
        if(this.ladder.isCellSpecial(position)){
            System.out.println("Player: " + player.getName() + " got the ladder");
            position = this.ladder.cellEffect(position);
            this.updatePosition(position, player);
            isCellSpecial = true;
        }
        if(this.snake.isCellSpecial(position)){
            System.out.println("Player: " + player.getName() + " got the Snake");
            position = this.snake.cellEffect(position);
            this.updatePosition(position, player);
            isCellSpecial = true;
        }

        if(!isCellSpecial){
            System.out.println("Player: " + player.getName() + " got the simple cell");
            this.updatePosition(position, player);
        }
    }

    private void updatePosition(int position, Player player) {
        System.out.println("Position Update to:" + position + " for Player: " + player.getName());
        player.setCurrentPositionOnBoard(position);
    }

    private void checkGameIsFinished(Player player){
        if(player.getCurrentPositionOnBoard() == this.winningDestination){
            System.out.println("Game Over and winner is: " + player.getName());
            this.isGameFinished = true;
        }
    }

}
