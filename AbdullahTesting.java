import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      System.out.println('A'-64);
   
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      
      cityDelivery.login("nxabdullah", "123");

      System.out.println( ((Customer)cityDelivery.getUserLoggedIn()).getWallet().hasCard());
      System.out.println("============"); 
      /*for(int i = 0; i<cityDelivery.getNumCards(); i++)
      {
         System.out.println("The card " + cityDelivery.getCards()[i]);
         
      }*/

     Restaurant[] sorted = cityDelivery.sortRestaurantsByHighestRating();
     
     
      /*for(int i = 0; i<sorted.length; i++)
      {
         System.out.println(sorted[i].getName()+ " " + sorted[i].getAverageRating());
      }*/
   
   }

}
