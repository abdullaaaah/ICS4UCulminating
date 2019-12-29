import java.io.File;
import java.io.IOException;

public class AbdullahTesting
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cityDelivery = new CityDeliveryDatabase();
          
 
      //cityDelivery.getRestaurants()[0].removeItem("Poutine");
      
      
      Admin me = new Admin("Abdullah Shahid", "nx", "123456");
      
      // test adding and removing for driver
      
      me.addDriver(cityDelivery, 100, "dio", "(647) 764 1231", "Black SUV", 3,3);
      me.removeDriver(cityDelivery, 100);
      
      //me.addRestaurant(cityDelivery, "Wendys", "Fast-Food", 50, 10, 2,0);
      
      //me.removeRestaurant(cityDelivery, "Wendys");
      
      //cityDelivery.addUser("jojojo", "jojo2", "123123");
      
      //cityDelivery.login("jojo2", "123123");
      
      //System.out.println(User.encypt("123123"));
      
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
