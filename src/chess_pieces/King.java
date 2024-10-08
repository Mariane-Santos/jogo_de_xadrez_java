package chess_pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    //Testar se nesse posição que irei informar a torre tá ápta para jogada Roque
    private boolean testRookCastling(Position position) {
        //pegando a peça que tá na posição pasada no parâmetro
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //Direções que o Rei pode se mover ACIMA
        p.setValues(position.getRow() - 1, position.getColumn() );
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover ABAIXO
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a ESQUERDA
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a DIREITA
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a NOROESTE - NW
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a NORDESTE - NE
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a SUDOESTE - SW
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Direções que o Rei pode se mover a SUDESTE - SE
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // #Movimento especial Roque(Castling)
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #Movimento especial Castling Roque pequeno (Kingside Rook)
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1)  == null && getBoard().piece(p2) == null) {
                    mat [position.getRow()][position.getColumn() +2] = true;
                }
            }
            // #Movimento especial Castling Roque grande (queenside Rook)
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1)  == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat [position.getRow()][position.getColumn() -2] = true;
                }
            }
        }



        return mat;
    }
}
