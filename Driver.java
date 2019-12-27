public class Driver extends Person
{
   protected String phoneNumber;
   protected Car car;
   protected Order curOrder;
   protected Location location;
   
   // Constructor /////////////////////////////////////////////
   public Driver (String phoneNumber, Car car, Location location)
   {
         this.phoneNumber = phoneNumber;
         this.car = car;
         this.location = location; //test
   }
}