package Model;

import Strategy.BotPlayingStrategy;
import Strategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(long id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel){
        super(id, name, symbol, PlayerType.BOT);
        this.botLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingDifficulty(difficultyLevel);
    }
    
    public BotDifficultyLevel getBotLevel() {
        return botLevel;
    }
    public void setBotLevel(BotDifficultyLevel botLevel) {
        this.botLevel = botLevel;
    }
    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }
    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
