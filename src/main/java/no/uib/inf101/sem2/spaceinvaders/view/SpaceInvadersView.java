package no.uib.inf101.sem2.spaceinvaders.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import no.uib.inf101.sem2.spaceinvaders.model.GameState;
import no.uib.inf101.sem2.spaceinvaders.model.LaserState;

public class SpaceInvadersView extends JPanel {
    private final ViewableSpaceInvadersModel model;

public SpaceInvadersView(ViewableSpaceInvadersModel model) {
    this.model = model;
    this.setFocusable(true);
    this.setPreferredSize(new Dimension(600, 800));
    this.setBackground(Color.BLACK);
    
    
    }
    
    @Override 
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      if (model.getGameState() == GameState.START_SCREEN){
        drawWelcomeScreen(g2);
      }
      if (model.getGameState() == GameState.ACTIVE_GAME){
      drawCanon(g2);
      drawAlien(g2);
      drawLaser(g2);
      drawLine(g2);
      }
      if (model.getGameState() == GameState.WIN_GAME){
        drawWinScreen(g2);
      }
      if (model.getGameState() == GameState.GAME_OVER){
        drawGameOverScreen(g2);
      }
    }
  
 

    public void drawLine(Graphics2D g){
        Line2D line = new Line2D.Double(0, 730, 600, 730);
        g.setColor(Color.WHITE);
        g.draw(line);
    }



    public void drawCanon(Graphics2D g){
        BufferedImage cannon = Inf101Graphics.loadImageFromResources("/player.png");
        double scale = 0.1;
        Inf101Graphics.drawImage(g, cannon, model.getPlayerCannonPos(), 750, scale);

    }

    public void drawAlien(Graphics2D g){
        BufferedImage alien = Inf101Graphics.loadImageFromResources("/alien.png");
        double scale = 0.03;
        int yPos = model.getEnemyY();
        int xPos = model.getEnemyX();
        if(!model.getEnemies().get(0).contains(true) && !model.getEnemies().get(1).contains(true)
         && !model.getEnemies().get(2).contains(true)){
            model.changeGameStateToWin();
        }
        if (model.getEnemies().get(0).contains(true) && yPos > 695){
            model.changeGameStateToGameOver();
        }
        else if (model.getEnemies().get(1).contains(true) && yPos > 625){
            model.changeGameStateToGameOver();;
        }
        else if (model.getEnemies().get(2).contains(true) && yPos > 555){
            model.changeGameStateToGameOver();
        }
        for(int i = 0; i < model.getEnemies().size(); i++){
            int y = yPos + i*70;
            for(int u = 0; u < model.getEnemies().get(i).size(); u++){
                int x = xPos + u*70;
                if(model.getEnemies().get(i).get(u) == true){
                    Inf101Graphics.drawImage(g, alien, x, y, scale);
                    if(model.getProjectileX()>=x && model.getProjectileX()<=x+40 && model.getProjectileY()<=y && model.getProjectileY()>=y-30){
                        model.annihilateEnemy(i, u);
                    }
                }
                
            }
        }
         
    }

    

    public void drawLaser(Graphics2D g){
        if(model.getLaserState() == LaserState.ACTIVE_LASER){
            if(model.getProjectileY() <= 20){
                model.changeToNotAcitveLaserState();
            }
            RoundRectangle2D laserFill = new RoundRectangle2D.Double(model.getProjectileX(), model.getProjectileY(), 4, 20, 30, 20);
            g.setColor(Color.MAGENTA);
            g.fill(laserFill);
            RoundRectangle2D laser = new RoundRectangle2D.Double(model.getProjectileX(), model.getProjectileY(), 4, 20, 30, 20);
            g.setColor(Color.BLACK);
            g.draw(laser); 
        }

        
    }

    public void drawWelcomeScreen(Graphics2D g){
        g.setColor(Color.GREEN);
        g.setFont(new Font("Helvetica", Font.BOLD, 48));
        g.drawString("Space Invaders", 130, 340);
        g.setFont(new Font("Helvetica", Font.PLAIN, 30));
        g.drawString("Use the arrowkeys to move", 125, 370);
        g.drawString("Press space to shoot and kill the aliens", 40, 400);
        g.drawString("ENTER to start", 195, 430);
        
    }

    public void drawWinScreen(Graphics2D g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 50));
        g.drawString("You win!", 195, 350);
        g.setFont(new Font("Helvetica", Font.PLAIN, 25));
        g.drawString("Press ENTER to return to startscreen", 100, 380);

    }

   public void drawGameOverScreen(Graphics2D g){
        g.setColor(Color.RED);
        g.setFont(new Font("Helvetica", Font.BOLD, 50));
        g.drawString("GAME OVER", 155, 300);
        g.setFont(new Font("Helvetica", Font.PLAIN, 25));
        g.drawString("Press ENTER to return to startscreen", 100, 330);

   }
    
}
