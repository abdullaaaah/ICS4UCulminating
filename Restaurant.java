/*
   CLASS NAME: Restaurant
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores each individual restaurant’s information which can then be used by the customer to order from.
*/

public class Restaurant
{
   protected int id;
   protected String name;
   protected positionX;
   protected positionY;
   protected Item[] menu;
   protected int numItem;
   protected String category;
   protected double rating;
   protected int numRating;
   protected final MAX_ITEMS = 10;
   
   /*
      PARAMETERS:    the unique id, name of the restaurant, X'th position, Y'th position, category & rating
      PURPOSE:       Constructor for the Restaurant object
   */ 
   public Restaurant (int id, String name, PositionX, PositionY, String category, double rating)
   {
      this.id = id;
      this.name = name;
      this.location = location;
      this.menu = menu;
      this.category = category;
      this.rating = rating;
      this.numRating = 0;
      
      menu = new Item[MAX_ITEMS];
      this.numItem = 0;
   }
   
   
    /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the menu array in the class
      PURPOSE:       Acessor of the menu field
   */
   public Item[] getMenu()
   {
      return menu;
   }
   
      
    /*
      PARAMETERS:    No params
      RETURN VALUE:  void
      PURPOSE:       loads every item that belongs to this restaurant into the menu array
   */
   public void getMenuFromFile()
   {
   
   }
   
      
   /*
      PARAMETERS:    Name of the item, price of the item
      RETURN VALUE:  void
      PURPOSE:       Creates an Item object and adds it to the menu
   */
   public void addItem(String name, double price)
   {
   
   }
   

   /*
      PARAMETERS:    Name of the item
      RETURN VALUE:  void
      PURPOSE:       Removes an item using it's name from the menu
   */
   public void removeItem(String name)
   {
   
   }
   
   /*
      PARAMETERS:    The object Item, new name of the item, new price of the item
      RETURN VALUE:  void
      PURPOSE:       Edits an Item object
  */
   public void editItem(Item item, String name, double price)
   {
   
   }
   
   /*
      PARAMETERS:    the rating from 1 to 5
      RETURN VALUE:  void
      PURPOSE:       Adds the rating to rating field
  */
   public void addRating(double rating)
   {
   
   }
   
   /*
      PARAMETERS:    None
      RETURN VALUE:  the value of the rating
      PURPOSE:       A special type of accessor that returns the rating divided by the number of times its rated
   */
   public double getRating()
   {
   
   }
   
}