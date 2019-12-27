import java.io.File;
import java.io.IOException;

public class CityDeliveryRunner
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      cityDelivery.loadRestaurants();
            
      Restaurant r = cityDelivery.getRestaurants()[0];
      
      r.addItem("Fries", 5.99);
      r.addItem("Iced coffee", 1.99);
      r.addItem("Mcdouble", 3.99);
      
      
      for(int i = 0; i<2; i++)
      {
         System.out.println(r.getMenu()[i].getName());
      }
      
      r.saveMenu();
      
   
   }

}