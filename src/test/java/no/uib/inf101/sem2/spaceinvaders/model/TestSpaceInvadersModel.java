package no.uib.inf101.sem2.spaceinvaders.model;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.spaceinvaders.model.aliens.Alien;
import no.uib.inf101.sem2.spaceinvaders.model.cannon.Cannon;
import no.uib.inf101.sem2.spaceinvaders.model.laser.Laser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSpaceInvadersModel {
    @Test 
    public void testLaserXSamePosAsCannonX(){
        /**Lager ny model og kanon*/
        SpaceInvadersModel model = new SpaceInvadersModel();
        Cannon player = new Cannon();
        /**Kaller på shootLaser() for å skyte en laser ut av kanonen */
        model.shootLaser();
        /**Sjekker at laseren har samme x-verdi som kanonen */
        assertEquals(model.getProjectileX(), player.getCannonPos());
    }
    
    @Test
    public void testShootLaser(){
        /**Lager ny model og laser */
        SpaceInvadersModel model = new SpaceInvadersModel();
        Laser laser = new Laser(200);
        /**Skyter laseren oppover */
        model.shootLaser();
        /**Sjekker at laseren fikk ny y-verdi */
        assertNotEquals(model.getProjectileY(), laser.getLaserY());
    }

    @Test 
    public void testMoveCannon(){
        /**Lager ny model og kanon */
        SpaceInvadersModel model = new SpaceInvadersModel();
        Cannon player = new Cannon();
        /**Flytter kanonen med 10 */
        model.moveCannon(10);
        /**Sjekker at den ikke har samme posisjon */
        assertNotEquals(model.getPlayerCannonPos(), player.getCannonPos());
    }
    @Test
    public void testMoveAliens(){
        /**Lager ny model og alien */
        SpaceInvadersModel model = new SpaceInvadersModel();
        Alien alien = new Alien();
        /**Kaller moveAliens() på modellen */
        model.moveAliens();
        /**Sjekker at aliensa beveget seg */
        assertNotEquals(model.getEnemyX(), alien.getAlienX());
    }
    @Test
    public void testClockTick(){
        /**Lager ny model, alien og laser */
        SpaceInvadersModel model = new SpaceInvadersModel();
        Alien alien = new Alien();
        Laser laser = new Laser(100);
        /**Endrer laserstaten til aktiv, siden da vil laseren bevege seg når
         * clockTick() kalles på modellen.
         */
        model.changeLaserToActive();
        /**clockTick() gjør at aliens og laseren beveger seg */
        model.clockTick();
        /**Sjekker at både aliens og laseren fikk nye verdier */
        assertNotEquals(model.getEnemyX(), alien.getAlienX());
        assertNotEquals(model.getProjectileY(), laser.getLaserY());

    }

    @Test
    public void testNewLaser(){
        /**Lager en ny model og ny laser ved å kalle på newLaser() */
        SpaceInvadersModel model = new SpaceInvadersModel();
        model.newLaser(400);
        /**Sjekker at posisjonen til laseren ble riktig */
        assertEquals(model.getProjectileX(), 400);
        assertEquals(model.getProjectileY(), 730);

    }

    @Test
    public void testAnnihilateEnemy(){
        /**Lager ny model */
        SpaceInvadersModel model = new SpaceInvadersModel();
        /**Dreper alienen på posisjon (0,0) */
        model.annihilateEnemy(0,0);
        /**Sjekker at fienden ble fjernet (false ved pos (0,0)) */
        assertEquals(model.getEnemies(), new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(false, true, true, true, true, true, true)), 
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true)),
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true))
            )));
    }

    

}
