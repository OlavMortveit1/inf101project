package no.uib.inf101.sem2.spaceinvaders.model.laser;

public class Laser {
    private int xPos; 
    private int yPos;

    /**
     * Konstruktør
     * @param xPos til laseren
     */
    public Laser(int xPos){
        this.xPos = xPos; 
        this.yPos = 730;
    }

    /**
     * Funksjonen henter ut x-posisjonen til laseren.
     * 
     * @return x-posisjonen til laseren.
     */
    public int getLaserX(){
        return xPos;
    }

    /**
     * Funksjonen henter ut y-posisjonen til laseren.
     * 
     * @return y-posisjonen til laseren.
     */
    public int getLaserY(){
        return yPos; 
    }
    /**
     * Funksjonen setter hvor mye laseren skal beveges med 
     * hver gang "klokken tikker".
     */
    public void moveLaser(){
        yPos -= 20;
        
    }
    /**
     * Funksjonen setter x-posisjonen til en ny verdi.
     * @param newX den nye verdien
     */
    public void setX(int newX){
        xPos = newX;
    }
    /**
     * Funksjonen setter y-posisjonen til en verdi.
     */
    public void setY(){
        yPos = 730;
    }
}
