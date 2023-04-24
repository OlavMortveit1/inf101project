package no.uib.inf101.sem2.spaceinvaders.model.cannon;


public class Cannon {
    private int xPos;

    /**
     * Konstruktør
     */
    public Cannon(){
        this.xPos = 300;

    }
    
    /**
     * Funksjonen oppdaterer x-posisjonen til kanonen, 
     * i tillegg til å stoppe den fra å bevege seg utenfor brettet.
     * @param deltaPos hvor mye den skal flyttes
     * @return den nye posisjonen
     */
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

    /**
     * Funksjonen returnerer x-posisjonen til kanonen.
     * 
     * @return x-posisjonen til kanonen.
     */
    public int getCannonPos(){
        return xPos;
    }
}
