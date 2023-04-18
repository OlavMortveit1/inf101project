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

    LaserState getLaserState();

    int moveCannon(int horisontalMove);

    void moveAliens();

    int timeBetweenEachAlienMove();

    void clockTick();

    void shootLaser();

    void newLaser(int x);

    void setLaserX();

    int getPlayerCannonPos();

    void changeLaserToActive();

    void changeToNewGame();

    void start();

    
    
}

    

