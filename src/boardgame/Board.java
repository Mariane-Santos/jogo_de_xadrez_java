package boardgame;

public class Board {

    private int rowns;
    private int columns;
    private Piece [][] pieces;

    public Board(int rowns, int columns) {
        this.rowns = rowns;
        this.columns = columns;
        pieces = new Piece[rowns][columns];
    }

    public int getRowns() {
        return rowns;
    }

    public void setRowns(int rowns) {
        this.rowns = rowns;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row] [column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece( Piece piece, Position position){
        //matriz de peças declarada no tabuleiro
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
