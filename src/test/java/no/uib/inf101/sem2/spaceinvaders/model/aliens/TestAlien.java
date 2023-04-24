package no.uib.inf101.sem2.spaceinvaders.model.aliens;

import static org.junit.jupiter.api.Assertions.assertNotEquals;



import org.junit.jupiter.api.Test;


public class TestAlien {
    @Test
    public void testMoveAlien(){
        Alien alien = new Alien();
        /**Killcounten har ikke noe å si på om de beveger seg, kun hvor fort,
         * så setter den til 0.
         */
        alien.moveAlien(0);
        /**SJekker at den ikke er på den originale posisjonen */
        assertNotEquals(alien.getAlienX(), 20);

    }
    
    
    
}
