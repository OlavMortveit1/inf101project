package no.uib.inf101.sem2.spaceinvaders.controller;

import no.uib.inf101.sem2.spaceinvaders.model.GameState;
import no.uib.inf101.sem2.spaceinvaders.model.LaserState;

public interface ControllableSpaceInvadersModel {
    

    /**
     * Funksjonen returnerer gamestaten.
     * 
     * @return Den nåværende gamestaten.
     */
    GameState getGameState();

    /**
     * Funksjonen returnerer laserstaten.
     * 
     * @return Den nåværende laserstaten.
     */
    LaserState getLaserState();

    /**
     * Funksjonen flytter kanonen med horisontalMove lengder.
     * 
     * @param horisontalMove lengder kanonen skal flyttes.
     * @return Den nye posisjonen til kanonen.
     */
    int moveCannon(int horisontalMove);

    /**
     * Funksjonen flytter aliensa ved å kalle på funksjonen moveAlein() på objekt av typen alien 
     */
    void moveAliens();

    /**
     * Funksjonen returnerer tiden som er mellom hvert alien move, og hver gang 
     * laseren beveger seg et steg oppover
     * @return tiden mellom hver gang aliensa og laseren beveges.
     */
    int timeBetweenEachAlienLaserMove();

    /**
     * Funksjonen kalles hver gang "klokken tikker",
     * altså tiden som timeBetweenEachAlienLaserMove() returnerer
     */
    void clockTick();

    /**
     * Kaller på moveLaser() metoden på objekt av typen laser. 
     */
    void shootLaser();

    /**
     * Spawner inn en ny laser med x-posisjonen til kanonen,
     * hvis laserstaten ikke er active.
     * @param xPos x-posisjonen hvor den nye laseren skal spawner.
     */
    void newLaser(int xPos);

    /**
     * Finner x-posisjonen til kanonen og setter x-posisjonen til laseren 
     * ut i fra denne.
     */
    void setLaserX();

    /**
     * Finner posisjonen til kanonen.
     * @return x-posisjonen til kanonen.
     */
    int getPlayerCannonPos();

    /**
     * Endrer laserstate til active.
     */
    void changeLaserToActive();

    /**
     * Endrer gamestate til startscreen.
     */
    void changeToNewGame();

    /**
     * Funksjonen initialiserer alt i konstruktøren på ny,
     * alt er likt unntatt at gamestaten er active.
     */
    void start();

    
    
}

    

