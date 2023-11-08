package Controller;

import java.util.List;

import Exceptions.PlayerCountDimensionMissmatchException;
import Model.Game;
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
}
