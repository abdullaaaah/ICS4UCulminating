/*
   CLASS NAME: Item
   AUTHOR:     Abdullah Shahid, Oliver Huang, Uthman Mohamed
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores the information of the item sold by a restaurant
*/

public class Item
{
   protected String name;
   protected double price;
   
   
   /////////////////////////////////   CONSTRUCTOR(s)   /////////////////////////////////

   
   /*
      PARAMETERS:    the name of the item, the price of the item and the id of the restaurant it belongs to.
      PURPOSE:       Constructor for the Item object
   */ 
   public Item (String name, double price)
   {
      this.name = name;
      this.price = price;
   }
  
  
   /////////////////////////////////   ACCESSORS   /////////////////////////////////
 
 
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the items's name
      PURPOSE:       Acessor of the name field
   */
   public String getName()
   {
      return this.name;
   }
   
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the item's price
      PURPOSE:       Acessor of the price field
   */
   public double getPrice()
   {
      return this.price;
   }
   
   
   /////////////////////////////////   MUTATORS  /////////////////////////////////

   /*
      PARAMETERS:    No params
      RETURN VALUE:  Sets the item's name
      PURPOSE:       Mutator of the name field
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Sets the item's price
      PURPOSE:       Mutator of the price field
   */
   public void setPrice(double price)
   {
      this.price = price;
   }
   


   /////////////////////////////////   ADDITINAL /////////////////////////////////


   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the items name and price
      PURPOSE:       To help identify the item with necessary details while creating a menu to display to the customer.
   */  
   public String toString()
   {
      return "" + this.name + "\t\tPrice $" + price + " CAD";
   }
}