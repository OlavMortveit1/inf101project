package no.uib.inf101.sem2.spaceinvaders.model.cannon;


public class Cannon {
    private int xPos;

    public Cannon(){
        this.xPos = 300;

    }
    
    public int movedHorisontally(int deltaPos){
        int newPos = deltaPos + xPos; 
        if (newPos < 0){
            xPos = 0;
        }
        else if (newPos > 558){
            xPos = 558;
        }
        else {
            xPos = newPos;
        } 
        return newPos;
    }


    public int getCannonPos(){
        return xPos;
    }
}
