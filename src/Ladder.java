import java.util.HashMap;

public class Ladder implements SpecialCell{

    private HashMap<Integer, Integer> ladderList;

    public Ladder(){
        this.ladderList = new HashMap<>();
        this.addCells();
    }

    private void addCells(){
        this.addCellToList(10, 24);
        this.addCellToList(35, 69);
    }

    @Override
    public boolean isCellSpecial(int cellNumber) {
        return this.ladderList.containsKey(cellNumber);
    }

    @Override
    public int cellEffect(int cellNumber) {
        return this.ladderList.get(cellNumber);
    }

    @Override
    public void addCellToList(int startPoint, int endPoint) {
        this.ladderList.put(startPoint, endPoint);
    }
}
