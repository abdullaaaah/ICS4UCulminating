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
      
      customer.getWallet().addCard(customer.getUsername(), "2312321321", "12","24","123", cityDelivery);

      for(int i = 0; i<cityDelivery.getNumCards(); i++)
      {
         System.out.println(cityDelivery.getCards()[i].getCardNumber());
      }          
 
      //cityDelivery.getRestaurants()[0].removeItem("Poutine");
            
     // Admin me = new Admin("Abdullah Shahid", "nx", "123456");
      //me.addRestaurant(cityDelivery, "chick fila", "junk food", 5, 1, 4,2);

     //cityDelivery.
     
     
      
   
   }

}
