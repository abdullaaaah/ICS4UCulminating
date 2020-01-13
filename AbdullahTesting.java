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
      
      //System.out.println(chatime.listMenu());
      
      //cityDelivery.setCart( new Cart(chatime, customer) );
      //cityDelivery.getCart().findDriver(cityDelivery.getMap());
      
      
      //System.out.println(cityDelivery.getCart().getDriver());
      
      
      Map map = cityDelivery.getMap();
      
      customer.addPosition(0,0);
      Cart cart = new Cart(chatime, customer);
      System.out.println(chatime.listMenu());
      cart.addItem(chatime.getMenu()[0], 2);
      System.out.println(cart.findDriver(map));
      System.out.println(cart.getTotalPrice(map));
      
      
      //Restaurant[] s = cityDelivery.sortRestaurantByDistance(0,1);
      
      //System.out.println(cityDelivery.listRestaurant(s, s.length));
            
      //System.out.println(map.getDistance(3,2, 5,0));
      //System.out.println(map.findDriver(5,0));
      
      //we need to somehow direct the driver closer to the user .. because right now it just always goes down firest.
      

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
