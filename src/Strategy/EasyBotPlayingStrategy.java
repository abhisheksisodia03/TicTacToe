package Strategy;

import java.util.List;

import Model.Board;
import Model.Cell;
import Model.CellState;
import Model.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell, null); 
                }
            }
        }
        return null;
    }
    
}
