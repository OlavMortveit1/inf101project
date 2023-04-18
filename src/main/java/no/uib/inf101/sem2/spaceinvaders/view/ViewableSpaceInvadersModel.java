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

    int getPlayerCannonPos();

    int getEnemyX();

    int getEnemyY();

    int getProjectileX();

    int getProjectileY();

    LaserState getLaserState();

    void changeToNotAcitveLaserState();

    ArrayList<ArrayList<Boolean>> getEnemies();

    void annihilateEnemy(int posRow, int posCol);

    void changeGameStateToWin();

    void changeGameStateToGameOver();

}
