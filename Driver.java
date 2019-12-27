public class Driver extends Person
{
   protected String phoneNumber;
   protected String description;
   protected int positionX;
   protected int positionY;

   
   public Driver (String name, String phoneNumber, String description, int positionX, int positionY)
   {
         super(name);
         this.phoneNumber = phoneNumber;
         this.description = description;
         this.positionX = positionX; 
         this.positionY = positionY;
   }
   
   public String getPhoneNumber()
   {
      return this.phoneNumber;
   }
   
   public String getDescription()
   {
      return this.description;
   }
   
   public int getPositionX()
   {
      return this.positionX;
   }
   
   public int getPositionY()
   {
      return this.positionY;
   }
   
   public void updatePosition(int x, int y)
   {
      this.positionX = x;
      this.positionY = y;
   }
   
   public double getDistance(Map map, int x, int y)
   {
      return 0;
   }
   
   public String toString()
   {
      return super.getName() + " Contact Number: " + this.phoneNumber + " Description: " + this.description;
   }
}