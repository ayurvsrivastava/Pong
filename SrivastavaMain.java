import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SrivastavaMain{
   //THis method creates the actual game and runs it
    public static void main(String[] args) {

        // Creates the JFrame for the Game to occur in
        JFrame game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLayout(new BorderLayout());
        
        //Creates the actual object in which teh game will run in
        SrivastavaPong test = new SrivastavaPong();
        game.add(test, BorderLayout.CENTER);
        game.setSize(1200, 600);
        game.setVisible(true);

    }
}