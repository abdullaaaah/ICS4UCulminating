import java.io.*;

public class CityDeliveryDatabase
{
   private User userLoggedIn;
   private Restaurant[] restaurants;
   private User[] users;
   private Coupon[] coupons;
   private Order[] orders;
   private Driver[] drivers; 
   private Map map;
   private final double DELIVERY_FEE = 1;
   private final double TAX_RATE = 0.13;
   private final String USERS_FILE = "users.txt";
   private final String RESTAURANTS_FILE = "restaurants.txt";
   private final String COUPONS_FILE = "coupons.txt";
   private final String WALLETS_FILE = "wallets.txt";
   private final String CARDS_FILE = "cards.txt";
   private final String DRIVERS_FILE = "drivers.txt";
   private final int MAX_RESTAURANTS = 6;
   private int numRestaurants;
   private final int MAX_DRIVERS = 5;
   private int numDrivers;
   
   
   public CityDeliveryDatabase()
   {
      /* Map */
      
      map = new Map(5,5);
      
      /* End Map */
   
      this.restaurants = new Restaurant[MAX_RESTAURANTS];
      this.numRestaurants = 0;
      this.drivers = new Driver[MAX_DRIVERS];
      this.numDrivers = 0;
      
   }
   
   public Map getMap()
   {
      return map;
   }
   
   public int getNumRestaurants()
   {
      return this.numRestaurants;
   }
   
   public Restaurant[] getRestaurants()
   {
      return this.restaurants;
   }
   
   public void loadRestaurants()
   {
      int id, numRatings, x, y;
      String name, category;
      double rating;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(RESTAURANTS_FILE));
         String input;
         
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
            id = Integer.parseInt(in.readLine());
            name = in.readLine();
            category = in.readLine();
            rating = Double.parseDouble(in.readLine());
            numRatings = Integer.parseInt(in.readLine());
            x = Integer.parseInt(in.readLine());
            y = Integer.parseInt(in.readLine());
            
            //System.out.println(x+".."+y);
            
            restaurants[this.numRestaurants] = new Restaurant(id, name, x, y, category, rating, numRatings);   
            this.numRestaurants++;
         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading restaurants");
      }
   }
   
   public int getNumDrivers()
   {
      return this.numDrivers;
   }
   
   public Driver[] getDrivers()
   {
      return this.drivers;
   }
   
   public void loadDrivers()
   {
      int id, x, y;
      String name, description, phoneNumber;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(DRIVERS_FILE));
         String input;
         
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
            id = Integer.parseInt(in.readLine());
            name = in.readLine();
            phoneNumber = in.readLine();
            description = in.readLine();
            x = Integer.parseInt(in.readLine());
            y = Integer.parseInt(in.readLine());
            
            drivers[this.numDrivers] = new Driver(id, name, phoneNumber, description, x, y);   
            this.numDrivers++;
         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading drivers");
      }
   }
}


