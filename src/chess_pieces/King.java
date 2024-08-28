package chess_pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board bord, Color color) {
        super(bord, color);
    }

    @Override
    public String toString(){
        return "K";
    }
}
