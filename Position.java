/*
   CLASS NAME: Position
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    This class stores information about the position of any object on the map
*/

public class Position
{
   private int x; //the x or row cordinate of the position
   private int y; //the y or column cordinate of the position
   
   /*
      PARAMETERS: Takes two integer values x and y referring to the x and y cordinates of the position
      PURPOSE:    This method constructs a new Position object
   */
   public Position(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the value of x field in the class
      PURPOSE:       Accessor of the x field
   */
   public int getX()
   {
      return this.x;
   }

   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the value of y field in the class
      PURPOSE:       Acessor of the y field
   */
   public int getY()
   {
      return this.y
   }

}