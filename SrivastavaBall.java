import java.awt.Color;
import java.awt.Graphics;

public class SrivastavaBall extends SrivastavaBlock
{

    private int xSpeed = 60;
    private int ySpeed = 60;
     //Constructor for a Ball that has no given parametes
    public SrivastavaBall()
    {
        super(200,200,50,50);
        xSpeed = 60;
        ySpeed = 10;
    }
   //Constructor for ball whose only parameters where the x and y location in the object
    public SrivastavaBall(int x, int y)
    {
        super(x,y,50,50);
        xSpeed = 60;
        ySpeed = 10;
    }
   //Constructor for a ball whose x, y, width, and height were all defined in the object
    public SrivastavaBall(int x, int y, int width, int height)
    {
        super(x,y,width,height);
        xSpeed = 60;
        ySpeed = 10;
    }
   //constructor for a ball whose x, y, width, and height and color were all defined in the object
    public SrivastavaBall(int x, int y, int width, int height, Color color)
    {
        super(x,y,width,height,color);
        xSpeed = 60;
        ySpeed = 10;
    }
    //This constructor is for a ball whose paramaters inclue an x, y, width, height, color, and a speed for both directions
    public SrivastavaBall(int x, int y, int width, int height, Color color, int xSpd, int ySpd)
    {
        super(x,y,width,height,color);
        xSpeed = xSpd;
        ySpeed = ySpd;
    }
   
   //THis void sets the xSpeed equal to the value of int x
    public void setXSpeed(int x)
    {
        xSpeed = x;
    }
   //This sets the xSpeed equal to the value of int y
    public void setYSpeed(int y)
    {
        ySpeed = y;
    }
     //this sets the xSpeed AND the ySpeed to their respective value of int x and int y
    public void setSpeed(int x, int y)
    {
        xSpeed = x;
        ySpeed = y;
    }


   //this void both moves the ball and then redraws a white "window" back on top of the previous ball in rapid succession
    public void moveAndDraw(Graphics window)
    {

        draw(window, Color.WHITE);

        //move the position of the ball
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);

        draw(window);
        //draw the ball at its new location
    }



   //This calls the xSpeed and returns it
    public int getXSpeed()
    {
        return xSpeed;
    }
   // THis calls the ySpeed and returns it
    public int getYSpeed()
    {
        return ySpeed;
    }


    //toString() method
    public String toString()
    {
        return ""+super.getWidth()+"x"+super.getHeight()+" "+super.getColor()+" ball @ ("+super.getX()+","+super.getY()+") moving at speed <"+xSpeed+","+ySpeed+">";
    }
}