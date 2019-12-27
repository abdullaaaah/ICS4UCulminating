
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
   protected int positionX;
   protected int positionY;
   protected Item[] menu;
   protected int numItem;
   protected String category;
   protected double rating;
   protected int numRating;
   protected final int MAX_ITEMS = 10;
   protected final String FILE_ENDING = ".items.txt";
   
   /*
      PARAMETERS:    the unique id, name of the restaurant, X'th position, Y'th position, category & rating
      PURPOSE:       Constructor for the Restaurant object
   */ 
   public Restaurant (int id, String name, int PositionX, int PositionY, String category, double rating, int numRating)
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
         } catch(IOException e)
         {
            System.out.println("Error creating item database");
         }
      }
   }
   
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
   
   public int getPositionX()
   {
      return positionX;
   }
   
   public int getPositionY()
   {
      return positionY;
   }
   
      
    /*
      PARAMETERS:    No params
      RETURN VALUE:  void
      PURPOSE:       loads every item that belongs to this restaurant into the menu array
   */
   public void getMenuFromFile()
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
      PARAMETERS:    Name of the item, price of the item
      RETURN VALUE:  void
      PURPOSE:       Creates an Item object and adds it to the menu
   */
   public void addItem(String name, double price)
   {
      this.menu[numItem] = new Item(name, price, this.id); 
      numItem++;  
   }
   
   
   private int findItemByName(String name)
   {
         
      for(int i = 0; i<numItem; i++)
      {
         if(this.menu[i].getName() == name)
         {
            return i;
         }
      }
      
      return -1;
   }
   


   /*
      PARAMETERS:    Name of the item
      RETURN VALUE:  void
      PURPOSE:       Removes an item using it's name from the menu
   */
   public void removeItem(String name)
   {
      int temp = findItemByName(name);
      
      if(numItem>0 && temp != -1)
      {
         menu[temp] = null;
         
         for(int i = temp; temp<numItem-1; i++)
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
      PARAMETERS:    -
      RETURN VALUE:  void
      PURPOSE:       -
  */ 
   public void saveMenu()
   {
      try
      {
         BufferedWriter out = new BufferedWriter(new FileWriter(this.id+FILE_ENDING, true));
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
   
   /*
      PARAMETERS:    the rating from 1 to 5
      RETURN VALUE:  void
      PURPOSE:       Adds the rating to rating field
  */
   public void addRating(double rating)
   {
      this.rating += rating;
      this.numRating++;
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
   
}