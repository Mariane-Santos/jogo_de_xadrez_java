package boardgame;

public class Piece {

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
}
