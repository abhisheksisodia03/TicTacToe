package Strategy;

import java.util.HashMap;
import Model.Board;
import Model.Move;
import Model.Symbol;

public class ColWinningStrategy implements WinningStrategy{

    private HashMap<Integer, HashMap<Symbol, Integer>> map = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol sym = move.getCell().getPlayer().getSymbol();
        if(!map.containsKey(col)){
            map.put(col, new HashMap<>());
        }
        HashMap<Symbol, Integer> colMap = map.get(col);
        colMap.put(sym, colMap.getOrDefault(col, 0)+1);
        if(colMap.get(sym) == board.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol sym = move.getCell().getPlayer().getSymbol();

        HashMap<Symbol, Integer> colMap = map.get(col);
        colMap.put(sym,colMap.get(sym)-1);
    }
    
}
