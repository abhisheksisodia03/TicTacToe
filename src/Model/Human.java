package Model;

import java.util.Scanner;

public class Human extends Player{
    private Scanner scanner;

    public Human(long id, String name, Symbol symbol){
        super(id, name, symbol, PlayerType.HUMAN);
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) {
        System.out.println("Please tell us the row where you want to make the move.");
        int row = scanner.nextInt();
        System.out.println("Please tell us the column where you want to make the move.");
        int col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }
}
