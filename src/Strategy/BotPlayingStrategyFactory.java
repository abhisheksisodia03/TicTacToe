package Strategy;

import Model.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    
    public static BotPlayingStrategy getBotPlayingDifficulty(BotDifficultyLevel botLevel){
        return new EasyBotPlayingStrategy();
    }
}
