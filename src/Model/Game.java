package Model;

import java.util.ArrayList;
import java.util.List;
import Exceptions.PlayerCountDimensionMissmatchException;
import Strategy.WinningStrategy;

public class Game {
    private List<Player> players;
    private Board board;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;
    private Player winner;
    private GameState gameState;
    private List<Move> moves;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.INPROGRESS;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.board = new Board(dimension);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void printBoard(){
        board.printBoard();
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s move.");
        Move move = currentPlayer.makeMove(board);

        if(!validateMove(move)){
            System.out.println("Invalid move. Please try again.");
            return;
        }
        
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentPlayer);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
        
        if(checkWinner(board, finalMove)){
            gameState = GameState.WINNER;
            winner = currentPlayer;
        }
        else if(moves.size() == (board.getSize() * board.getSize())){
            gameState = GameState.DRAW;
        }
    }

    public boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >= board.getSize() || col >= board.getSize()){
            return false;
        }
        if(move.getCell().getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;
    }

    public boolean checkWinner(Board board, Move move){
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    public void undo(){
        if(moves.size() == 0){
            System.out.println("There is no move to undo.");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);

        Cell lastCell = lastMove.getCell();
        lastCell.setCellState(CellState.EMPTY);

        for(WinningStrategy winningStrategy: winningStrategies){
            winningStrategy.handleUndo(board, lastMove);
        }
        lastCell.setPlayer(null);

        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();
    }

    
    public static class GameBuilder{
        private List<Player> players;
        private int dimensions;
        private List<WinningStrategy> winningStrategies;

        public GameBuilder setDimension(int dimension) {
            this.dimensions = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder addPlayers(Player player) {
            this.players.add(player);
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder addWinningStrategies(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build() throws PlayerCountDimensionMissmatchException{
            validate();

            return new Game(dimensions, players, winningStrategies);
        }

        private void validate() throws PlayerCountDimensionMissmatchException{
            validateDimensionsPlayerCount();
        }

        private void validateDimensionsPlayerCount() throws PlayerCountDimensionMissmatchException{
            if(players.size() != (dimensions - 1)){
                throw new PlayerCountDimensionMissmatchException();
            }
        }

    }
}
