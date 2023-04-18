package no.uib.inf101.sem2.spaceinvaders.model.aliens;


public class Alien {
    private int xPos; 
    private int yPos; 
    private int alienDelay;

    public Alien(){
        this.yPos = 50;
        this.xPos = 20;
        this.alienDelay = 0;

    }

    public int getAlienX(){
        return xPos;
    }
    public int getAlienY(){
        return yPos;
    }

    public void moveAlien(int killcount){
        int p = 10;
        if (killcount >= 18){
            p = 1;
        }
        else if (killcount >= 10){
            p = 2;
        }
        else if (killcount >= 5){
            p = 5;
        }
        if(alienDelay % p == 0){ 
            if(((yPos / 10) % 2 != 0 && xPos == 120) || ((yPos / 10) % 2 == 0 && xPos == 20)){
                yPos += 10;
            }
            else if ((yPos / 10) % 2 != 0 && xPos < 120){
                xPos += 10;
            }
            else if ((yPos / 10) % 2 == 0 && xPos > 20){
                xPos -= 10;
            }
        }
        alienDelay++;
    }
    
}
