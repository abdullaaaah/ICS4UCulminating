import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      cityDelivery.loadRestaurants();
    
      cityDelivery.loadDrivers();
 
      cityDelivery.getRestaurants()[0].addItem("Poutinez",2.99);
      cityDelivery.getRestaurants()[0].saveMenu();
      
      /*Map m = cityDelivery.getMap();
      
      Position[] p = m.getPositions();
      
      Restaurant[] r = cityDelivery.getRestaurants();
           
     m.addAllPositions(cityDelivery.getRestaurants(), cityDelivery.getNumRestaurants(), cityDelivery.getDrivers(), cityDelivery.getNumDrivers());
     
     System.out.println(m.getDistance(0,0, 0,4));
     
     char[][] m2 = m.getMap();
     
     System.out.println("---");
      
      for(int i = 0; i<m2.length; i++)
      {
         for(int x = 0; x<m2[i].length; x++)
         {
            System.out.print(m2[i][x]);
         }
         System.out.println();
      }*/
      
   
   }

}
