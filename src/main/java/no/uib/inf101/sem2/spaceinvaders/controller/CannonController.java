package no.uib.inf101.sem2.spaceinvaders.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import no.uib.inf101.sem2.spaceinvaders.model.GameState;
import no.uib.inf101.sem2.spaceinvaders.model.LaserState;
import no.uib.inf101.sem2.spaceinvaders.view.SpaceInvadersView;

public class CannonController implements java.awt.event.KeyListener {

    public ControllableSpaceInvadersModel cmodel;
    public SpaceInvadersView view; 
    private final Timer timer; 
    
    /**
     * Konstruktør
     * @param cmodel
     * @param view
     */
    public CannonController(ControllableSpaceInvadersModel cmodel, SpaceInvadersView view){
        this.cmodel = cmodel;
        this.view = view; 
        view.addKeyListener(this);
        view.setFocusable(true);
        this.timer = new Timer(cmodel.timeBetweenEachAlienLaserMove(), this::clockTick);
        
        timer.start();
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (cmodel.getGameState() == GameState.START_SCREEN){
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                cmodel.start();
            }
        }
        if(cmodel.getGameState() == GameState.WIN_GAME || cmodel.getGameState() == GameState.GAME_OVER){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                cmodel.changeToNewGame();
            }
        }
        if (cmodel.getGameState() == GameState.ACTIVE_GAME){
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                if (cmodel.getLaserState() == LaserState.NOT_ACTIVE_LASER){
                    cmodel.newLaser(cmodel.getPlayerCannonPos()+17);
                } 
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                cmodel.moveCannon(-7);
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                cmodel.moveCannon(7);
            }
        }
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
      
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }
    /**
     * Hvis gamestaten er active_game så startes metodene clockTick(),
     * setTimerDelay() og repaint().
     * @param event
     */
    private void clockTick(ActionEvent event){
        if (cmodel.getGameState() == GameState.ACTIVE_GAME){
            cmodel.clockTick();
            setTimerDelay();
            view.repaint();}

        }
    
    /**
     * Metoden finner delayen, og setter delayen ved å kalle på
     * setDelay og setInitialDelay på timer objektet. 
     */
    private void setTimerDelay(){
        int delay = cmodel.timeBetweenEachAlienLaserMove();
        timer.setDelay(delay); 
        timer.setInitialDelay(delay);
    }
}
    

