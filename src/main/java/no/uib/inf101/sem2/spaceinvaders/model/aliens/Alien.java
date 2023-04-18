package no.uib.inf101.sem2.spaceinvaders.model.aliens;


public class Alien {
    private int xPos; 
    private int yPos; 
    private int alienDelay;

    /**
     * Konstruktør
     */
    public Alien(){
        this.yPos = 50;
        this.xPos = 20;
        this.alienDelay = 0;

    }
    /**
     * Funksjonen henter ut x-posisjonen til alienen.
     * @return xPos 
     */
    public int getAlienX(){
        return xPos;
    }
    /**
     * Funksjonen henter ut y-posisjonen til alienen.
     * @return yPos
     */
    public int getAlienY(){
        return yPos;
    }
    /**
     * Funksjonen flytter aliensa blant annet vha av en faktor "p" som blir lavere og lavere 
     * desto mer killcounten øker, slik at de beveger seg raskere når det er mindre igjen.
     * Siden alle aliensa blir tegnet ut i fra den i øvre venstre hjørne, så blir matten basert på
     * den posisjonen. 
     * @param killcount hvor mange aliens som er drept. 
     */
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
            if ((yPos / 10) % 2 != 0 && xPos < 120){
                xPos += 10;
            }
            else if ((yPos / 10) % 2 == 0 && xPos > 20){
                xPos -= 10;
            }
            else if(((yPos / 10) % 2 != 0 && xPos == 120) || ((yPos / 10) % 2 == 0 && xPos == 20)){
                yPos += 10;
            }
        }
        alienDelay++;
    }
    
}
