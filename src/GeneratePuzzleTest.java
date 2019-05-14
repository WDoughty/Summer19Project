
public class GeneratePuzzleTest {

    public static void main(String[] args){


        SudokuBoard board = new SudokuBoard();
        String start ="";
        int gen =1;
        while(!board.checkSolvedBoard()) {
            board.clearSudokuBoard();
            board.generateStartingValues(30);
            System.out.println("Generation: " +gen);
            gen++;
            board.printSudokuBoard();
            start = board.makeString();
            board.fillCell(board.sudokuCellList);
        }
        board.printSudokuBoard();


        System.out.println(start);
        String end = board.makeString();
        System.out.println(end);










    }


}
