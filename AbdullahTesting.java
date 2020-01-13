import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
   
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
      
      
      cityDelivery.login("nxabdullah", "123");
      
      Customer customer = ((Customer)cityDelivery.getUserLoggedIn());
      customer.addPosition(0,0);
      
      Restaurant chatime = cityDelivery.findRestaurantByName("chatime")[0];
      
<<<<<<< HEAD
      System.out.println(chatime.listMenu());
      
      cityDelivery.setCart( new Cart(chatime, customer) );
      cityDelivery.getCart().findDriver(cityDelivery.getMap());
=======
      //System.out.println(chatime.listMenu());
      
      //cityDelivery.setCart( new Cart(chatime, customer) );
      //cityDelivery.getCart().findDriver(cityDelivery.getMap());
>>>>>>> 161f8cc795636c0d94b9a4daf19fcd87c9a5259e
      
      
      //System.out.println(cityDelivery.getCart().getDriver());
      
      
      Map map = cityDelivery.getMap();
      
<<<<<<< HEAD
      
=======
      //System.out.println(map.getDistance(3,2, 5,0));
      System.out.println(map.findDriver(5,0));
      
      //we need to somehow direct the driver closer to the user .. because right now it just always goes down firest.
>>>>>>> 161f8cc795636c0d94b9a4daf19fcd87c9a5259e
      

      //System.out.println( ((Customer)cityDelivery.getUserLoggedIn()).getWallet().hasCard());
      //System.out.println("============"); 
      /*for(int i = 0; i<cityDelivery.getNumCards(); i++)
      {
         System.out.println("The card " + cityDelivery.getCards()[i]);
         
      }*/

     //Restaurant[] sorted = cityDelivery.sortRestaurantsByHighestRating();
     
     
      /*for(int i = 0; i<sorted.length; i++)
      {
         System.out.println(sorted[i].getName()+ " " + sorted[i].getAverageRating());
      }*/
   
   }

}
