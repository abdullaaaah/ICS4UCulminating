/*
   CLASS NAME: Restaurant
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores each individual restaurant’s information which can then be used by the customer to order from.
*/

import java.io.*;

public class Restaurant
{
   protected int id;
   protected String name;
   private int positionX;
   private int positionY;
   protected Item[] menu;
   protected int numItem;
   protected String category;
   protected double rating;
   protected int numRating;
   protected final int MAX_ITEMS = 10;
   protected final String FILE_ENDING = ".items.txt";
   
   /////////////////////////////////   CONSTRUCTOR(s) /////////////////////////////////
   
   /*
      PARAMETERS:    the unique id, name of the restaurant, X'th position, Y'th position, category & rating
      PURPOSE:       Constructor for the Restaurant object
   */ 
   public Restaurant (int id, String name, int positionX, int positionY, String category, double rating, int numRating)
   {
      this.id = id;
      this.name = name;
      this.positionX = positionX;
      this.positionY = positionY;
      this.category = category;
      this.rating = rating;
      this.numRating = numRating;
            
      menu = new Item[MAX_ITEMS];
      this.numItem = 0;
      
      //Creating a items database if doesnt exists
      File itemDatabase = new File(this.id+FILE_ENDING);
      if(!itemDatabase.exists())
      {
         try
         {
            itemDatabase.createNewFile();
            saveMenu(); // This will write 0 on the file.
         } catch(IOException e)
         {
            System.out.println("Error creating item database");
         }
      }
      else
      {
         loadMenuFromFile(); //Check later, what if file is empty?
      }
   }
   
   
      /////////////////////////////////  ACCESSORS  /////////////////////////////////

   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the restaurant's name
      PURPOSE:       Acessor of the name field
   */
   public String getName()
   {
      return this.name;
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
      RETURN VALUE:  Returns the positionX field value
      PURPOSE:       Acessor of the positionX field
   */
   public int getPositionX()
   {
      return positionX;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the positionY field value
      PURPOSE:       Acessor of the positionY field
   */
   public int getPositionY()
   {
      return positionY;
   }
   
   /*
      PARAMETERS:    None
      RETURN VALUE:  the value of the rating
      PURPOSE:       A special type of accessor that returns the rating divided by the number of times its rated
   */
   public double getRating()
   {
      return this.rating / this.numRating;
   }
   
      /////////////////////////////////  MUTATORS /////////////////////////////////
   
 
   /*
      PARAMETERS:    the rating from 1 to 5
      RETURN VALUE:  void
      PURPOSE:       Adds the rating to rating field and increases the numRating
  */
   public void addRating(double rating)
   {
      
      if(rating > 5 && rating < 1)
      {
         System.out.println("Error: Please provide a rating between 1 and 5");
      }
      else
      {
         this.rating += rating;
         this.numRating++;
         System.out.println("Success: Rating entered");
      }
   }
   
      /////////////////////////////////  ITEM MANAGEMENT /////////////////////////////////

   
   /*
      PARAMETERS:    Name of the item, price of the item
      RETURN VALUE:  void
      PURPOSE:       Creates an Item object and adds it to the menu
   */
   public void addItem(String name, double price)
   {
      if(doesItemExist(name))
      {
         System.out.println("Error: Item with the name " + name + " already exists.");
      }
      else if(numItem==MAX_ITEMS)
      {
         System.out.println("Error: This restaurant can not store any more items");
      }
      else
      {
         this.menu[numItem] = new Item(name, price, this.id); 
         numItem++; 
      }
   }
   
   
   /*
      PARAMETERS:    Name of the item
      RETURN VALUE:  void
      PURPOSE:       Removes an item using it's name from the menu
   */
   public void removeItem(String name)
   {
      int temp = findItemIndexByName(name);
      
      if(numItem>0 && temp != -1)
      {
         menu[temp] = null;
         
         for(int i = temp; temp<numItem-1; i++) //This loop begings from where the item has been removed and shifts each down so there is no empty(null) gap between objects.
         {
            menu[i] = menu[i+1];
            menu[i+1] = null;
         }
      }
   }
   
   /*
      PARAMETERS:    The object Item, new name of the item, new price of the item
      RETURN VALUE:  void
      PURPOSE:       Edits an Item object
  */
   public void editItem(Item item, String name, double price)
   {
      item.setName(name);
      item.setPrice(price);
   }
   
   
   /*
      PARAMETERS:    The name of the item to be found
      RETURN VALUE:  the index of the item or -1 if not found
      PURPOSE:       Returns the index of the item to be found by name
  */
   private int findItemIndexByName(String name)
   {
         
      for(int i = 0; i<numItem; i++)
      {
         if(this.menu[i].getName().equalsIgnoreCase(name))
         {
            return i;
         }
      }
      
      return -1;  //-1 is returned if item does not exist.
   }
   
   /*
      PARAMETERS:    The name of the item to be found
      RETURN VALUE:  true or false depending on the result
      PURPOSE:       Indicates if an item exists in the menu given the name
  */
   public boolean doesItemExist(String name)
   {
         
      for(int i = 0; i<numItem; i++)
      {
         if(this.menu[i].getName().equalsIgnoreCase(name))
         {
            return true;
         }
      }
      
      return false;
   }
   
   
    /*
      PARAMETERS:    No params
      RETURN VALUE:  void
      PURPOSE:       loads every item that belongs to this restaurant into the menu array
   */
   public void loadMenuFromFile()
   {
      String name;
      double price;
      int restaurantID;
      
      try
      {
         BufferedReader in = new BufferedReader(new FileReader(this.id+FILE_ENDING));
         String input;
         
         int numToLoad = Integer.parseInt(in.readLine());
         
         for(int i = 0; i<numToLoad; i++)
         {
            name = in.readLine();
            price = Double.parseDouble(in.readLine());
            restaurantID = Integer.parseInt(in.readLine());
            
            menu[numItem] = new Item(name, price, restaurantID);
            numItem++;
         }

      
      } catch(IOException e)
      {
         System.out.println("Error loading items from file");
      }
      
   }
   
   
  /*
      PARAMETERS:    None
      RETURN VALUE:  None
      PURPOSE:       Save all of the items in the menu to the file.
  */ 
   public void saveMenu()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(this.id+FILE_ENDING, false));
         out.write(Integer.toString(this.numItem));
         out.newLine();
         
         for(int i = 0; i<this.numItem; i++)
         {
            out.write(menu[i].getName());
            out.newLine();
            out.write( Double.toString(menu[i].getPrice()) );
            out.newLine();
            out.write( Integer.toString(menu[i].getRestaurantID()) );
            out.newLine();

         }
         
         out.close();
         
      }
      catch(IOException e)
      {
         System.out.println("Error writing to item database");
      }
   }
   

   
}