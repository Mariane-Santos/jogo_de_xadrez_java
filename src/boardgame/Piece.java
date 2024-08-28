package boardgame;

public abstract class Piece {

    protected Position position;
    private Board bord;

    public Piece(Board bord) {
        this.bord = bord;
        position = null;
    }

    //somente classes dentro do mesmo pacote e subclasses que vão consegir acessar o taboleiro
    protected Board getBord() {
        return bord;
    }

    //métodos retornando uma matriz
    public abstract boolean[][] possibleMoves();

    //um métodos concreto que tá utilizando um métodos abstrato (gancho com a subclasse)
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat.length; j++) {
                if (mat[i][j] ){
                    return true;
                }
            }
        }
        return false;
    }
}
