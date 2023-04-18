package no.uib.inf101.sem2.spaceinvaders.view;


import java.util.ArrayList;

import no.uib.inf101.sem2.spaceinvaders.model.GameState;
import no.uib.inf101.sem2.spaceinvaders.model.LaserState;

public interface ViewableSpaceInvadersModel {

    /**
     * Funksjonen returnerer gamestaten.
     * 
     * @return Den nåværende gamestaten.
     */
    GameState getGameState();

    /**
     * Funksjonen returnerer x-posisjonen til kanonen.
     * 
     * @return x-posisjonen til kanonen.
     */
    int getPlayerCannonPos();

    /**
     * Funksjonen henter ut x-posisjonen til alienen i venstre hjørne.
     * 
     * @return x-posisjonen til alienen alle aliensa blir tegnet ut ifra.
     */
    int getEnemyX();

    /**
     * Funksjonen henter ut y-posisjonen til alienen i venstre hjørne.
     * 
     * @return y-posisjonen til alinenen alle aliensa blir tegnet ut ifra.
     */
    int getEnemyY();

    /**
     * Funksjonen henter ut x-posisjonen til laseren.
     * 
     * @return x-posisjonen til laseren.
     */
    int getProjectileX();

    /**
     * Funksjonen henter ut y-posisjonen til laseren.
     * 
     * @return y-posisjonen til laseren.
     */
    int getProjectileY();

    /**
     * Funksjonen returnerer den nåværende laserstaten.
     * 
     * @return den nåværende laserstaten.
     */
    LaserState getLaserState();

    /**
     * Funksjonen endrer laserstaten til not active.
     */
    void changeToNotAcitveLaserState();

    /**
     * Funksjonen henter ut aliensa.
     * 
     * @return En 2d-liste over aliensa.
     */
    ArrayList<ArrayList<Boolean>> getEnemies();

    /**
     * Funksjonen dreper aliens ved å sette posisjonen til alienen i 2d-listen som false.
     * Kaller på changeToNotActiveLaserState().
     * Setter yPos til laseren på linje med kanonen.
     * Øker killcount med 1.
     * @param posRow row posisjonen til alienen i 2d-listen
     * @param posCol col posisjonen til alienen i 2d-listen
     */
    void annihilateEnemy(int posRow, int posCol);

    /**
     * Endrer gamestaten til win game.
     */
    void changeGameStateToWin();

    /**
     * Endrer gamestaten til game over.
     */
    void changeGameStateToGameOver();

}
