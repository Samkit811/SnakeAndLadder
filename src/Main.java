public class Main {
    public static void main(String[] args) {

        Player p1 = new Player(1, "raj");
        Player p2 = new Player(2, "jack");
        Player p3 = new Player(3, "jai");
        Player p4 = new Player(4, "Pj");
        Player p5 = new Player(5, "Sam");

        Ladder ladder = new Ladder();
        Snake snake = new Snake();

        Dice dice = new Dice(1);

        Arena arena = new Arena(100, 0, dice, ladder, snake);
        arena.addPlayer(p1);
        arena.addPlayer(p2);
        arena.addPlayer(p3);
        arena.addPlayer(p4);
        arena.addPlayer(p5);

        arena.startGame(2);
    }
}