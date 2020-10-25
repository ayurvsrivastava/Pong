import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;


public class SrivastavaPong extends JPanel implements ActionListener, KeyListener
{
    private boolean finish = false;
    private boolean home = false;
    double t = 0;
    private boolean gaming = false;
    private int xChangeBall = -1;
    private int yChangeBall = 3;
    private int ballX = 250;
    private int ballY = 250;
    private int diameter = 20;
    int random;
    private boolean wPressed = false;
    private boolean sPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    // Here we place the dimensions of player one
    private int paddleOneX = 75;
    private int paddleOneY = 250;
    private int playerOneWidth = 10;
    private int playerOneHeight = 100;
    // Here we place the dimensions of player two
    private int paddleTwoX = 1100;
    private int paddleTwoY = 250;
    private int playerTwoWidth = 10;
    private int playerTwoHeight = 100;
    // default paddle speed
    private int paddleSpeed = 15;
    // these will be used to keep score later
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private int easy = 3;
    private int hard = 3;
    // This will display our mode on top of the game.
    String pongMode = "Play";
    int i = 0;


    public SrivastavaPong()
    {

        setBackground(Color.lightGray);

        //Checks for any key presses to determine what it was
        setFocusable(true);
        addKeyListener(this);
        //allows the program to start.
        go();
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }




    public void actionPerformed(ActionEvent e)
    {
        go();
    }

    public void go()
    {
        // Define a random to utilize later.
        Random rand = new Random();
        random = rand.nextInt(250) + 1;


        if(gaming)
        {
            //This will check to see if the key is pressed for player 1
            if (wPressed)
            {
                //checks to see if the paddle is already moving to see if it needs to be flipped
                if (paddleSpeed > 0)
                {
                    paddleOneY -= paddleSpeed; 
                }
            }
            //THis will check to see if the key is pressed for player 1
            if (sPressed)
            {
                //This just makes suer the paddle does not leabe the screen
                if (paddleOneY + paddleSpeed + playerOneHeight < getHeight())
                {
                  //THis shifts the speed of the paddle to go down
                    paddleOneY += paddleSpeed;
                }
            }

            //Does the exact same thing as teh player 1 key presses except for player 2 req
            if (upPressed)
            {
                if (paddleTwoY-paddleSpeed > 0)
                {
                    paddleTwoY -= paddleSpeed;
                }
            }
            if (downPressed)
            {
                if (paddleTwoY + paddleSpeed + playerTwoHeight < getHeight())
                {
                    paddleTwoY += paddleSpeed;
                }
            }


            //This portion changes the location of the ball relative to the JFrame Thingy
            //This determines the ball location relative to the left wall.
            int nextBallLeft = ballX + xChangeBall;
            //same thing for the right side
            int nextBallRight = ballX + diameter + xChangeBall; 
           //same thing thing for the top side.
            int nextBallTop = ballY + yChangeBall;
           //same thing for the bottom wall.
            int nextBallBottom = ballY + diameter + yChangeBall;
            //figures out the raltive position of the ball to the closes walls
            int playerOneRight = paddleOneX + playerOneWidth;
            int playerOneTop = paddleOneY;
            int playerOneBottom = paddleOneY + playerOneHeight;
            //figures out the relative position of the ball to the closest right part of the wall
            double playerTwoLeft = paddleTwoX;
            double playerTwoTop = paddleTwoY;
            double playerTwoBottom = paddleTwoY + playerTwoHeight;
            double ballY2 = ballY;
            double paddleTwoY2 = paddleTwoY;
           
            if (paddleTwoY < ballY && easy == 1)
            {
                paddleTwoY++;
                paddleTwoY++;
            }
            if (paddleTwoY > ballY && easy == 1)
            {
                paddleTwoY--;
                paddleTwoY--;
            }
            if (paddleTwoY > ballY && hard == 2)
            {

                paddleTwoY--;
                paddleTwoY--;
                paddleTwoY--;

            }
            if (paddleTwoY < ballY && hard == 2)
            {
                paddleTwoY++;
                paddleTwoY++;
                paddleTwoY++;
            }

            //The paddle is forced in the JFrame
            if (paddleOneY < 0 || paddleOneY > getHeight())
            {
                paddleOneY = 0;
            }
            //the ball inverses speed when it hits the wall
            if (nextBallTop < 0 || nextBallBottom > getHeight())
            {
                yChangeBall *= -1;
            }




            //Just checks the relative to the position of the bal; to the left wall
            if (nextBallLeft < playerOneRight)
            {
                //this determines how close the paddle is to the ball as long as it is going left
                if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop)
                {
                    playerTwoScore++;
                    xChangeBall = -1;

                    if (playerTwoScore == 3)
                    {
                        gaming = false;
                        finish = true;

                    }
                    // This will reset the ball back to its starting position
                    ballX = 250;
                    ballY = random;
                }
                else {
                    // Increases the speed of the ball exponential.
                    xChangeBall *= -1;
                    xChangeBall++;
                    xChangeBall++;
                }
            }
            // same thing for player 2
            if (nextBallRight > playerTwoLeft)
            {
                // determines where the ball is to the relative right paddle.
                if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop)
                {
                    playerOneScore++;
                    xChangeBall = -1;

                    if (playerOneScore == 3)
                    {
                        gaming = false;
                        finish = true;

                    }
                    // This will reset the ball back to its starting position
                    ballX = 250;
                    ballY = random;
                }
                else {
                    // starts the ball backup again after the increasing speeed
                    xChangeBall++;
                    xChangeBall++;
                    xChangeBall *= -1;
                }
                // this will start the ball moving again
                ballX += xChangeBall;
                ballY += yChangeBall;
            }
            // creates a new paint
            repaint();
        }
    }

    //redraws everything
    public void paintComponent(Graphics game)
    {


        super.paintComponent(game);
        game.setColor(Color.RED);

        gaming = true;

        if (gaming)
        {
            // starts ball and allows for two more variables for comparision
            ballX += xChangeBall;
            ballY += yChangeBall;
            int playerTwoLeft = paddleTwoX;
            int playerOneRight = paddleOneX + playerOneWidth;

            // now we need to draw the scores of each player
            game.drawString(String.valueOf(playerOneScore), 375, 100);
            game.setColor(Color.GREEN);
            game.drawString(String.valueOf(playerTwoScore), 800, 100);
            game.setColor(Color.WHITE);
            // here is where we draw the mode we are in
            game.drawString(pongMode,600,100);

            game.setColor(Color.WHITE);

            // draw the ball
            game.fillOval(ballX, ballY, diameter, diameter);

            // draw the paddles
            game.setColor(Color.RED);
            game.fillRect(paddleOneX, paddleOneY, playerOneWidth, playerOneHeight);
            game.setColor(Color.GREEN);
            game.fillRect(paddleTwoX, paddleTwoY, playerTwoWidth, playerTwoHeight);

        }
        // this is what happens if the game is over
        else if (finish == true)
        {

            game.drawString(String.valueOf(playerOneScore), 375, 100);
            game.drawString(String.valueOf(playerTwoScore), 800, 100);
            game.setColor(Color.lightGray);

        /*    if (playerOneScore > playerTwoScore)
            {
                // displays if player one wins or not

                game.drawString("Player One Wins", 600, 200);
            }
            if (playerTwoScore > playerOneScore)
            {
                // displays if player two wins or not
                game.drawString("Player Two Wins", 600, 200);
            }
            // displays if you want to restart the game to hit space
            game.drawString("Press space to restart", 580, 300);

*/
//^^ Still questionably testing
        }
    }
    public void keyTyped (KeyEvent f)
    {


    }

    // here we will figure out what keys are pressed and what happens when they are pressed
    public void keyPressed(KeyEvent f)
    {
        if (home)
        {
            // when e is pressed in the title screen it sets the game mode to easy
            if (f.getKeyCode() == KeyEvent.VK_E)
            {
                gaming = true;
                home = false;
                playerOneScore = 0;
                easy = 1;
                pongMode = "Easy";

            }
            // when h is pressed in the title screen it sets the game mode to hard
            if (f.getKeyCode() == KeyEvent.VK_H)
            {
                gaming = true;
                home = false;
                playerOneScore = 0;
                hard = 2;
                pongMode = "Hard";

            }
            // when x is pressed it starts the game as well as gets rid of the title screen
            if (f.getKeyCode() == KeyEvent.VK_X)
            {


                gaming = true;
                home = false;
                playerOneScore = 0;
                pongMode = "1 v 1";



            }
        }

        // heres what happens when we press keys and we are gaming
        else if (gaming)
        {

            // if we press up then it will make the paddle go up
            if (f.getKeyCode() == KeyEvent.VK_UP)
            {
                upPressed = true;
            }
            // if we press down then it will make the paddle go down
            if (f.getKeyCode() == KeyEvent.VK_DOWN)
            {
                downPressed = true;
            }
            // if we press w then it will make the paddle go up
            if (f.getKeyCode() == KeyEvent.VK_W)
            {
                wPressed = true;
            }
            // if we press s then it will make the paddle go down.
            if (f.getKeyCode() == KeyEvent.VK_S)
            {
                sPressed = true;
            }
            // if we press space then the game will restart
            if (f.getKeyCode() == KeyEvent.VK_SPACE)
            {
                paddleOneY = 250;
                paddleTwoY = 250;
                ballX = 250;
                ballY = 250;
                go();
                playerOneScore = 0;
                playerTwoScore = 0;
            }


        }
        // if the playerscore is 3 then the game will end and start the title screen again when space is pressed
        else if (playerOneScore == 3 || playerTwoScore == 3)
        {
            if (f.getKeyCode() == KeyEvent.VK_SPACE)
            {
                repaint();
                go();
                home = true;
                playerOneScore = 0;
                playerTwoScore = 0;



            }
        }
    }
    // this is actually the same thing except jsut when the key is released they stop moving.
    public void keyReleased (KeyEvent f)
    {
        if (gaming)
        {
            if (f.getKeyCode() == KeyEvent.VK_UP)
            {
                upPressed = false;
            }
            if (f.getKeyCode() == KeyEvent.VK_DOWN)
            {
                downPressed = false;
            }
            if (f.getKeyCode() == KeyEvent.VK_W)
            {
                wPressed = false;
            }
            if (f.getKeyCode() == KeyEvent.VK_S)
            {
                sPressed = false;
            }
        }
    }
}