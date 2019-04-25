import java.util.Set;

public class SudokuCell {
	
	private Coordinates pos;
	private Set<Coordinates> neighbors;
	private int value;
	
	public SudokuCell(Coordinates pos, Set<Coordinates> neighbors, int value) {
		this.pos = pos;
		this.neighbors = neighbors;
		this.value = value;
	}
	
	public void setPosition(Coordinates pos) {
		this.pos = pos;
	}
	
	private void generateAllNeighbors() {
		
	}

}
