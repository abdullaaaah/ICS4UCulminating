import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      System.out.println('A'-64);
   
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      
     /* cityDelivery.login("nxabdullah", "123");

      System.out.println( ((Customer)cityDelivery.getUserLoggedIn()).getWallet().hasCard());
      System.out.println("============"); 
    */
    
    
    cityDelivery.login("admin","admin");
    Admin me = ((Admin)cityDelivery.getUserLoggedIn());
    
    System.out.println( cityDelivery.getRestaurantNames() );
      
      /*for(int i = 0; i<cityDelivery.getNumCards(); i++)
      {
         System.out.println("The card " + cityDelivery.getCards()[i]);
         
      }*/

     Restaurant[] sorted = cityDelivery.sortRestaurantsByHighestRating();
     sorted = cityDelivery.sortRestaurantsByPrice();
     
     System.out.println( cityDelivery.listRestaurant(sorted, sorted.length));
      /*for(int i = 0; i<sorted.length; i++)
      {
         System.out.println(sorted[i].getName()+ " " + sorted[i].getAverageRating());
      }*/
   
   }

}
