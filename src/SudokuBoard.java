import java.util.*;

public class SudokuBoard {

	final int SIZE = 9;
	private SudokuBoard board;
	private List<SudokuCell> sudokuCellList;
	private int Solutions, blanks;
	private String start,end;

	/**
	 * Constructor
	 * Creates a new Sudoku Board
	 * Initialize the SudokuCellList with empty (0) values and assigns the neighbors to each cell
	 */
	public SudokuBoard() {
		board = this;
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

	}

	/**
	 * Constructor
	 * Creates new Sudoku board based on String seed
	 * Assigns values to each cell based on the String seed
	 * @param string Seed for new board
	 */
	public SudokuBoard(String string){
		board = this;
		sudokuCellList = new ArrayList<>();
		for(int i =0;i<9;i++){
			for(int j =0; j<9;j++){
				Coordinates coord = new Coordinates(i,j);
				SudokuCell sudokuCell = new SudokuCell(coord,Character.getNumericValue(string.charAt(i*9+j)));
				sudokuCellList.add(sudokuCell);
			}
		}

		for(int i =0; i<sudokuCellList.size();i++){
			assignNeighbors(sudokuCellList.get(i));
		}

	}

	/**
	 * Assigns neighbors of cells
	 * These are the cells that are in its submatrix and the horizontal and vertical axis is belongs to
	 * @param sudokuCell
	 */
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


	/**
	 * Recursive Backtracking algorithm to solved SudokuBoards
	 * If cell is empty (value of 0) then tries to place value in that cell.
	 * @return boolean
	 */
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


	/**
	 * Checks to see if the value is safe to place in the sudokuCell
	 * @param sudokuCell Cell that is checked
	 * @param value Value to be placed
	 * @return boolean
	 */
	public boolean isSafe(SudokuCell sudokuCell, int value){
		Iterator<SudokuCell> it = sudokuCell.neighbors.iterator();
		while(it.hasNext()){
			if(it.next().getValue() == value){
				return false;
			}
		}

		return true;
	}


	/**
	 * Generates *number* of starting values on the board
	 * @param number
	 */
	public void generateStartingValues(int number) {
		while(number>0){
		Random rand = new Random();
		int num = rand.nextInt(81);
		int val = rand.nextInt(9) + 1;
		if (sudokuCellList.get(num).getValue() == 0) {
			if (isSafe(sudokuCellList.get(num), val)) {
				sudokuCellList.get(num).setValue(val);
				number--;
				}
			}
		}


	}

	/**
	 * Takes index of sudokuCellList and converts it to its (x,y) position
	 * UNUSED
	 * @param index
	 * @return Coordinate
	 */
	public Coordinates resolveIndex(int index) {
		return null;
	}


	/**
	 * Takes the coordinates and changes them into an index position in the SudokuCellList. \
	 * UNUSED
	 * @param pos
	 * @return index in SudokuCellList
	 */
	public int resolvePosition(Coordinates pos) {
		return pos.getY() * SIZE + pos.getX();
	}


	/**
	 * Prints out the board in a 9x9 grid form
	 */
	public void printSudokuBoard(){
		for(int i=0;i<sudokuCellList.size();i++){
			if(i%9==0){
				System.out.println();
			}
			System.out.print(sudokuCellList.get(i).getValue() + " ");
		}
		System.out.println();
	}

	/**
	 * Creates a string of the beginning of the board and the solution of the board
	 * @return String of numbers
	 */
	public String makeString(){
		String string = "";
		for(int i=0;i<sudokuCellList.size();i++){
			string = string + sudokuCellList.get(i).getValue();
		}
		return string;
	}


	/**
	 * Checks to see if the board is actually solved.
	 * If any cell has a value of 0 this returns false
	 * @return boolean
	 */
	public boolean checkSolvedBoard() {
		for (int i = 0; i <sudokuCellList.size();i++){
			if(sudokuCellList.get(i).getValue() == 0){
				return false;
			}
		}
		return true;
	}


	/**
	 * Clears the Current Sudoku Board.
	 * Used in Generation of new boards
	 */
	public void clearSudokuBoard(){
		for(int i=0;i<sudokuCellList.size();i++){
			sudokuCellList.get(i).setValue(0);
		}
	}
}

