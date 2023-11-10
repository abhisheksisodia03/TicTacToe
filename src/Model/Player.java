package Model;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    

    public Player(long id, String name, Symbol symbol, PlayerType type){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = type;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {        
        return this.makeMove(board);
    }


}
