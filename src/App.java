import java.util.ArrayList;
import Controller.GameController;
import Model.Game;
import Model.GameState;

public class App {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController();
        Game game = gameController.startGame(3, new ArrayList<>(), new ArrayList<>());

        while(game.getGameState().equals(GameState.INPROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
    }
}
