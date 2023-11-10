package Strategy;

import java.util.HashMap;
import Model.Board;
import Model.Move;
import Model.Symbol;

public class DiagWinningStrategy implements WinningStrategy{
    private HashMap<Symbol, Integer> leftDiagCount = new HashMap<>();
    private HashMap<Symbol, Integer> rightDiagCount = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        //left diagonal
        if(row == col){
            leftDiagCount.put(symbol, leftDiagCount.getOrDefault(symbol, 0)+1);

            if(leftDiagCount.get(symbol) == board.getSize()){
                return true;
            }
        }
        //right diagonal
        if(row+col == board.getSize()-1){
            rightDiagCount.put(symbol, rightDiagCount.getOrDefault(symbol, 0)+1);

            if(rightDiagCount.get(symbol) == board.getSize()){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row == col){
            leftDiagCount.put(symbol, leftDiagCount.get(symbol)-1);
        }

        if(row + col == board.getSize()-1){
            rightDiagCount.put(symbol, rightDiagCount.get(symbol)-1);
        }
    }
}
