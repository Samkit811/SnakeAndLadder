import java.util.HashMap;

public class Snake implements SpecialCell{
    private HashMap<Integer,Integer> snakeList;

    public Snake(){
        this.snakeList = new HashMap<>();
        this.addCells();
    }

    private void addCells(){
        this.addCellToList(50, 15);
        this.addCellToList(99, 3);
        this.addCellToList(70, 60);
    }

    @Override
    public boolean isCellSpecial(int cellNumber) {
        return this.snakeList.containsKey(cellNumber);
    }

    @Override
    public int cellEffect(int cellNumber) {
        return this.snakeList.get(cellNumber);
    }

    @Override
    public void addCellToList(int startPoint, int endPoint) {
        this.snakeList.put(startPoint, endPoint);
    }
}
