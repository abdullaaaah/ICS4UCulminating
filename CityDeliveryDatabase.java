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
   private final int MAX_USERS = 50;
   private int numUsers;
   
   /////////////////////////////////   CONSTRUCTOR(s) /////////////////////////////////

   
   public CityDeliveryDatabase()
   {
      //Map
      map = new Map(5,5); 
      
      //Restaurants  
      this.restaurants = new Restaurant[MAX_RESTAURANTS];
      this.numRestaurants = 0;
      loadRestaurants();
      
      //Drivers
      this.drivers = new Driver[MAX_DRIVERS];
      this.numDrivers = 0;
      
      //Users
      this.users = new User[MAX_USERS];
      this.numUsers = 0;
      
   }
   
   /////////////////////////////////   MAP RELATED   /////////////////////////////////

   public Map getMap()
   {
      return map;
   }
   
   
   /////////////////////////////////   RESTAURANT RELATED   /////////////////////////////////

   

   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the number of restaurants in database
      PURPOSE:       Acessor of the numRestaurant field
   */
   public int getNumRestaurants()
   {
      return this.numRestaurants;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns all of the restaurants in the database
      PURPOSE:       Acessor of the restaurants field
   */
   public Restaurant[] getRestaurants()
   {
      return this.restaurants;
   }
   
   public int getMAX_RESTAURANTS()
   {
      return this.MAX_RESTAURANTS;
   }
   
   public void incrementNumRestaurants()
   {
      this.numRestaurants++;
   }
   
   public void decrementNumRestaurants()
   {
      this.numRestaurants--;
   }
   
   
   /*
      PARAMETERS:    The name of the restaurant to be found
      RETURN VALUE:  true or false depending on the result
      PURPOSE:       Indicates if a restaurant exists in the database given the name
  */
   public boolean doesRestaurantExist(String name)
   {
         
      for(int i = 0; i<numRestaurants; i++)
      {
         if(this.restaurants[i].getName().equalsIgnoreCase(name))
         {
            return true;
         }
      }
      
      return false;
   }
   
   /*
      PARAMETERS:    The name of the restaurant to be found
      RETURN VALUE:  the index of the restaurant or -1 if not found
      PURPOSE:       Returns the index of the restaurant to be found by name
  */
   public int findRestaurantIndexByName(String name)
   {
         
      for(int i = 0; i<numRestaurants; i++)
      {
         if(this.restaurants[i].getName().equalsIgnoreCase(name))
         {
            return i;
         }
      }
      
      return -1;  //-1 is returned if item does not exist.
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  -
      PURPOSE:       Loads all the restaurants from the database
   */
   public void loadRestaurants()
   {
      
      int numRatings, x, y;
      String name, category;
      double rating;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(RESTAURANTS_FILE));
                  
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
                     
            name = in.readLine();
            category = in.readLine();
            rating = Double.parseDouble(in.readLine());
            numRatings = Integer.parseInt(in.readLine());
            x = Integer.parseInt(in.readLine());
            y = Integer.parseInt(in.readLine());
                        
            restaurants[this.numRestaurants] = new Restaurant(name, x, y, category, rating, numRatings);   
            this.numRestaurants++;
         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading restaurants");
      }
   }
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the restaurants in the database to the file.
  */ 
   public void saveRestaurants()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(RESTAURANTS_FILE, false));
         out.write(Integer.toString(this.numRestaurants));
         out.newLine();
         
         for(int i = 0; i<this.numRestaurants; i++)
         {
            out.write(restaurants[i].getName());
            out.newLine();
            out.write( restaurants[i].getCategory() );
            out.newLine();
            out.write( Double.toString( restaurants[i].getRating() ) );
            out.newLine();
            out.write( Integer.toString( restaurants[i].getNumRating()) );
            out.newLine();
            out.write( Integer.toString( restaurants[i].getPositionX()) );
            out.newLine();
            out.write( Integer.toString( restaurants[i].getPositionY()) );
            out.newLine();
         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to item database");
      }
   }
   
   /////////////////////////////////   DRIVER RELATED   /////////////////////////////////

   
   
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

   public void addDriver (Driver dri)
   {
   }
   public void addCoupon (Coupon cou)
   {
   }
   
}


