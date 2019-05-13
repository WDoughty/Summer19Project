import java.util.*;

public class SudokuBoard {

	final int SIZE = 9;
	private SudokuBoard board;
	private List<SudokuCell> sudokuCellList;

	
	public SudokuBoard() {
		sudokuCellList = new ArrayList<>();
		for(int i = 0;i<9;i++){
			for(int j = 0; j<9;j++){
				Coordinates coord = new Coordinates(i,j);
				SudokuCell sudokuCell = new SudokuCell(coord, 0);
				sudokuCellList.add(sudokuCell);
			}
		}
		for(int i =0; i<sudokuCellList.size();i++){
			assignNeighbors(sudokuCellList.get(i));
		}
		for(int i=0;i<35;i++) {
			generateStartingValues();
		}
		fillCell();
	}

	public void assignNeighbors(SudokuCell sudokuCell){
		Set<SudokuCell> sudokuCellsSet = new HashSet<>();
		for(int i=0;i<sudokuCellList.size();i++) {
			if(!sudokuCell.equals(sudokuCellList.get(i))){
				if(sudokuCellList.get(i).getPos().getX() == sudokuCell.getPos().getX()
				|| sudokuCellList.get(i).getPos().getY() == sudokuCell.getPos().getY()
				||( sudokuCellList.get(i).getPos().getX()/3 == sudokuCell.getPos().getX()/3
						&& sudokuCellList.get(i).getPos().getY()/3 == sudokuCell.getPos().getY()/3))
						{
					sudokuCellsSet.add(sudokuCellList.get(i));
					sudokuCell.setNeighbors(sudokuCellsSet);
				}
			}
		}
	}


	public boolean fillCell() {
		for(int i=0; i<sudokuCellList.size();i++){
			if(sudokuCellList.get(i).getValue() == 0){
				for(int j=1;j<10; j++){
						if(isSafe(sudokuCellList.get(i),j)){
							sudokuCellList.get(i).setValue(j);
							if(fillCell() == true){
								return true;
							}
							else{
								sudokuCellList.get(i).setValue(0);
							}
						}
					}
					return false;
				}
			}
		return true;
	}


	public boolean isSafe(SudokuCell sudokuCell, int value){
		Iterator<SudokuCell> it = sudokuCell.neighbors.iterator();
		while(it.hasNext()){
			if(it.next().getValue() == value){
				return false;
			}
		}

		return true;
	}


	public void generateStartingValues() {
		Random rand = new Random();
		int num = rand.nextInt(81);
		int val = rand.nextInt(9) + 1;
		if (sudokuCellList.get(num).getValue() == 0) {
			if (isSafe(sudokuCellList.get(num), val)) {
				sudokuCellList.get(num).setValue(val);
			}
		}
	}

	
	public Coordinates resolveIndex(int index) {
		return null;
	}


	public int resolvePosition(Coordinates pos) {
		return pos.getY() * SIZE + pos.getX();
	}


	public void printSudokuBoard(){
		for(int i=0;i<sudokuCellList.size();i++){
			if(i%9==0){
				System.out.println();
			}
			System.out.print(sudokuCellList.get(i).getValue() + " ");
		}
	}
}
