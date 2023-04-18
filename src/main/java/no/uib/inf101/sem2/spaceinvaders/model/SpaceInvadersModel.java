package no.uib.inf101.sem2.spaceinvaders.model;


import java.util.ArrayList;
import java.util.Arrays;
import no.uib.inf101.sem2.spaceinvaders.controller.ControllableSpaceInvadersModel;
import no.uib.inf101.sem2.spaceinvaders.model.aliens.Alien;
import no.uib.inf101.sem2.spaceinvaders.model.cannon.Cannon;
import no.uib.inf101.sem2.spaceinvaders.model.laser.Laser;
import no.uib.inf101.sem2.spaceinvaders.view.ViewableSpaceInvadersModel;





public class SpaceInvadersModel implements ViewableSpaceInvadersModel, ControllableSpaceInvadersModel{
    private GameState Gamestate;
    private Cannon player;
    private Alien alien;
    private Laser laser;
    private LaserState ls;
    private ArrayList<ArrayList<Boolean>> enemies;
    private int killcount; 
    

    /**
     * Konstruktør 
     */
    public SpaceInvadersModel(){
        this.Gamestate = GameState.START_SCREEN;
        this.player = new Cannon();
        this.killcount = 0;
        this.alien = new Alien();
        this.laser = new Laser(player.getCannonPos());
        this.ls = LaserState.NOT_ACTIVE_LASER;
        this.enemies = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true)), 
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true)),
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true))
            ));

    }
    @Override
    public int getPlayerCannonPos(){
        return player.getCannonPos();
    }

    @Override
    public GameState getGameState() {
        return Gamestate;
    }

    @Override
    public int moveCannon(int horisontalMove) {
        player.movedHorisontally(horisontalMove);
        return getPlayerCannonPos();
        
    }
    @Override
    public void moveAliens(){
        alien.moveAlien(killcount);
    }
    @Override
    public int getEnemyX() {
        return alien.getAlienX();
    }
    @Override
    public int getEnemyY() {
        return alien.getAlienY();
    }
   
    @Override
    public int timeBetweenEachAlienMove() {
        return 10;
    }
    @Override
    public void clockTick() {
    moveAliens();
    if(this.ls == LaserState.ACTIVE_LASER){
        shootLaser();
    }
   
    }
    @Override
    public int getProjectileX() {
        return laser.getLaserX();
    }
    @Override
    public int getProjectileY() {
        return laser.getLaserY();
    }
    @Override
    public void shootLaser() {
        laser.moveLaser();
    }
    @Override
    public void newLaser(int x) {
        laser.setY();
        laser.setX(x);
        this.ls = LaserState.ACTIVE_LASER;
        if(this.ls == LaserState.NOT_ACTIVE_LASER){
            this.laser = new Laser(x);
        }
        
    }
    @Override
    public void setLaserX() {
        laser.setX(player.getCannonPos());
    }
    @Override
    public LaserState getLaserState() {
        return ls;
    }
    @Override
    public void changeToNotAcitveLaserState() {
        this.ls = LaserState.NOT_ACTIVE_LASER;
        
    }
    @Override
    public void changeLaserToActive() {
        this.ls = LaserState.ACTIVE_LASER;
    }
    @Override
    public ArrayList<ArrayList<Boolean>> getEnemies() {
        return enemies;
    }
    @Override
    public void annihilateEnemy(int posRow, int posCol) {
        this.enemies.get(posRow).set(posCol, false);
        changeToNotAcitveLaserState();
        laser.setY();
        killcount ++;
        
    }

    @Override
    public void changeToNewGame() {
        this.Gamestate = GameState.START_SCREEN;
    }
    
    @Override
    public void changeGameStateToWin() {
        this.Gamestate = GameState.WIN_GAME;
    }
    @Override
    public void start() {
        this.Gamestate = GameState.ACTIVE_GAME;
        this.player = new Cannon();
        this.alien = new Alien();
        this.killcount = 0;
        this.laser = new Laser(player.getCannonPos());
        this.ls = LaserState.NOT_ACTIVE_LASER;
        this.enemies = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true)), 
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true)),
            new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true))
            ));
    }
    @Override
    public void changeGameStateToGameOver() {
        this.Gamestate = GameState.GAME_OVER;
    }
   
    
}


    


  
    

