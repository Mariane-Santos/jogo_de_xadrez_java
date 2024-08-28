package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board bord, Color color) {
        super(bord);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
