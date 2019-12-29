/*
   CLASS NAME: Admin
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information about a special type of user called admin. This user has special methods that allow it to make changes to the database.
               For security purposes, the addition, removal, and modification of such objects like restaurant, drivers, and coupons in the database is only possible
               with the admin object.
*/
public class Admin extends User
{


   /////////////////////////////////   CONSTRUCTOR(s) /////////////////////////////////
   /*
      PARAMETERS:    Name of the person, username to login with, password to login with
      PURPOSE:       Creat Admin object
   */
   public Admin (String name, String username, String password)
   {
      super(name, username, password);
   }
   
   
   
   /////////////////////////////////   RESTAURANT RELATED   /////////////////////////////////
   
   /*
      PARAMETERS:    The database object, name, category, rating, number of raters, position X and position Y of the restaurant
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to the restaurant list & save it in the database.
   */
   public void addRestaurant (CityDeliveryDatabase db, String name, String category, double rating, int numRating, int positionX, int positionY)
   {
   
      if(db.doesRestaurantExist(name)) //Check if restaurant with this name already exists
      {
         System.out.println("Error: Restaurant with the name " + name + " already exists.");
      }
      else if( db.getNumRestaurants() == db.getMAX_RESTAURANTS() ) //Check if the software has reached the maximum number of restaurants to be stored
      {
         System.out.println("Error: This restaurant can not store any more items");
      }
      /////////////  Remove this if we take care of position check during runtime /////////////
      else if( !db.getMap().doesPositionExist(positionX, positionY) || db.getMap().isOccupied(positionX, positionY) ) //Check if the given position is taken by another object
      {
         System.out.println("Error: Position taken by another object or invalid position provided");
      }
      else
      {
         db.getRestaurants()[db.getNumRestaurants()] = new Restaurant(name, positionX, positionY, category, rating, numRating); 
         db.incrementNumRestaurants(); 
         db.saveRestaurants();
      }
   }
   
   
   /*
      PARAMETERS:    The database and the name of the restaurant
      RETURN VALUE:  void
      PURPOSE:       Remove a restaurant from the list
   */
   public void removeRestaurant(CityDeliveryDatabase db, String name)
   {
      int temp = db.findRestaurantIndexByName(name);
      
      if(db.getNumRestaurants() >0 && temp != -1)
      {
         db.getRestaurants()[temp] = null;
         
         for(int i = temp; i<db.getNumRestaurants()-1; i++)
         {
            db.getRestaurants()[i] = db.getRestaurants()[i+1];
            db.getRestaurants()[i+1] = null;
         }
         
         db.decrementNumRestaurants();
         db.saveRestaurants();
         
         System.out.println("Success: Restaurant removed");
      }
      else
      {
         System.out.println("Error: Restaurant does not exist");
      }

   }
   
   /////////////////////////////////   DRIVER RELATED   /////////////////////////////////   
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public void addDriver(CityDeliveryDatabase db, int id, String name, String phoneNumber, String description, int positionX, int positionY)
   {
   
      if(db.doesDriverExist(id))
      {
         System.out.println("Error: Driver with the id " + id + " already exists."); //although ids are gonna be unique so..
      }
      else if( db.getNumDrivers() == db.getMAX_DRIVERS() )
      {
         System.out.println("Error: This software can not store any more drivers");
      }
      else if( !db.getMap().doesPositionExist(positionX, positionY) || db.getMap().isOccupied(positionX, positionY) )
      {
         System.out.println("Error: Position taken by another object or invalid position provided");
      }
      else
      {
         db.getDrivers()[db.getNumDrivers()] = new Driver(id, name, phoneNumber, description, positionX, positionY); 
         db.incrementNumDrivers(); 
         db.saveDrivers();
      }
   }
   
   
   /*
      PARAMETERS:    -
      RETURN VALUE:  void
      PURPOSE:       -
   */
   public void removeDriver(CityDeliveryDatabase db, int id)
   {
      int temp = db.findDriverIndex(id);
      
      if(db.getNumDrivers() >0 && temp != -1)
      {
         db.getDrivers()[temp] = null;
         
         for(int i = temp; i<db.getNumDrivers()-1; i++)
         {
            db.getDrivers()[i] = db.getDrivers()[i+1];
            db.getDrivers()[i+1] = null;
         }
         
         db.decrementNumDrivers();
         db.saveDrivers();
         
         System.out.println("Success: Driver removed");
      }
      else
      {
         System.out.println("Error: Driver does not exist");
      }

   }
   
   /////////////////////////////////   COUPON RELATED  /////////////////////////////////   
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public void addCoupon(CityDeliveryDatabase db, String code, double discount)
   {
      
      if(db.doesCouponExist(code))
      {
         System.out.println("Error: Coupon with the code " + code + " already exists.");
      }
      else if( db.getNumCoupons() == db.getMAX_COUPONS() )
      {
         System.out.println("Error: This software can not store any more coupons");
      }
      else
      {
         db.getCoupons()[db.getNumCoupons()] = new Coupon(code, discount); 
         db.incrementNumCoupons(); 
         db.saveCoupons();
      }
   }
   
   
   /*
      PARAMETERS:    -
      RETURN VALUE:  void
      PURPOSE:       -
   */
   public void removeCoupon(CityDeliveryDatabase db, String code)
   {
      int temp = db.findCouponIndex(code);
      
      if(db.getNumCoupons() >0 && temp != -1)
      {
         db.getCoupons()[temp] = null;
         
         for(int i = temp; i<db.getNumCoupons()-1; i++)
         {
            db.getCoupons()[i] = db.getCoupons()[i+1];
            db.getDrivers()[i+1] = null;
         }
         
         db.decrementNumDrivers();
         db.saveDrivers();
         
         System.out.println("Success: Driver removed");
      }
      else
      {
         System.out.println("Error: Driver does not exist");
      }

   }  
   
  
}