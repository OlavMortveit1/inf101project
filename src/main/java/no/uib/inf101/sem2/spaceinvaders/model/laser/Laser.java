package no.uib.inf101.sem2.spaceinvaders.model.laser;

public class Laser {
    private int xPos; 
    private int yPos;

    public Laser(int x){
        this.xPos = x; 
        this.yPos = 730;
    }

    public int getLaserX(){
        return xPos;
    }

    public int getLaserY(){
        return yPos; 
    }

    public void moveLaser(){
        yPos -= 20;
        
    }
    public void setX(int newX){
        xPos = newX;
    }
    public void setY(){
        yPos = 730;
    }
}
