package Strategy;

import Model.Move;
import Model.Board;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
