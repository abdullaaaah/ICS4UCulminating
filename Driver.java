/*
   CLASS NAME: Driver
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores the information of the item sold by a restaurant
*/

public class Driver extends Person
{
   protected int id;
   protected String phoneNumber;
   protected String description;
   protected int positionX;
   protected int positionY;


   /////////////////////////////////   CONSTRUCTOR(s)   /////////////////////////////////

   /*
      PARAMETERS:    the id of the driver, name, description to identify him and his x'th and y'th position on the map
      PURPOSE:       Create a driver object
   */
   public Driver (int id, String name, String phoneNumber, String description, int positionX, int positionY)
   {
         super(name);
         this.id = id;
         this.phoneNumber = phoneNumber;
         this.description = description;
         this.positionX = positionX; 
         this.positionY = positionY;
   }
   
   /////////////////////////////////   ACESSORS   /////////////////////////////////

   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the driver's phone number
      PURPOSE:       Acessor of the phoneNumber field
   */
   public String getPhoneNumber()
   {
      return this.phoneNumber;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the driver's id
      PURPOSE:       Acessor of the id field
   */
   public int getId()
   {
      return this.id;
   }
    
    
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the driver's description
      PURPOSE:       Acessor of the description field
   */
   public String getDescription()
   {
      return this.description;
   }

   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the driver's x'th position
      PURPOSE:       Acessor of the positionX field
   */   
   public int getPositionX()
   {
      return this.positionX;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the driver's y'th position
      PURPOSE:       Acessor of the positionY field
   */
   public int getPositionY()
   {
      return this.positionY;
   }
   
   /////////////////////////////////   MUTATORS  /////////////////////////////////


   /*
      PARAMETERS:    The new x and y
      RETURN VALUE:  -
      PURPOSE:       Update's the driver's position on the map while verifying that the position exists.
   */
   public void updatePosition(Map map, int x, int y)
   {
      if(map.doesPositionExist(x,y))
      {
         this.positionX = x;
         this.positionY = y;
      }
      else
      {
         System.out.println("The given position does not exist");
      }
        
   }
   
   
   /*
      PARAMETERS:    The map, destinationX (Restaurant), destinationY (Restaurant)
      RETURN VALUE:  Distance to restaurant
      PURPOSE:       This method takes in the restaurant's position and calculates the distance needed for the driver to get there
   */
   public double getDistance(Map map, int destinationX, int destinationY)
   {
      return map.getDistance(this.positionX, this.positionY, destinationX, destinationY);
   }
   
   /////////////////////////////////   ADDITIONAL   /////////////////////////////////

   /*
      PARAMETERS:    The map, destinationX (Restaurant), destinationY (Restaurant)
      RETURN VALUE:  Distance to restaurant
      PURPOSE:       This method takes in the restaurant's position and calculates the distance needed for the driver to get there
   */   
   public String toString()
   {
      return super.getName() + " Contact Number: " + this.phoneNumber + " Description: " + this.description;
   }
   
   public void editDriver (String name, String phoneNumber, String description)
   {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.description = description;
   }
}