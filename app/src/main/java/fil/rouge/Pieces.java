package fil.rouge;

// pas de sauvegarde en BDD, id créée en dur, lié a la maison grace au niveau

public class Pieces {
    protected int idPiece;

    protected int nbMeubles;

    //#region Constructeurs
    public Pieces(){
    }


    public int getId_piece() {
        return idPiece;
    }

    //#endregion
}
