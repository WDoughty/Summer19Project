import java.util.Set;

public class SudokuCell {
	
	private Coordinates pos;
	public Set<SudokuCell> neighbors;
	private int value;

	public SudokuCell(Coordinates pos, int value) {
		this.pos = pos;
		this.value = value;
	}

	public void setPosition(Coordinates pos) {
		this.pos = pos;
	}

	private void generateAllNeighbors() {

	}

	public int getValue(){
		return value;
	}

	public void setValue(int value){
		this.value = value;
	}

	public boolean isSafe(int num){

		return false;
		}

		public Coordinates getPos(){
		return pos;
	}

	public void setNeighbors(Set<SudokuCell> cells){
		neighbors = cells;
	}

}
