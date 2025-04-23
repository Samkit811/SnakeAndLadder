public class Player {
    private int id;
    private String name;
    private int currentPositionOnBoard;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPositionOnBoard() {
        return currentPositionOnBoard;
    }

    public void setCurrentPositionOnBoard(int position){
        this.currentPositionOnBoard = position;
    }
}
