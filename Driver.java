public class Driver extends Person
{
   protected int id;
   protected String phoneNumber;
   protected String description;
   protected int positionX;
   protected int positionY;

   
   public Driver (int id, String name, String phoneNumber, String description, int positionX, int positionY)
   {
         super(name);
         this.id = id;
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
   
   public double getDistance(Map map, int destinationX, int destinationY)
   {
      return map.getDistance(this.positionX, this.positionY, destinationX, destinationY);
   }
   
   public String toString()
   {
      return super.getName() + " Contact Number: " + this.phoneNumber + " Description: " + this.description;
   }
}