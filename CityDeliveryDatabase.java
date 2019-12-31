import java.io.*;

public class CityDeliveryDatabase
{
<<<<<<< HEAD
   protected User userLoggedIn;
   protected Restaurant[] restaurants;
   protected User[] users;
   protected Coupon[] coupons;
   protected Order[] orders;
   protected Driver[] drivers; 
   protected Map map;
   protected final double DELIVERY_FEE = 1;
   protected final double TAX_RATE = 0.13;
   protected final String USERS_FILE = "users.txt";
   protected final String RESTAURANTS_FILE = "restaurants.txt";
   protected final String COUPONS_FILE = "coupons.txt";
   protected final String WALLETS_FILE = "wallets.txt";
   protected final String CARDS_FILE = "cards.txt";
   protected final String DRIVERS_FILE = "drivers.txt";
   protected final int MAX_RESTAURANTS = 6;
   protected int numRestaurants;
   protected final int MAX_DRIVERS = 5;
   protected int numDrivers;
   protected final int MAX_USERS = 50;
   protected int numUsers;
   protected final int MAX_COUPONS = 50;
   protected int numCoupons;
=======
   private User userLoggedIn;
   private Restaurant[] restaurants;
   private User[] users;
   private Coupon[] coupons;
   private Order[] orders;
   private Driver[] drivers; 
   private Wallet[] wallets;
   private Map map;
   private final double DELIVERY_FEE = 1;
   private final double TAX_RATE = 0.13;
   private final String USERS_FILE = "users.txt";
   private final String RESTAURANTS_FILE = "restaurants.txt";
   private final String COUPONS_FILE = "coupons.txt";
   private final String WALLETS_FILE = "wallets.txt";
   private final String CARDS_FILE = "cards.txt";
   private final String DRIVERS_FILE = "drivers.txt";
   private final String DIRECTORY = "database/";
   private final int MAX_RESTAURANTS = 6;
   private int numRestaurants;
   private final int MAX_DRIVERS = 5;
   private int numDrivers;
   private final int MAX_USERS = 50;
   private int numUsers;
   private final int MAX_COUPONS = 50;
   private int numCoupons;
   private int numWallets;
>>>>>>> 3e46fff0035d92c184c02436dd4bd7104111ef37
   
   /////////////////////////////////   CONSTRUCTOR(s) /////////////////////////////////

   
   public CityDeliveryDatabase()
   {
      
      //Restaurants  
      this.restaurants = new Restaurant[MAX_RESTAURANTS];
      this.numRestaurants = 0;
      
      //Creating a restaurants file if not exist
      File restaurantsFile = new File(DIRECTORY+RESTAURANTS_FILE);
      if(!restaurantsFile.exists())
      {
         try
         {
            restaurantsFile.createNewFile();
            saveRestaurants(); // This will write 0 on the file.
            
         } catch(IOException e)
         {
            System.out.println("Error creating restaurants database");
         }
      }
      else
      {
         loadRestaurants();
      }
      
      //Drivers
      this.drivers = new Driver[MAX_DRIVERS];
      this.numDrivers = 0;
      
      //Creating a drivers file if not exist
      File driversFile = new File(DIRECTORY+DRIVERS_FILE);
      if(!driversFile.exists())
      {
         try
         {
            driversFile.createNewFile();
            saveDrivers(); // This will write 0 on the file.
            
         } catch(IOException e)
         {
            System.out.println("Error creating drivers database");
         }
      }
      else
      {
         loadDrivers();
      }
      
      //Users
      this.users = new User[MAX_USERS];
      this.numUsers = 0;
            
      //Creating a users file if not exist
      File usersFile = new File(DIRECTORY+USERS_FILE);
      if(!usersFile.exists())
      {
         try
         {
            usersFile.createNewFile();
            saveUsers(); // This will write 0 on the file.
            
         } catch(IOException e)
         {
            System.out.println("Error creating users database");
         }
      }
      else
      {
         loadUsers();
      }
            
      //Coupons
      this.coupons = new Coupon[MAX_COUPONS];
      this.numCoupons = 0;
      
      //Creating a coupons file if not exist
      File couponsFile = new File(DIRECTORY+COUPONS_FILE);
      if(!couponsFile.exists())
      {
         try
         {
            couponsFile.createNewFile();
            saveCoupons(); // This will write 0 on the file.
            
         } catch(IOException e)
         {
            System.out.println("Error creating coupons database");
         }
      }
      else
      {
         loadCoupons();
      }
      
      //wallets
      this.wallets = new Wallet[MAX_USERS];
      this.numWallets = 0;

      //Creating a wallets file if not exist
      File walletsFile = new File(DIRECTORY+WALLETS_FILE);
      if(!walletsFile.exists())
      {
         try
         {
            walletsFile.createNewFile();
            saveWallets(); // This will write 0 on the file.
            
         } catch(IOException e)
         {
            System.out.println("Error creating wallets database");
         }
      }
      else
      {
         loadWallets();
      }

      
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
   //Status: Finished

   

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
         BufferedReader in = new BufferedReader(new FileReader(DIRECTORY+RESTAURANTS_FILE));
                  
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
         BufferedWriter out = new BufferedWriter(new FileWriter(DIRECTORY+RESTAURANTS_FILE, false));
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
   
   public int getMAX_DRIVERS()
   {
      return this.MAX_DRIVERS;
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
         BufferedReader in = new BufferedReader(new FileReader(DIRECTORY+DRIVERS_FILE));
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
         BufferedWriter out = new BufferedWriter(new FileWriter(DIRECTORY+DRIVERS_FILE, false));
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
   
   

   /////////////////////////////////   USER RELATED   /////////////////////////////////
   //Status: Finished, maybe some additional methods here and there

      
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public boolean register(String name, String username, String password)
   {
   
      if(doesUserExist(username))
      {
         System.out.println("Error: User with the username " + username + " already exists.");
         return false;
      }
      else if( numUsers == MAX_USERS )
      {
         System.out.println("Error: This software can not store any more users");
         return false;
      }
      else
      {
         users[numUsers] = new Customer(name, username, User.encrypt(password));
         numUsers++;
         saveUsers();
         
         wallets[numWallets] = new Wallet(username, 0);
         numWallets++;
         saveWallets();
         
         return true;
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
         BufferedReader in = new BufferedReader(new FileReader(DIRECTORY+USERS_FILE));
                  
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
         BufferedWriter out = new BufferedWriter(new FileWriter(DIRECTORY+USERS_FILE, false));
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
   
   public void logout()
   {
      
   }
   
   
   /////////////////////////////////   COUPON RELATED   /////////////////////////////////

   
   
   public int getNumCoupons()
   {
      return this.numCoupons;
   }
   
   public Coupon[] getCoupons()
   {
      return this.coupons;
   }
   
   public int getMAX_COUPONS()
   {
      return this.MAX_COUPONS;
   }
   
   public void incrementNumCoupons()
   {
      this.numCoupons++;
   }
   
   public void decrementNumCoupons()
   {
      this.numCoupons--;
   }
   
   /*
      PARAMETERS:    -
      RETURN VALUE:  true or false depending on the result
      PURPOSE:       Indicates if a restaurant exists in the database given the name
  */
   public boolean doesCouponExist(String code)
   {
         
      for(int i = 0; i<numCoupons; i++)
      {
         if(this.coupons[i].getCode().equals(code))
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
   public int findCouponIndex(String code)
   {
         
      for(int i = 0; i<numCoupons; i++)
      {
         if(this.coupons[i].getCode().equals(code))
         {
            return i;
         }
      }
      
      return -1;  //-1 is returned if item does not exist.
   }
   
   public void loadCoupons()
   {
      String code;
      double discount;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(DIRECTORY+COUPONS_FILE));
         String input;
         
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
            code = in.readLine();
            discount = Double.parseDouble(in.readLine());
            
            coupons[this.numCoupons] = new Coupon(code, discount);   
            this.numCoupons++;
         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading Coupons");
      }
   }
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the restaurants in the database to the file.
  */ 
   public void saveCoupons()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(DIRECTORY+COUPONS_FILE, false));
         out.write(Integer.toString(this.numCoupons));
         out.newLine();
         
         for(int i = 0; i<this.numCoupons; i++)
         {
            out.write(coupons[i].getCode());
            out.newLine();
            out.write(Double.toString( coupons[i].getDiscountRate()) );
            out.newLine();
         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to coupon database");
      }
   }
   
      /////////////////////////////////   WALLET RELATED   /////////////////////////////////

   public void loadWallets()
   {
      String customer;
      double balance;
   
      try {
         BufferedReader in = new BufferedReader(new FileReader(DIRECTORY+WALLETS_FILE));
         
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
            customer = in.readLine();
            balance = Double.parseDouble(in.readLine());
            
            wallets[this.numWallets] = new Wallet(customer, balance);   
            this.numWallets++;
         }
      
      } catch(IOException e)
      {
         System.out.println("Error loading Wallets");
      }
   }
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the restaurants in the database to the file.
  */ 
   public void saveWallets()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(DIRECTORY+WALLETS_FILE, false));
         out.write(Integer.toString(this.numWallets));
         out.newLine();
         
         for(int i = 0; i<this.numWallets; i++)
         {
            out.write(wallets[i].getCustomer());
            out.newLine();
            out.write(Double.toString( wallets[i].getBalance()) );
            out.newLine();
         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to wallets database");
      }
   }

}


