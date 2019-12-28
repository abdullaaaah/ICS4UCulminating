public class Admin extends User
{
   // Constructor ///////////////////////////////
   /*
      PARAMETERS:    Actual name, username, password
      RETURN VALUE:  N/A
      PURPOSE:       Creat Amin object
   */
   public Admin (String name, String username, String password)
   {
      super(name, username, password);
   }
   
   /////////////////////////////////   RESTAURANT RELATED   /////////////////////////////////
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public void addRestaurant (CityDeliveryDatabase db, String name, String category, double rating, int numRating, int positionX, int positionY)
   {
   
      if(db.doesRestaurantExist(name))
      {
         System.out.println("Error: Restaurant with the name " + name + " already exists.");
      }
      else if( db.getNumRestaurants() == db.getMAX_RESTAURANTS() )
      {
         System.out.println("Debug: " + db.getNumRestaurants() + " == " + db.getMAX_RESTAURANTS() );
         System.out.println("Error: This restaurant can not store any more items");
      }
      else
      {
         db.getRestaurants()[db.getNumRestaurants()] = new Restaurant(name, positionX, positionY, category, rating, numRating); 
         db.incrementNumRestaurants(); 
         db.saveRestaurants();
      }
   }
   
   
   
   /////////////////////////////////////////////
   /*
      PARAMETERS:    Restaurant list, actual restaurant
      RETURN VALUE:  N/A
      PURPOSE:       Delete selected restaurant from existing list
   */
   public void deleteRestaurant (Restaurant[] restaurants, Restaurant res)
   {
      for (int i = 0; i < restaurants.length; i++)
      {
         if (restaurants[i].getName() == res.getName())
         {
            restaurants[i] = null;
         }
      }
      boolean found = false;
      for (int i = 1; i < restaurants.length; i++)
      {
         if (restaurants[i] == null)
         {
            found = true;
         }
         else if (found)
         {
            restaurants[i - 1] = restaurants[i];
         }
      }
   }
   
   
   
   
   
   
   
  
}