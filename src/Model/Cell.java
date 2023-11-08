package Model;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int rows, int cols){
        this.row = rows;
        this.col = cols;
        this.cellState = CellState.EMPTY;
    }
    
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void display(){
        if(player == null){
            System.out.print("| - |");
        }
        else{
            System.out.print("| " + player.getSymbol().getSymb() + " |");
        }
    }
}
