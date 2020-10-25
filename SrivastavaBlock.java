import java.awt.Color;
import java.awt.Graphics;

public class SrivastavaBlock
{
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;
   //This creates a base constructor block with no set parameters
    public SrivastavaBlock()
    {
        xPos = 100;
        yPos = 150;
        width = 10;
        height =10;
        color = Color.BLUE;

    }

    //add other Block constructors - x , y , width, height, color
   
   //This constructor creates a block with the defined paramteres of location, width, and height
    public SrivastavaBlock(int x, int y, int width, int height)
    {
        xPos = x;
        yPos = y;
        width = 10;
        height =10;
        color = Color.BLUE;
    }
   //This constructor creates a block with the defined parameters of location, width, height, and Color.
    public SrivastavaBlock(int x, int y, int wid, int ht, Color c )
    {
        xPos = x;
        yPos = y;
        width = wid;
        height =ht;
        color = Color.red;
    }

   //This method sets xPos to the value of x
    public void setX( int x){
        xPos = x;
    }
   //This method sets yPos to the value of Y
    public void setY(int y){
        yPos = y;
    }
   //THis method sets xPos and yPos to the Value of X and Y
    public void setPos(int x, int y){
        xPos = x;
        yPos = y;
    }
   //This method returns the xPosition of the block
    public int getX(){
        return xPos;
    }
   //This method return the yPosition of the block
    public int getY(){
        return yPos;
    }
   //THis method defines the color of the block to the color of Col
    public void setColor(Color col)
    {
        color = col;
    }
   //This method returns the Color of the block
    public Color getColor(){
        return color;
    }
   //THis method returns teh width of the block
    public int getWidth(){
        return width;
    }
   //This method sets the Width of the rectangle to the value of wid
    public void setWidth(int wid){
        width = wid;
    }
   //THis method returns the height of the rectangle
    public int  getHeight(){
        return height;
    }
   //This method sets the height of the recantgle to ht
    public void setHeight(int ht){
        height = ht ;
    }


   //This method creates the blocks and actually draws it with just the graphics window
    public void draw(Graphics window)
    {
        //uncomment after you write the set and get methods
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
   //This method creates the blocks and draws them with the grpahics window and their color.
    public void draw(Graphics window, Color col)
    {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

    }
   //This method checks to see if the blocks correlate to an object created in order to determine collisions.
    public boolean equals(Object obj)
    {
        SrivastavaBlock other= (SrivastavaBlock)obj;
        if(getX() == other.getX() && getY() == other.getY()
                && getWidth() == other.getWidth()
                && getHeight() == other.getHeight()
                && getColor().equals( other.getColor())){
            return true;
        }
        return false;
    }

    //add the other get methods


    //add a toString() method  - x , y , width, height, color

    public String toString(){
        return xPos + " " + yPos + " " + width + " " + height + " " + color;
    }
}
