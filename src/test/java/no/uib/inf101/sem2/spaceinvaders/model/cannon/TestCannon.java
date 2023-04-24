package no.uib.inf101.sem2.spaceinvaders.model.cannon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCannon {
    @Test
    public void testMovedHorisontally(){
        Cannon movedCannon = new Cannon();
        movedCannon.movedHorisontally(10);
        /**Sjekker at posisjonen er 10 mer enn den originale */
        assertEquals(movedCannon.getCannonPos(), 310);
}
}
