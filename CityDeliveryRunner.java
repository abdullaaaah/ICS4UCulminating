import java.io.File;
import java.io.IOException;

public class CityDeliveryRunner
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      cityDelivery.loadRestaurants();
            
      for(int i = 0; i<cityDelivery.getNumRestaurants(); i++)
      {
         System.out.println(cityDelivery.getRestaurants()[i].getName());
      }
   
   }

}