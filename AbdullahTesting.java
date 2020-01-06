import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      cityDelivery.login("kori","kosh");
      Customer customer = (Customer)cityDelivery.getUserLoggedIn();
      
      System.out.println(customer);
      
      System.out.println(customer.getWallet().hasCard());
          
 
      //cityDelivery.getRestaurants()[0].removeItem("Poutine");
            
     // Admin me = new Admin("Abdullah Shahid", "nx", "123456");
      //me.addRestaurant(cityDelivery, "chick fila", "junk food", 5, 1, 4,2);

     //cityDelivery.
     
     
      
   
   }

}
