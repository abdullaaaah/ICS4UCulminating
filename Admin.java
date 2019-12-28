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
         System.out.println("Error: This restaurant can not store any more items");
      }
      else if( !db.getMap().doesPositionExist(positionX, positionY) || db.getMap().isOccupied(positionX, positionY) )
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
      PARAMETERS:    -
      RETURN VALUE:  void
      PURPOSE:       -
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
   
   
   
   
   
   
   
  
}