
public class GeneratePuzzleTest {

    public static void main(String[] args){


        SudokuBoard board = new SudokuBoard();
        String start ="";

        while(!board.checkSolvedBoard()) {
            board.clearSudokuBoard();
            board.generateStartingValues(30);
            board.printSudokuBoard();
            start = board.makeString();
            board.fillCell();
        }
        board.printSudokuBoard();
        String end = board.makeString();








    }


}
