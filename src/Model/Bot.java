package Model;

import Strategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botLevel;
    private BotPlayingStrategy botPlayingStrategy;
    
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
}
