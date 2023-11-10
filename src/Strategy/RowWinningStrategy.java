package Strategy;

import java.util.HashMap;
import Model.Board;
import Model.Move;
import Model.Symbol;

public class RowWinningStrategy implements WinningStrategy{

    private HashMap<Integer, HashMap<Symbol, Integer>> map = new HashMap<>();
    
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol sym = move.getCell().getPlayer().getSymbol();

        if(!map.containsKey(row)){
            map.put(row, new HashMap<>());
        }
        HashMap<Symbol, Integer> rowMap = map.get(row);
        rowMap.put(sym, rowMap.getOrDefault(sym, 0)+1);
        if(rowMap.get(sym) == board.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol sym = move.getCell().getPlayer().getSymbol();

        HashMap<Symbol, Integer> rowMap = map.get(row);
        rowMap.put(sym, rowMap.get(sym)-1);
    }
    
}
