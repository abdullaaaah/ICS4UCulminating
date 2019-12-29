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
      loadUsers();
      
      //Map
      map = new Map(5,5); 
      map.addAllPositions(restaurants, numRestaurants, drivers, numDrivers);
      
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
   
   public int getDRIVERS()
   {
      return this.MAX_DRIVERS;
   }
   
   public void incrementNumDrivers()
   {
      this.numDrivers++;
   }
   
   public void decrementNumDrivers()
   {
      this.numDrivers--;
   }
   
   /*
      PARAMETERS:    -
      RETURN VALUE:  true or false depending on the result
      PURPOSE:       Indicates if a restaurant exists in the database given the name
  */
   public boolean doesDriverExist(int id)
   {
         
      for(int i = 0; i<numDrivers; i++)
      {
         if(this.drivers[i].getId() == id)
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
   public int findDriverIndex(int id)
   {
         
      for(int i = 0; i<numDrivers; i++)
      {
         if(this.drivers[i].getId() == id)
         {
            return i;
         }
      }
      
      return -1;  //-1 is returned if item does not exist.
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
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the restaurants in the database to the file.
  */ 
   public void saveDrivers()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(DRIVERS_FILE, false));
         out.write(Integer.toString(this.numDrivers));
         out.newLine();
         
         for(int i = 0; i<this.numDrivers; i++)
         {
            out.write(Integer.toString(drivers[i].getId()) );
            out.newLine();
            out.write(drivers[i].getName());
            out.newLine();
            out.write(drivers[i].getPhoneNumber());
            out.newLine();
            out.write(drivers[i].getDescription());
            out.newLine();
            out.write(Integer.toString( drivers[i].getPositionX()) );
            out.newLine();
            out.write(Integer.toString( drivers[i].getPositionY()) );
            out.newLine();
         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to driver database");
      }
   }



   public void addDriver (Driver dri)
   {
   }
   public void addCoupon (Coupon cou)
   {
   }
   
   
   /////////////////////////////////   USER RELATED   /////////////////////////////////

      
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public void addUser(String name, String username, String password) // can also rename it to register.
   {
   
      if(doesUserExist(username))
      {
         System.out.println("Error: User with the username " + username + " already exists.");
      }
      else if( numUsers == MAX_USERS )
      {
         System.out.println("Error: This software can not store any more users");
      }
      else
      {
         users[numUsers] = new Customer(name, username, User.encrypt(password));
         numUsers++;
         saveUsers();
      }
   }
   
   
   public boolean login(String username, String password)
   {
      int index = findUserIndexByUserName(username);
      
      if(index == -1)
      {
         System.out.println("Error: Incorrect username");
         return false;
      }
      else
      {
         if(users[index].getPassword().equals( User.encrypt(password) ))
         {
            this.userLoggedIn = users[index];
            return true;
         }
         else
         {
            System.out.println("Error: Incorrect passsword");
            //Remove this when program is close to finish
            System.out.println("Password enetered: " + User.encrypt(password));
            System.out.println("Password needed: " + users[index].getPassword());
            return false;
         }
      }
   }
   
      
   /*
      PARAMETERS:    The name of the restaurant to be found
      RETURN VALUE:  true or false depending on the result
      PURPOSE:       Indicates if a restaurant exists in the database given the name
  */
   public boolean doesUserExist(String username)
   {
         
      for(int i = 0; i<numUsers; i++)
      {
         if(this.users[i].getUsername().equalsIgnoreCase(username))
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
   public int findUserIndexByUserName(String username)
   {
         
      for(int i = 0; i<numUsers; i++)
      {
         if(this.users[i].getUsername().equalsIgnoreCase(username))
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
   public void loadUsers()
   {
      
      String name, username, password, type;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(USERS_FILE));
                  
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
                     
            name = in.readLine();
            username = in.readLine();
            password = in.readLine();
            type = in.readLine();
                        
            if(type.equalsIgnoreCase("customer"))
               users[this.numUsers] = new Customer(name, username, password); 
            else
               users[this.numUsers] = new Admin(name, username, password);  
            
            this.numUsers++;

         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading users");
      }
   }
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the restaurants in the database to the file.
  */ 
   public void saveUsers()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(USERS_FILE, false));
         out.write(Integer.toString(this.numUsers));
         out.newLine();
         
         for(int i = 0; i<this.numUsers; i++)
         {
            out.write(users[i].getName());
            out.newLine();
            out.write( users[i].getUsername() );
            out.newLine();
            out.write( users[i].getPassword() );
            out.newLine();
            if(users[i] instanceof Customer)
               out.write("customer");
            else
               out.write("admin");
            
            out.newLine();
            

         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to item database");
      }
   }
   
   
   public boolean isUserCustomer()
   {
      if(this.userLoggedIn instanceof Customer)
      {
         return true;
      }
      
      return false;
   }
   
}


