package Controller;

import java.util.List;

import Exceptions.PlayerCountDimensionMissmatchException;
import Model.Game;
import Model.GameState;
import Model.Player;
import Strategy.WinningStrategy;

public class GameController {
    
    public Game startGame(int dimension, 
                    List<Player> players, 
                    List<WinningStrategy> winningStrategies) throws PlayerCountDimensionMissmatchException{

        return Game.getBuilder()
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .setDimension(dimension)
                    .build();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public void undo(Game game){
        game.undo();
    }

    public String getWinner(Game game){
        return game.getWinner().getName();
    }
}
