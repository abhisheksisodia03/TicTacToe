import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.GameController;
import Model.Bot;
import Model.BotDifficultyLevel;
import Model.Game;
import Model.GameState;
import Model.Human;
import Model.Player;
import Model.Symbol;
import Strategy.ColWinningStrategy;
import Strategy.DiagWinningStrategy;
import Strategy.RowWinningStrategy;
import Strategy.WinningStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Human(1, "Abhishek", new Symbol('X')));
        players.add(new Bot(2, "Bot", new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = List.of(
                                                    new RowWinningStrategy(),
                                                    new ColWinningStrategy(),
                                                    new DiagWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);

        while(gameController.checkState(game).equals(GameState.INPROGRESS)) {
            gameController.printBoard(game);

            System.out.println("Do you want to undo? y/n");
            String undoAnswer = scanner.next();
            if(undoAnswer.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }
            gameController.makeMove(game);
        }

        System.out.println("Game is over");
        gameController.printBoard(game);

        GameState gameState = gameController.checkState(game);
        if(gameState.equals(GameState.DRAW)){
            System.out.println("Game is drawn");
        }
        else{
            System.out.println("We have a winner: " + gameController.getWinner(game));

        }
    }
}
