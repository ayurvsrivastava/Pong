import java.awt.Color;
import java.awt.Graphics;

public class SrivastavaPaddle extends SrivastavaBlock 
{
    //This creates a variable called speed to define the YSpeed of the block
    private int speed;

    //This constructor creates a paddle with no defined parametes
    public SrivastavaPaddle() 
    {
        super(10,10,50,200);
        speed =1;
    }

   //Cretaes a constructor with the x and y position defined
    public SrivastavaPaddle(int x, int y)
    {
        super(x,y,50,200);
        speed =1;
    }

   //Creates a constructor that defines the paddle with the x and y position as well as teh height.
    public SrivastavaPaddle(int y, int wid, int hei)
    {
        super(10,y,wid,hei);
        speed =1;
    }

   //Creates a constructor that defines the paddle with x and y, position, as well as the height and width.
    public SrivastavaPaddle(int x, int y, int wid, int hei)
    {
        super(x,y,wid,hei);
        speed =1;
    }

   //Creates a constructor that defines the position of the block, the size of it, and what the color of the block is
    public SrivastavaPaddle(int x, int y, int wid, int hei, Color color)
    {
        super(x,y,wid,hei,color);
        speed =1;
    }



    //This has a draw method because the paddles will move indepnedntly relative to the ball, by drawing a white space over the paddle
    //then it draws a paddle above the location of the paddle.
    public void moveUpAndDraw(Graphics window)
    {
        draw(window, Color.WHITE);

        setY(getY()-speed);

        draw(window);

    }

   //This has a draw method because the paddles will move indepnedntly relative to the ball, by drawing a white space over the paddle
   //then it draws a paddle beneath the location of the other paddle
    public void moveDownAndDraw(Graphics window)
    {
        draw(window, Color.WHITE);

        setY(getY()+speed);

        draw(window);

    }

    //THis method returns the speed of the paddle
    public int getSpeed()
    {
        return speed;
    }


    //toString() method
    public String toString()
    {
        return ""+super.getWidth()+"x"+super.getHeight()+" "+super.getColor()+" paddle @ ("+super.getX()+","+super.getY()+") moving at speed "+getSpeed();//returnss the balls postition, size and color
    }
}
