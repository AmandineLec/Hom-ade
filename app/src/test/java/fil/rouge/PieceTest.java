package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    public void AgrandirTest(){
        Piece piece = new Piece("salon", 9);
        // piece.setTaille(piece.getTaille() + 1);

        piece.agrandir(1);
        assertTrue(piece.getTaille()==10);
    }

}
