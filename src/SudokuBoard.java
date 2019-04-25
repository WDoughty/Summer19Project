
public class SudokuBoard {

	final int SIZE;
	
	public SudokuBoard() {
		SIZE = 0;
		
	}
	
	public void fillCells() {
		
	}
	
	public Coordinates resolveIndex(int index) {
		return null;
	}
	
	public int resolvePosition(Coordinates pos) {
		return pos.getX() * SIZE + pos.getY();
	}
	
	
}
