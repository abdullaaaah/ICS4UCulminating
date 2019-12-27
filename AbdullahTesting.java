import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      cityDelivery.loadRestaurants();
    
      cityDelivery.loadDrivers();
      
      Map m = cityDelivery.getMap();
      
      Position[] p = m.getPositions();
      
      Restaurant[] r = cityDelivery.getRestaurants();
      
      
     m.printMap();
      
      
     // System.out.println(cityDelivery.getNumRestaurants());
     m.addAllPositions(cityDelivery.getRestaurants(), cityDelivery.getNumRestaurants(), cityDelivery.getDrivers(), cityDelivery.getNumDrivers());
      

      
      m.printMap();
   
   }

}