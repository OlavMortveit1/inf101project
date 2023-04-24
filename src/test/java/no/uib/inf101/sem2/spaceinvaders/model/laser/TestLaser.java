package no.uib.inf101.sem2.spaceinvaders.model.laser;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TestLaser {
    @Test
    public void testMoveLaser(){
        /**Lager to lasere med samme xPos */
        Laser beforeMoveLaser = new Laser(200);
        Laser afterMoveLaser = new Laser(200);
        /**Kaller moveLaser på den ene */
        afterMoveLaser.moveLaser();
        /**Sjekker at de ikke har samme verdi */
        assertNotEquals(afterMoveLaser, beforeMoveLaser);


    }
    
}
