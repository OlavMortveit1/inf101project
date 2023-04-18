package no.uib.inf101.sem2.spaceinvaders;


import javax.swing.JFrame;
import no.uib.inf101.sem2.spaceinvaders.controller.CannonController;
import no.uib.inf101.sem2.spaceinvaders.model.SpaceInvadersModel;
import no.uib.inf101.sem2.spaceinvaders.view.SpaceInvadersView;

public class SpaceInvadersMain{
  


  public static void main(String[] args) {
    
    
    
    SpaceInvadersModel model = new SpaceInvadersModel();
    SpaceInvadersView view = new SpaceInvadersView(model);
    CannonController controller = new CannonController(model, view);
    
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("SpaceInvaders");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}
